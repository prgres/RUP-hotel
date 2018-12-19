package dino.one.ruphotel.service;

import dino.one.ruphotel.model.dto.DataForPaymentService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.crypto.SecretKey;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

        String secretKey = "0123456789012345678901234567891201234567890123456789012345678912";

        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes());
        String jwt = Jwts.builder().
                signWith(io.jsonwebtoken.SignatureAlgorithm.HS256, key).
                setHeaderParam("typ", "JWT").
                claim("id", id).
                claim("name", name).
                claim("surname", surname).
                claim("identityID", identity).
                claim("price", price.floatValue()).
                claim("exp", System.currentTimeMillis() / 1000 + 3600).
                compact();
        return jwt;
    }

    @Override
    public void sendDataToPaymentService(DataForPaymentService dataForPaymentService) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HashMap<String, Object> hashMap = new LinkedHashMap<>();
        hashMap.put("id", dataForPaymentService.getId());
        hashMap.put("name", dataForPaymentService.getName());
        hashMap.put("surname", dataForPaymentService.getSurname());
        hashMap.put("identityID", dataForPaymentService.getIdentityID());
        hashMap.put("price", dataForPaymentService.getPrice());

        HttpEntity<HashMap<String, Object>> entity = new HttpEntity<>(hashMap, headers);

        ResponseEntity<Void> responseEntity = restTemplate.postForEntity(
                "http://46.187.239.247:1897/api/pay",
                entity,
                Void.class);
    }
}
