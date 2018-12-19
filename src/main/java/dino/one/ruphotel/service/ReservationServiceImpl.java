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
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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
                                         List<Integer> roomList) {
        Reservation reservation = new Reservation();

        entityManager.setFlushMode(FlushModeType.COMMIT);

        reservation.setArrival(arrival);
        reservation.setDeparture(departure);
        reservation.setClient(client);
        reservation.setPriceForAllRooms(new BigDecimal(0));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");

        LocalDate firstDate = LocalDate.parse(arrival.toString(), formatter);
        LocalDate secondDate = LocalDate.parse(departure.toString(), formatter);
        long days = ChronoUnit.DAYS.between(firstDate, secondDate);

        roomList.forEach(e -> {
            Room temporaryRoom = entityManager.getReference(Room.class, new Long(e));
            reservation.getRoomList().add(temporaryRoom);
            reservation.setPriceForAllRooms(
                    reservation.getPriceForAllRooms().
                            add(temporaryRoom.getPrice().multiply(new BigDecimal(days))));
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
