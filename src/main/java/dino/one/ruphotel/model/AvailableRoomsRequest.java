package dino.one.ruphotel.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by prgres on 2018-12-11.
 */

@Data
public class AvailableRoomsRequest {
    private int amountOfPeople;
    private Date arrival;
    private Date departure;

//    @ModelAttribute("availableRoomsRequestModelAttribute")
//    public AvailableRoomsRequest availableRoomsRequest(){
//        return new AvailableRoomsRequest();
//    }
}

