package dino.one.ruphotel.controllers;

import dino.one.ruphotel.model.AvailableRoomsRequest;
import dino.one.ruphotel.model.NewClientRequest;
import dino.one.ruphotel.model.Room;
import dino.one.ruphotel.service.RoomServiceImpl;
import dino.one.ruphotel.service.TokenGeneratorServiceImpl;
import dino.one.ruphotel.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
//    public AvailableRoomsRequest availableRoomsRequest() {
//        return new AvailableRoomsRequest();
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

    @PostMapping(value = "/rooms")
    public List<Room> postRoom(
//    public List<Room> postRoom(@ModelAttribute("availableRoomsRequestModelAttribute") AvailableRoomsRequest availableRoomsRequestModelAttribute,
            @RequestBody AvailableRoomsRequest availableRoomsRequest) {
//        availableRoomsRequestModelAttribute.setFrom(availableRoomsRequest.getFrom());
//        availableRoomsRequestModelAttribute.setTo(availableRoomsRequest.getTo());
//        availableRoomsRequestModelAttribute.setAmountOfPeople(availableRoomsRequest.getAmountOfPeople());

//        Lists.newArrayList(iterable).size();

//        if (roomService.findAvaibleRooms(availableRoomsRequest))
//        return roomService.findAvaibleRooms(availableRoomsRequest);
        List<Room> asd = new ArrayList<>();
        return asd;
    }

    @ResponseBody
    @PostMapping(value = "/generate-token", produces = "application/json")
    public String generateToken(@RequestBody NewClientRequest newClientRequest) {
//    public String generateToken(@SessionAttribute("availableRoomsRequestModelAttribute") AvailableRoomsRequest availableRoomsRequestModelAttribute,
//                                @RequestBody NewClientRequest newClientRequest) {
//        userService.createUser(newClientRequest, availableRoomsRequestModelAttribute);
//
        return newClientRequest.toString();
//        return tokenGeneratorService.generateToken();
//        return availableRoomsRequest;
    }

}
