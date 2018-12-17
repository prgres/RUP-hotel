package dino.one.ruphotel.model.dto;

import dino.one.ruphotel.model.persistance.Room;
import lombok.Data;

import java.util.ArrayList;

/**
 * Created by prgres on 2018-12-12.
 */

@Data
public class NewClientDto {

    private String name;
    private String surname;
    private String identity;
    private ArrayList<Room> rooms;

}
