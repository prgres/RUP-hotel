package dino.one.ruphotel.repository;

import dino.one.ruphotel.model.persistance.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by prgres on 2018-12-16.
 */

@Repository
public interface ClientRepository
        extends CrudRepository<Client, Long> {

    Client findByIdNumber(String idNumber);

    void deleteByIdNumber(String idNumber);
}
