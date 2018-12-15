package dino.one.ruphotel.service;

import dino.one.ruphotel.model.Reservation;
import dino.one.ruphotel.model.Room;
import dino.one.ruphotel.model.RoomType;
import dino.one.ruphotel.model.dto.AvailableRoomsDto;
import dino.one.ruphotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by prgres on 2018-12-11.
 */

@Service
@Transactional
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    @PersistenceContext
    EntityManager entityManager;


    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    public Room testmethod() {
        entityManager.getTransaction().begin();
        Room temp = new Room();
        Reservation reservation = new Reservation();

        temp.setId(6L);
        temp.setPrice(BigDecimal.valueOf(1243124));
        temp.setRoomType(entityManager.getReference(RoomType.class, 2L));

        roomRepository.save(temp);
//        entityManager.persist(temp);
//        entityManager.flush();
        entityManager.merge(temp);
        entityManager.getTransaction().commit();
        return temp;
    }

    public List<Room> findAvailableRooms(AvailableRoomsDto availableRoomsDto) {
        return roomRepository.
                findAllByReservation_ArrivalLessThanEqualAndReservation_ArrivalGreaterThanEqual(
                        availableRoomsDto.getTo(),
                        availableRoomsDto.getFrom()
                );
    }
}
