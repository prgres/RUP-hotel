package dino.one.ruphotel.service;

import dino.one.ruphotel.model.Room;
import dino.one.ruphotel.model.RoomType;
import dino.one.ruphotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;

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

    public void testmethod() {
        Room temp = new Room();

        temp.setId(6L);
        temp.setPrice(BigDecimal.valueOf(1243124));
        temp.setRoomType(entityManager.getReference(RoomType.class, 2L));

        entityManager.persist(temp);
        entityManager.flush();
    }

//    public List<Room> findAvaibleRooms(AvailableRoomsDto availableRoomsDto) {
//        return roomRepository.findAllByReservation_ArrivalLessThanEqualAndReservation_ArrivalGreaterThanEqual(availableRoomsDto.getTo(), availableRoomsDto.getFrom());
//    }
}
