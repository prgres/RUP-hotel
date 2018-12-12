package dino.one.ruphotel.model;

import lombok.Data;

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

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "room_id", referencedColumnName = "room_number")
//    private Room room;

    @Column(name = "arrival")
    private Date arrival;

    @Column(name = "departure")
    private Date departure;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientID", referencedColumnName = "clientID")
    private Client client;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "room_list",
            joinColumns = {@JoinColumn(name = "reservationID")},
            inverseJoinColumns = {@JoinColumn(name = "room_number")})
    private Iterable<Room> roomSet;

}

