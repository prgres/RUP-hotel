package dino.one.ruphotel.service;

import dino.one.ruphotel.model.persistance.Client;
import dino.one.ruphotel.model.persistance.Reservation;
import dino.one.ruphotel.model.persistance.Room;
import dino.one.ruphotel.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

/**
 * Created by prgres on 2018-12-16.
 */

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

    private final
    ReservationRepository reservationRepository;
    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation createReservation(Date arrival,
                                         Date departure,
                                         Client client,
                                         List<Room> roomList) {
        Reservation reservation = new Reservation();

        entityManager.setFlushMode(FlushModeType.COMMIT);

        reservation.setArrival(arrival);
        reservation.setDeparture(departure);
        reservation.setClient(client);
//        reservation.getRoomList().addAll(roomList); //TODO: ad

        reservation.getRoomList().forEach(e -> {
            reservation.setPriceForAllRooms(
                    reservation.getPriceForAllRooms().
                            add(e.getPrice()));
        });

        entityManager.persist(reservation);
        entityManager.flush();

        return reservation;
    }

    @Override
    public void deleteById(Long id) {
        reservationRepository.deleteById(id);
    }
}
