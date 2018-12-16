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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//Serve React Frontend on the '/' route

@Controller
//@SessionAttributes("availableRoomsDto")
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


    @PutMapping(value = "/showAll")
    public @ResponseBody
    Room showAll(@RequestBody AvailableRoomsDto availableRoomsDto) {
        return roomService.testmethod();
    }

    @PostMapping(value = "/rooms")
    public @ResponseBody
    Iterable<Room> rooms(
//            Model model,
            @RequestBody AvailableRoomsDto availableRoomsDto,
            final RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("availableRoomsDto", availableRoomsDto);


        return roomService.findAvailableRooms(availableRoomsDto);
    }

    @PostMapping(value = "/generate-token")
    public @ResponseBody
    NewClientDto generateToken(
            @ModelAttribute("availableRoomsDto") AvailableRoomsDto availableRoomsDto,
            @RequestBody NewClientDto newClientDto) {
//    public String generateToken(@SessionAttribute("availableRoomsRequestModelAttribute") AvailableRoomsDto availableRoomsRequestModelAttribute,
//                                @RequestBody NewClientDto newClientDto) {
//        userService.createUser(newClientDto, availableRoomsRequestModelAttribute);

//        availableRoomsDto.set
        System.out.println(availableRoomsDto);
        return newClientDto;
    }
}
