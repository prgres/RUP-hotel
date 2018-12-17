package dino.one.ruphotel.service;

import dino.one.ruphotel.model.persistance.Client;
import dino.one.ruphotel.model.persistance.Reservation;
import dino.one.ruphotel.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;

/**
 * Created by prgres on 2018-12-12.
 */

@Service
//@Transactional
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client createUser(
            String name,
            String surname,
            String identify) {
        Client client = new Client();

        entityManager.setFlushMode(FlushModeType.COMMIT);

        client.setName(name);
        client.setSurname(surname);
        client.setId_number(identify);

        entityManager.persist(client);
        entityManager.flush();

        return entityManager.getReference(Client.class, client.getId());
    }

    @Override
    public void addReservationToClient(
            Client client,
            Reservation reservation) {
        client.getReservationList().add(reservation);
    }

    @Override
    public Client checkIfUserExist(
            String name,
            String surname,
            String identify) {
        Client client = clientRepository.findById_number(identify);

        if (client == null) {
            client = createUser(
                    name,
                    surname,
                    identify
            );
        }

        return client;
    }

    @Override
    public void deleteByIdNumber(String id_nubmer) {
        clientRepository.deleteById_number(id_nubmer);
    }
}

