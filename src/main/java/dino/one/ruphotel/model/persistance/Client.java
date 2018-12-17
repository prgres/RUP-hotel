package dino.one.ruphotel.model.persistance;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @Column(name = "name",
            nullable = false)
    @Size(max = 30)
    private String name;

    @JsonIgnore
    @Column(name = "surname",
            nullable = false)
    @Size(max = 30)
    private String surname;

    @JsonIgnore
    @Column(name = "id_number",
            length = 9,
            nullable = false)
    @Size(max = 9)
    private String id_number;

    @JsonIgnore
    @OneToMany(
            fetch = FetchType.LAZY)
    private List<Reservation> reservationList = new ArrayList<>();

}
