package dino.one.ruphotel.repository;

import dino.one.ruphotel.model.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by prgres on 2018-12-11.
 */

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
//    List<Room> findAllByReservation_ArrivalLessThanEqualAndReservation_ArrivalGreaterThanEqual(Date endDate, Date startDate);
}

