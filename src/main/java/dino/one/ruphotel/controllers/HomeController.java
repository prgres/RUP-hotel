package dino.one.ruphotel.controllers;

import dino.one.ruphotel.model.Room;
import dino.one.ruphotel.model.dto.AvailableRoomsDto;
import dino.one.ruphotel.model.dto.NewClientDto;
import dino.one.ruphotel.service.RoomServiceImpl;
import dino.one.ruphotel.service.TokenGeneratorServiceImpl;
import dino.one.ruphotel.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//Serve React Frontend on the '/' route

@Controller
//@SessionAttributes("availableRoomsRequestModelAttribute")
public class HomeController {

    private final RoomServiceImpl roomService;
    private final UserServiceImpl userService;
    private final TokenGeneratorServiceImpl tokenGeneratorService;

//    @ModelAttribute("availableRoomsRequestModelAttribute")
//    public AvailableRoomsDto availableRoomsDto() {
//        return new AvailableRoomsDto();
//    }

    @Autowired
    public HomeController(RoomServiceImpl roomService, UserServiceImpl userService, TokenGeneratorServiceImpl tokenGeneratorService) {
        this.roomService = roomService;
        this.userService = userService;
        this.tokenGeneratorService = tokenGeneratorService;
    }


    @RequestMapping(value = "/")
    public String index() {
        return "redirect:/index.html";
    }

    @GetMapping
    public @ResponseBody
    String test() {

        roomService.testmethod();

        //        entityManager.
        return "good";
    }

    @PostMapping(value = "/rooms")
    public List<Room> postRoom(
//    public List<Room> postRoom(@ModelAttribute("availableRoomsRequestModelAttribute") AvailableRoomsDto availableRoomsRequestModelAttribute,
            @RequestBody AvailableRoomsDto availableRoomsDto) {
//        availableRoomsRequestModelAttribute.setFrom(availableRoomsDto.getFrom());
//        availableRoomsRequestModelAttribute.setTo(availableRoomsDto.getTo());
//        availableRoomsRequestModelAttribute.setAmountOfPeople(availableRoomsDto.getAmountOfPeople());

//        Lists.newArrayList(iterable).size();

//        if (roomService.findAvaibleRooms(availableRoomsDto))
//        return roomService.findAvaibleRooms(availableRoomsDto);
        List<Room> asd = new ArrayList<>();

        return asd;
    }

    @ResponseBody
    @PostMapping(value = "/generate-token", produces = "application/json")
    public String generateToken(@RequestBody NewClientDto newClientDto) {
//    public String generateToken(@SessionAttribute("availableRoomsRequestModelAttribute") AvailableRoomsDto availableRoomsRequestModelAttribute,
//                                @RequestBody NewClientDto newClientDto) {
//        userService.createUser(newClientDto, availableRoomsRequestModelAttribute);
//
        return newClientDto.toString();
//        return tokenGeneratorService.generateToken();
//        return availableRoomsDto;
    }

}
