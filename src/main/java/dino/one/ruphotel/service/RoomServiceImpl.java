package dino.one.ruphotel.service;

import dino.one.ruphotel.model.dto.AvailableRoomsDto;
import dino.one.ruphotel.model.persistance.Room;
import dino.one.ruphotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prgres on 2018-12-11.
 */

@Service
@Transactional
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public List<Room> findAvailableRoomsAlternative(AvailableRoomsDto availableRoomsDto) {
        List<Room> allRooms = roomRepository.findAll();
        System.out.println(allRooms);

        List<Room> avaible = new ArrayList<>();

        allRooms.forEach(e -> {
            if (availableRoomsDto.getPersonCount() >= e.getRoomType().getId()) {

                if (e.getReservation().isEmpty()) {
                    avaible.add(e);
                } else {
                    e.getReservation().forEach(f -> {

                        if (((availableRoomsDto.getTo().before(f.getArrival())) || (availableRoomsDto.getFrom().after(f.getDeparture())))) {
                            if (!avaible.contains(e)) {
                                avaible.add(e);
                            }
                        }
                    });
                }
            }
        });

        return avaible;
    }


    @Override
    public List<Room> findAvailableRooms(AvailableRoomsDto availableRoomsDto) {
        List<Room> fromRepo = roomRepository.
                findAllByReservation_ArrivalLessThanEqualOrReservation_DepartureGreaterThanEqualOrReservation_ArrivalIsNullOrReservation_DepartureIsNull(
                        availableRoomsDto.getTo(),
                        availableRoomsDto.getFrom()
                );

        List<Room> listToReturn = new ArrayList<>();

        fromRepo.forEach(e -> {
            if (e.getRoomType().getId() >= availableRoomsDto.getPersonCount()) {
                listToReturn.add(e);
            }
        });

        return listToReturn;

    }
}
