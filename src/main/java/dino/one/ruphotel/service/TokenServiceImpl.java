package dino.one.ruphotel.service;

import dino.one.ruphotel.model.DeserializedToken;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by prgres on 2018-12-12.
 */

@Service
public class TokenServiceImpl implements TokenService {

    private String secretKey = "01234567890012345678900123456789012";

    public String generateToken(Long id,
                                String name,
                                String surname,
                                String identity,
                                BigDecimal price) {

        String jwt = Jwts.builder().
                claim("id", id).
                claim("name", name).
                claim("surname", surname).
                claim("identityID", identity).
                claim("price", price).
                claim("exp", System.currentTimeMillis() / 1000 + 3600).
                signWith(io.jsonwebtoken.SignatureAlgorithm.HS256, secretKey).
                compact();
        return jwt;
    }

    public DeserializedToken deserializedToken(String token) {
        DeserializedToken deserializedToken = new DeserializedToken();

//        Claims claims = Jwts.parser().
//                setSigningKey(secretKey).
//                parseClaimsJws(token).
//                getBody();

//        deserializedToken.setId(Long.valueOf(claims.getId()));
//        deserializedToken.setName(claims.getAudience());
        return deserializedToken;
    }
}
