package dino.one.ruphotel.service;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

/**
 * Created by prgres on 2018-12-12.
 */

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private RestTemplate restTemplate;

    //    private String secretKey = "01234567890012345678900123456789012";
    private String secretKey = "012345678900123456789001234567890121942376830674";

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

    public ResponseEntity<String> sendTokenToPaymentSite(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(token, headers);
        ResponseEntity<String> responde = restTemplate.postForEntity(
                "http://localhost:8080/testpost",
//                "http://localhost:8080/testpost",
                entity,
                String.class);

        return responde;
    }
}
