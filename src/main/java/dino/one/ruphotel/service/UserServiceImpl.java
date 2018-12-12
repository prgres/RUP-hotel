package dino.one.ruphotel.service;

import dino.one.ruphotel.model.*;
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

    public void createUser(NewClientRequest newClientRequest,
                           AvailableRoomsRequest availableRoomsRequest) {
        Client client = new Client();
        entityManager.setFlushMode(FlushModeType.COMMIT);

        client.setName(newClientRequest.getName());
        client.setSurname(newClientRequest.getSurname());
        client.setId_number(newClientRequest.getIdentity());

        client.getReservationSet().
                add(createReservation(newClientRequest.getRooms(),
                        availableRoomsRequest)
                );

        entityManager.persist(client);
        entityManager.flush(); //TODO remove in master
    }

    private Reservation createReservation(ArrayList<Room> roomIterable,
                                          AvailableRoomsRequest availableRoomsRequest) {

        Reservation reservation = new Reservation();

        reservation.setRoomSet(new HashSet<>(roomIterable));
        reservation.setArrival(availableRoomsRequest.getArrival());
        reservation.setDeparture(availableRoomsRequest.getDeparture());
//        reservation.set

        entityManager.persist(reservation);
        entityManager.flush(); //TODO remove in master

        return reservation;
    }
}
