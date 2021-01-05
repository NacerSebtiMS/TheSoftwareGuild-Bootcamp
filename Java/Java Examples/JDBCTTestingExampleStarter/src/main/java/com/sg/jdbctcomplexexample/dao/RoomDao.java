package com.sg.jdbctcomplexexample.dao;

import com.sg.jdbctcomplexexample.entity.Room;
import java.util.List;

/**
 *
 * @author kylerudy
 */
public interface RoomDao {
    List<Room> getAllRooms();
    Room getRoomById(int id);
    Room addRoom(Room room);
    void updateRoom(Room room);
    void deleteRoomById(int id);
}
