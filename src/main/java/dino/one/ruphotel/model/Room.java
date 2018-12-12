package dino.one.ruphotel.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by prgres on 2018-12-10.
 */

@Data
@Entity
@Table(name = "ROOM")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "room_number")
    private int id;

    @Column(name = "price")
    private BigDecimal price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_type", referencedColumnName = "roomtypeID")
    private RoomType roomType;

    @OneToOne(mappedBy = "room")
    private Reservation reservation;
}
