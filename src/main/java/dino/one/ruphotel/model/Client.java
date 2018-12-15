package dino.one.ruphotel.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by prgres on 2018-12-10.
 */

@Data
@Entity
@Table(name = "CLIENT")
public class Client {
//    @Transient
//    private AvailableRoomsDto availableRoomsDto;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name",
            nullable = false)
    @Size(max = 30)
    private String name;

    @Column(name = "surname",
            nullable = false)
    @Size(max = 30)
    private String surname;

    @Column(name = "id_number",
            length = 9,
            nullable = false)
    @Size(max = 9)
    private String id_number;

    @OneToMany(
            fetch = FetchType.LAZY)
    private List<Reservation> reservationList = new ArrayList<>();

}
