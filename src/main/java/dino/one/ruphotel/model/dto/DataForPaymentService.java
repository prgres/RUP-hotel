package dino.one.ruphotel.model.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by prgres on 2018-12-18.
 */

@Getter
@Setter
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
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.identityID = identityID;
        this.price = price;
    }

    public String toString() {
        return "DataForPaymentService(id=" + this.getId() + ", name=" + this.getName() + ", surname=" + this.getSurname() + ", identityID=" + this.getIdentityID() + ", price=" + this.getPrice() + ")";
    }
}
