package dino.one.ruphotel.repository;

import dino.one.ruphotel.model.persistance.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by prgres on 2018-12-17.
 */

@Repository
public interface ReservationRepository
        extends CrudRepository<Reservation, Long> {

    void deleteById(Long id);
}
