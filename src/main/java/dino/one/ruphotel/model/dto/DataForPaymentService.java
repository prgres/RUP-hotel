package dino.one.ruphotel.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by prgres on 2018-12-18.
 */

@Getter
@Setter
@ToString

public class DataForPaymentService {

    private Long id;
    private String name;
    private String surname;
    private String identityID;
    private Float price;

    public DataForPaymentService(
            Long id,
            String name,
            String surname,
            String identityID,
            Float price
    ) {
    }
}
