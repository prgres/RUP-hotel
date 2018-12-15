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


    @PutMapping(value = "/test2")
    public @ResponseBody
    Room test2(@RequestBody AvailableRoomsDto availableRoomsDto) {
        return roomService.testmethod();

    }

    @PostMapping(value = "/rooms")
//    public List<Room> rooms(@RequestBody AvailableRoomsDto availableRoomsDto) {
    public @ResponseBody
    Iterable<Room> rooms(@RequestBody AvailableRoomsDto availableRoomsDto) {
//        availableRoomsRequestModelAttribute.setFrom(availableRoomsDto.getFrom());
//        availableRoomsRequestModelAttribute.setTo(availableRoomsDto.getTo());
//        availableRoomsRequestModelAttribute.setAmountOfPeople(availableRoomsDto.getAmountOfPeople());

//        return roomService.findAll();
        return roomService.findAvailableRooms(availableRoomsDto);

    }

    @PostMapping(value = "/roomsHelp")
//    public List<Room> rooms(@RequestBody AvailableRoomsDto availableRoomsDto) {
    public @ResponseBody
    Iterable<Room> roomsHelp(@RequestBody AvailableRoomsDto availableRoomsDto) {
//        availableRoomsRequestModelAttribute.setFrom(availableRoomsDto.getFrom());
//        availableRoomsRequestModelAttribute.setTo(availableRoomsDto.getTo());
//        availableRoomsRequestModelAttribute.setAmountOfPeople(availableRoomsDto.getAmountOfPeople());

//        return roomService.findAll();
        return roomService.find(availableRoomsDto);

    }

    @PostMapping(value = "/generate-token")
    public @ResponseBody
    NewClientDto generateToken(@RequestBody NewClientDto newClientDto) {
//    public String generateToken(@SessionAttribute("availableRoomsRequestModelAttribute") AvailableRoomsDto availableRoomsRequestModelAttribute,
//                                @RequestBody NewClientDto newClientDto) {
//        userService.createUser(newClientDto, availableRoomsRequestModelAttribute);
//
        return newClientDto;
    }
}
