package dino.one.ruphotel.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by prgres on 2018-12-10.
 */

@Getter
@Setter
@ToString
@Entity
@Table(name = "ROOMS")
public class Room implements Serializable {

    @Id
//    @GeneratedValue
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
