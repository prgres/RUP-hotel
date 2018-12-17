package dino.one.ruphotel.service;

import dino.one.ruphotel.model.persistance.Client;
import dino.one.ruphotel.model.persistance.Reservation;
import dino.one.ruphotel.model.persistance.Room;

import java.util.Date;
import java.util.List;

/**
 * Created by prgres on 2018-12-17.
 */

public interface ReservationService {
    Reservation createReservation(Date arrival,
                                  Date departure,
                                  Client client,
                                  List<Room> roomList);

    void deleteById(Long id);
}
