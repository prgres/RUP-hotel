package dino.one.ruphotel.service;

import dino.one.ruphotel.model.Client;
import dino.one.ruphotel.model.NewClientRequest;
import dino.one.ruphotel.model.Reservation;
import dino.one.ruphotel.model.Room;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by prgres on 2018-12-12.
 */

@Service
//@Transactional
public class UserServiceImpl {

    @PersistenceContext
    EntityManager entityManager;

    public void createUser(NewClientRequest newClientRequest) {
        Client client = new Client();
        entityManager.setFlushMode(FlushModeType.COMMIT);

        client.setName(newClientRequest.getName());
        client.setSurname(newClientRequest.getSurname());
        client.setId_number(newClientRequest.getIdentity());

        client.getReservationSet().
                add(createReservation(newClientRequest.getRooms())
                );

        entityManager.persist(client);
    }

    private Reservation createReservation(ArrayList<Room> roomIterable) {

        Reservation reservation = new Reservation();

        reservation.setRoomSet(new HashSet<>(roomIterable));
        entityManager.persist(reservation);

        return reservation;
    }
}
