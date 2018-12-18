package dino.one.ruphotel.controllers;

import dino.one.ruphotel.model.dto.AvailableRoomsDto;
import dino.one.ruphotel.model.persistance.Room;
import dino.one.ruphotel.service.RoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin
@Controller
public class RoomsController {

    private final RoomServiceImpl roomService;

    @Autowired
    public RoomsController(RoomServiceImpl roomService) {
        this.roomService = roomService;
    }

//    @GetMapping(value = "/showAll")
//    public @ResponseBody
//    Iterable<Room> showAll() {
//        return roomService.findAll();
//    }

//    @GetMapping(value = "/testmethod")
//    public @ResponseBody
//    Iterable<Room> showAll(
//            @RequestBody AvailableRoomsDto availableRoomsDto) {
//        return roomService.findAvailableRoomsAlternative(availableRoomsDto);
//    }

    @PostMapping(value = "/rooms")
    public @ResponseBody
    Iterable<Room> rooms(@RequestBody AvailableRoomsDto availableRoomsDto) {
        return roomService.findAvailableRooms(availableRoomsDto);
    }
}
