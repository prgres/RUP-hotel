package dino.one.ruphotel.service;

import dino.one.ruphotel.model.AvailableRoomsRequest;
import dino.one.ruphotel.model.Room;

/**
 * Created by prgres on 2018-12-11.
 */

public interface RoomService {
    public Iterable<Room> findAvaibleRooms(AvailableRoomsRequest availableRoomsRequest);
}
