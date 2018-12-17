package dino.one.ruphotel.service;

import dino.one.ruphotel.model.persistance.Client;
import dino.one.ruphotel.model.persistance.Reservation;

/**
 * Created by prgres on 2018-12-16.
 */

public interface ClientService {
    Client createUser(String name,
                      String surname,
                      String identify);

    void addReservationToClient(Client client,
                                Reservation reservation);

    Client checkIfUserExist(String name,
                            String surname,
                            String identify);

    void deleteByIdNumber(String id_nubmer);
}
