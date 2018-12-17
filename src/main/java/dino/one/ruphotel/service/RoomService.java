package dino.one.ruphotel.service;

import dino.one.ruphotel.model.dto.AvailableRoomsDto;
import dino.one.ruphotel.model.persistance.Room;

import java.util.List;

/**
 * Created by prgres on 2018-12-11.
 */

public interface RoomService {
    List<Room> findAvailableRooms(AvailableRoomsDto availableRoomsDto);

    List<Room> findAvailableRoomsAlternative(AvailableRoomsDto availableRoomsDto);

    List<Room> findAll();
}
