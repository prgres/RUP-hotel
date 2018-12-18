package dino.one.ruphotel.controllers;

import dino.one.ruphotel.model.dto.DataForPaymentService;
import dino.one.ruphotel.model.dto.NewClientDto;
import dino.one.ruphotel.model.dto.ReservationToRemove;
import dino.one.ruphotel.model.persistance.Client;
import dino.one.ruphotel.model.persistance.Reservation;
import dino.one.ruphotel.service.ClientServiceImpl;
import dino.one.ruphotel.service.ReservationServiceImpl;
import dino.one.ruphotel.service.TokenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by prgres on 2018-12-17.
 */


@Controller
public class PaymentsController {

    private final ClientServiceImpl clientService;
    private final TokenServiceImpl tokenService;
    private final ReservationServiceImpl reservationService;

    @Autowired
    public PaymentsController(
            ClientServiceImpl clientService,
            TokenServiceImpl tokenService,
            ReservationServiceImpl reservationService) {
        this.clientService = clientService;
        this.tokenService = tokenService;
        this.reservationService = reservationService;
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

        System.out.println("generete-token " + token);

//        ResponseEntity<String> respondeFromPaymentSite =
        tokenService.sendDataToPaymentService(new DataForPaymentService(
                reservation.getId(),
                client.getName(),
                client.getSurname(),
                client.getIdNumber(),
                reservation.getPriceForAllRooms().floatValue()
        ));

        return token;
    }

    @PostMapping(value = "/testpost")
    public @ResponseBody
    String testpost(@RequestBody String token) {
        System.out.println("testpost: " + token);
        return token;
    }


    @PostMapping(value = "/toBeOrNotToBe")
    public void toBeOrNotToBe(@RequestBody ReservationToRemove reservationToRemove) {
        reservationService.deleteById(reservationToRemove.getId());
    }
}
