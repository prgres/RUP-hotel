package dino.one.ruphotel.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by prgres on 2018-12-10.
 */

@Data
@Entity
@Table(name = "CLIENT")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "clientID")
    private int id;

    @Column(name = "name")
    @Size(max = 30)
    private String name;

    @Column(name = "surname")
    @Size(max = 30)
    private String surname;

    @Column(name = "id_number")
    @Size(max = 9)
    private String id_number;
}
