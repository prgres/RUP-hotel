package dino.one.ruphotel.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Created by prgres on 2018-12-10.
 */

@Data
@Entity
@Table(name = "ROOM_TYPE")
public class RoomType {

    @Id
    @Column(name = "roomtypeID")
    private int id;

    @Column(name = "room_type")
    @Size(max = 40)
    private String roomType;
}
