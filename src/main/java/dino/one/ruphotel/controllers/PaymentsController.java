package dino.one.ruphotel.controllers;

import dino.one.ruphotel.model.DeserializedToken;
import dino.one.ruphotel.model.dto.AvailableRoomsDto;
import dino.one.ruphotel.model.dto.NewClientDto;
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
            @RequestBody NewClientDto newClientDto,
            @RequestBody AvailableRoomsDto availableRoomsDto) {

        Client client = clientService.checkIfUserExist(newClientDto.getName(),
                newClientDto.getSurname(),
                newClientDto.getIdentity());

        Reservation reservation = reservationService.createReservation(
                availableRoomsDto.getFrom(),
                availableRoomsDto.getTo(),
                client,
                newClientDto.getRooms()
        );

        clientService.addReservationToClient(client,
                reservation);

        return tokenService.generateToken(
                reservation.getId(),
                client.getName(),
                client.getSurname(),
                client.getId_number(),
                reservation.getPriceForAllRooms());
    }

    @PostMapping(value = "/toBeOrNotToBe")
    public void toBeOrNotToBe(@RequestBody String token) {
        DeserializedToken dataToRemove = tokenService.deserializedToken(token);

        clientService.deleteByIdNumber(dataToRemove.getIdentity());
        reservationService.deleteById(dataToRemove.getId());
    }
}
