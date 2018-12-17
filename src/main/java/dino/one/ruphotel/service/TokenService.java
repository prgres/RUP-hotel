package dino.one.ruphotel.service;

import java.math.BigDecimal;

/**
 * Created by prgres on 2018-12-15.
 */

public interface TokenService {
    String generateToken(Long id,
                         String name,
                         String surname,
                         String identity,
                         BigDecimal price);

}
