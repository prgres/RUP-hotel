package dino.one.ruphotel.controllers;

import dino.one.ruphotel.model.dto.AvailableRoomsDto;
import dino.one.ruphotel.model.persistance.Room;
import dino.one.ruphotel.service.RoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
@RequestMapping(value = "/api")
public class RoomsController {

    private final RoomServiceImpl roomService;

    @Autowired
    public RoomsController(RoomServiceImpl roomService) {
        this.roomService = roomService;
    }

    @PostMapping(value = "/rooms")
    public @ResponseBody
    Iterable<Room> rooms(@RequestBody AvailableRoomsDto availableRoomsDto) {
        return roomService.findAvailableRoomsAlternative(availableRoomsDto);
//        return roomService.findAvailableRooms(availableRoomsDto);
    }
}
