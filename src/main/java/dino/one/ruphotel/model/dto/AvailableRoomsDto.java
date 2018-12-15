package dino.one.ruphotel.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by prgres on 2018-12-11.
 */

@Getter
@Setter
public class AvailableRoomsDto {
    private Date from;
    private Date to;
    private int personCount;

    @Override
    public String toString() {
        return "from: " + from + " to: " + to + "amountOfPeople" + personCount;
    }

}


