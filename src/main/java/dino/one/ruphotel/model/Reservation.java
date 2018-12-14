package dino.one.ruphotel.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

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

    @Column(name = "from")
    private Date arrival;

    @Column(name = "to")
    private Date departure;

    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "clientID", referencedColumnName = "clientID")
    private Client client;

    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinTable(
            name = "room_list",
            joinColumns = {@JoinColumn(name = "reservationID")},
            inverseJoinColumns = {@JoinColumn(name = "room_number")})
    private Set<Room> roomSet;

}

