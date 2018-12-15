package dino.one.ruphotel.service;

import dino.one.ruphotel.model.Client;
import dino.one.ruphotel.model.Reservation;
import dino.one.ruphotel.model.Room;
import dino.one.ruphotel.model.dto.AvailableRoomsDto;
import dino.one.ruphotel.model.dto.NewClientDto;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;

/**
 * Created by prgres on 2018-12-12.
 */

@Service
//@Transactional
public class UserServiceImpl {

    @PersistenceContext
    EntityManager entityManager;

    public void createUser(NewClientDto newClientDto,
                           AvailableRoomsDto availableRoomsDto) {
        Client client = new Client();
        entityManager.setFlushMode(FlushModeType.COMMIT);

        client.setName(newClientDto.getName());
        client.setSurname(newClientDto.getSurname());
        client.setId_number(newClientDto.getIdentity());

//        client.getReservationSet().
//                add(createReservation(newClientDto.getRooms(),
//                        availableRoomsDto)
//                );

        entityManager.persist(client);
        entityManager.flush();
    }

    private Reservation createReservation(ArrayList<Room> roomIterable,
                                          AvailableRoomsDto availableRoomsDto) {

        Reservation reservation = new Reservation();

//        reservation.setRoomSet(new HashSet<>(roomIterable));
//        reservation.setArrival(availableRoomsDto.getFrom());
//        reservation.setDeparture(availableRoomsDto.getTo());
//        reservation.set

        entityManager.persist(reservation);
        entityManager.flush();

        return reservation;
    }
}
