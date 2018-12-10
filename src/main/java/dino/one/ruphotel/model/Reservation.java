package dino.one.ruphotel.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by prgres on 2018-12-10.
 */

@Data
@Entity
@Table(name = "RESERVATION")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reservationID")
    private int id;

    @Column(name = "room")
    private int room;

    @Column(name = "arrival")
    private Date arrival;

    @Column(name = "departure")
    private Date departure;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clientID", referencedColumnName = "id")
    private Client client;
}
