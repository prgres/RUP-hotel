package dino.one.ruphotel.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * Created by prgres on 2018-12-17.
 */

@Getter
@Setter
@ToString
public class DeserializedToken {
    private Long id;
    private String name;
    private String surname;
    private String identity;
    private BigDecimal price;
}
