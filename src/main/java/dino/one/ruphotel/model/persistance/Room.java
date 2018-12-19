package dino.one.ruphotel.model.persistance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

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
@Entity
@Table(name = "ROOMS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Room implements Serializable {

    @Id
    @Column(name = "id",
            nullable = false)
    private Long id;

    @Column(name = "price",
            nullable = false)
    private BigDecimal price;

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "room_type", referencedColumnName = "id")
    private RoomType roomType;

    @JsonIgnore
    @ManyToMany(mappedBy = "roomList")
    private List<Reservation> reservation = new ArrayList<>();

    @Override
    public String toString() {
        return "id: " + id;
    }
}
