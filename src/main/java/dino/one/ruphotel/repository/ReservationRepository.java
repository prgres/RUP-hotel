package dino.one.ruphotel.repository;

import org.springframework.stereotype.Repository;

/**
 * Created by prgres on 2018-12-17.
 */

@Repository
public interface ReservationRepository {
    void deleteById(Long id);
}
