package dino.one.ruphotel.service;

import dino.one.ruphotel.model.dto.DataForPaymentService;
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

    private final RestTemplate restTemplate;

    @Autowired
    public TokenServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String generateToken(Long id,
                                String name,
                                String surname,
                                String identity,
                                BigDecimal price) {

        String secretKey = "012345678900123456789001234567890121942376830674";
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

    @Override
    public void sendDataToPaymentService(DataForPaymentService dataForPaymentService) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<DataForPaymentService> entity = new HttpEntity<>(dataForPaymentService, headers);

        ResponseEntity<Void> responseEntity = restTemplate.postForEntity(
                "http://46.187.239.247:1897",
                entity,
                Void.class);
    }
}
