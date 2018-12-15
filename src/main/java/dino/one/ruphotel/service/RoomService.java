package dino.one.ruphotel.service;

import dino.one.ruphotel.model.Room;
import dino.one.ruphotel.model.dto.AvailableRoomsDto;

import java.util.List;

/**
 * Created by prgres on 2018-12-11.
 */

public interface RoomService {
    List<Room> findAvailableRooms(AvailableRoomsDto availableRoomsDto);
}
