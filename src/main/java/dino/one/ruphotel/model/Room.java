package dino.one.ruphotel.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by prgres on 2018-12-10.
 */

@Data
@Entity
@Table(name = "ROOM")
public class Room {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "room_type", referencedColumnName = "id")
    private RoomType roomType;

    @ManyToMany(mappedBy = "roomList")
    private List<Reservation> reservation = new ArrayList<>();

}
