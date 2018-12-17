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
@Table(name = "ROOM_TYPE")
public class RoomType {

    @Id
    @Column(name = "id",
            nullable = false)
    private Long id;

    @Column(name = "room_type",
            nullable = false)
    @Size(max = 40)
    private String roomType;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    private List<Room> rooms = new ArrayList<>();

}