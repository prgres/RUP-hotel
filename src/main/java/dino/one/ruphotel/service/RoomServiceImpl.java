package dino.one.ruphotel.service;

import dino.one.ruphotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by prgres on 2018-12-11.
 */

@Service
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

//    public List<Room> findAvaibleRooms(AvailableRoomsRequest availableRoomsRequest) {
//        return roomRepository.findAllByReservation_ArrivalLessThanEqualAndReservation_ArrivalGreaterThanEqual(availableRoomsRequest.getTo(), availableRoomsRequest.getFrom());
//    }
}
