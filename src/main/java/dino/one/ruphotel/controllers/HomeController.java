package dino.one.ruphotel.controllers;

import dino.one.ruphotel.model.AvailableRoomsRequest;
import dino.one.ruphotel.model.NewClientRequest;
import dino.one.ruphotel.model.Room;
import dino.one.ruphotel.service.RoomServiceImpl;
import dino.one.ruphotel.service.TokenGeneratorServiceImpl;
import dino.one.ruphotel.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//Serve React Frontend on the '/' route

@Controller
@SessionAttributes("availableRoomsRequestModelAttribute")
public class HomeController {

    private final RoomServiceImpl roomService;
    private final UserServiceImpl userService;
    private final TokenGeneratorServiceImpl tokenGeneratorService;

    @ModelAttribute("availableRoomsRequestModelAttribute")
    public AvailableRoomsRequest availableRoomsRequest() {
        return new AvailableRoomsRequest();
    }

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
    public Iterable<Room> postRoom(@ModelAttribute("availableRoomsRequestModelAttribute") AvailableRoomsRequest availableRoomsRequestModelAttribute,
                                   @RequestBody AvailableRoomsRequest availableRoomsRequest) {
        availableRoomsRequestModelAttribute = availableRoomsRequest;
        return roomService.findAvaibleRooms(availableRoomsRequest);
    }

    @PostMapping(value = "/generate-token")
    public String generateToken(@SessionAttribute("availableRoomsRequestModelAttribute") AvailableRoomsRequest availableRoomsRequestModelAttribute,
                                @RequestBody NewClientRequest newClientRequest) {
        userService.createUser(newClientRequest, availableRoomsRequestModelAttribute);

        return tokenGeneratorService.generateToken();
    }
}

//TODO when should i add all to db?
// entitymanger is waiting to flush() to commit transaction