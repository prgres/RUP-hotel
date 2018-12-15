package dino.one.ruphotel.model;

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
    @Column(name = "id")
    private Long id;

    @Column(name = "room_type")
    @Size(max = 40)
    private String roomType;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Room> rooms = new ArrayList<>();

}
