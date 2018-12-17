package dino.one.ruphotel.controllers;

import dino.one.ruphotel.model.dto.NewClientDto;
import dino.one.ruphotel.model.dto.ReservationToRemove;
import dino.one.ruphotel.model.persistance.Client;
import dino.one.ruphotel.model.persistance.Reservation;
import dino.one.ruphotel.service.ClientServiceImpl;
import dino.one.ruphotel.service.ReservationServiceImpl;
import dino.one.ruphotel.service.TokenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by prgres on 2018-12-17.
 */


@Controller
public class PaymentsController {

    private final ClientServiceImpl clientService;
    private final TokenServiceImpl tokenService;
    private final ReservationServiceImpl reservationService;
    private final RestTemplate restTemplate;

    @Autowired
    public PaymentsController(
            ClientServiceImpl clientService,
            TokenServiceImpl tokenService,
            ReservationServiceImpl reservationService,
            RestTemplate restTemplate) {
        this.clientService = clientService;
        this.tokenService = tokenService;
        this.reservationService = reservationService;
        this.restTemplate = restTemplate;
    }

    @PostMapping(value = "/generate-token")
    public @ResponseBody
    String generateToken(
            @RequestBody NewClientDto newClientDto) {

        Client client = clientService.checkIfUserExist(newClientDto.getName(),
                newClientDto.getSurname(),
                newClientDto.getIdentity());

        Reservation reservation = reservationService.createReservation(
                newClientDto.getFrom(),
                newClientDto.getTo(),
                client,
                newClientDto.getRooms()
        );

        clientService.addReservationToClient(client,
                reservation);

        String token = tokenService.generateToken(
                reservation.getId(),
                client.getName(),
                client.getSurname(),
                client.getIdNumber(),
                reservation.getPriceForAllRooms());

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(token, headers);


        return restTemplate.exchange(
                "http://localhost:8080/products",
                HttpMethod.POST,
                entity,
                String.class).getBody();
    }

    @PostMapping(value = "/toBeOrNotToBe")
    public void toBeOrNotToBe(@RequestBody ReservationToRemove reservationToRemove) {
        reservationService.deleteById(reservationToRemove.getId());
    }
}
