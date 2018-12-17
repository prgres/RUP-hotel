package dino.one.ruphotel.model.persistance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by prgres on 2018-12-10.
 */

@Data
@Entity
@Table(name = "RESERVATIONS")
public class Reservation {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @Column(name = "arrival",
            nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date arrival;

    @JsonIgnore
    @Column(name = "departure",
            nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date departure;

    @JsonIgnore
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @JsonIgnore
    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinTable(
            name = "reservation_room",
            joinColumns = {@JoinColumn(name = "id")},
            inverseJoinColumns = {@JoinColumn(name = "number")})
    private List<Room> roomList = new ArrayList<>();

    @JsonIgnore
    @Transient
    private BigDecimal priceForAllRooms;
}

