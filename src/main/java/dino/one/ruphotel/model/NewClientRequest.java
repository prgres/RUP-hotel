package dino.one.ruphotel.model;

import lombok.Data;

/**
 * Created by prgres on 2018-12-12.
 */

@Data
public class NewClientRequest {

    private String name;
    private String surname;
    private String identity;
    private Iterable<Room> rooms;

}
