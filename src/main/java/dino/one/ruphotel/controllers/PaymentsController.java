package dino.one.ruphotel.controllers;

import dino.one.ruphotel.model.DataValidator;
import dino.one.ruphotel.model.dto.DataForPaymentService;
import dino.one.ruphotel.model.dto.NewClientDto;
import dino.one.ruphotel.model.persistance.Client;
import dino.one.ruphotel.model.persistance.Reservation;
import dino.one.ruphotel.service.ClientServiceImpl;
import dino.one.ruphotel.service.ReservationServiceImpl;
import dino.one.ruphotel.service.TokenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by prgres on 2018-12-17.
 */

@CrossOrigin
@Controller
@RequestMapping(value = "/api")
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
    HashMap<String, Object> generateToken(
            @RequestBody NewClientDto newClientDto) {

        DataValidator dataValidator = new DataValidator();

        if (!dataValidator.idNumberValidate(newClientDto.getIdentity()))
            return null;

        if (!dataValidator.newClientDtoValidate(newClientDto))
            return null;

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

        tokenService.sendDataToPaymentService(new DataForPaymentService(
                reservation.getId(),
                client.getName(),
                client.getSurname(),
                client.getIdNumber(),
                reservation.getPriceForAllRooms().floatValue()
        ));

        HashMap<String, Object> rtn = new LinkedHashMap<String, Object>();
        rtn.put("token", token);
        rtn.put("id", reservation.getId());

        return rtn;
    }


    @PostMapping(value = "/toBeOrNotToBe")
    public void toBeOrNotToBe(@RequestBody String reservationToRemove) {
        reservationService.deleteById(Long.valueOf(reservationToRemove));
    }
}
