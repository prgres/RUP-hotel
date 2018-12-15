package dino.one.ruphotel.repository;

import dino.one.ruphotel.model.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by prgres on 2018-12-11.
 */

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
    List<Room> findAll();

    List<Room> findAllByReservation_ArrivalLessThanEqualOrReservation_DepartureGreaterThanEqualOrReservation_ArrivalIsNullOrReservation_DepartureIsNull(Date endDate, Date startDate);


}

