package com.sg.jdbctcomplexexample.dao;

import com.sg.jdbctcomplexexample.entity.Room;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kylerudy
 */
@Repository
public class RoomDaoDB implements RoomDao {
    
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public List<Room> getAllRooms() {
        final String SELECT_ALL_ROOMS = "SELECT * FROM room";
        return jdbc.query(SELECT_ALL_ROOMS, new RoomMapper());
    }

    @Override
    public Room getRoomById(int id) {
        try {
            final String SELECT_ROOM_BY_ID = "SELECT * FROM room WHERE id = ?";
            return jdbc.queryForObject(SELECT_ROOM_BY_ID, new RoomMapper(), id);
        } catch(DataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional
    public Room addRoom(Room room) {
        final String INSERT_ROOM = "INSERT INTO room(name, description) VALUES(?,?)";
        jdbc.update(INSERT_ROOM, 
                room.getName(), 
                room.getDescription());
        
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        room.setId(newId);
        return room;
    }

    @Override
    public void updateRoom(Room room) {
        final String UPDATE_ROOM = "UPDATE room SET name = ?, description = ? WHERE id = ?";
        jdbc.update(UPDATE_ROOM,
                room.getName(),
                room.getDescription(),
                room.getId());
    }

    @Override
    @Transactional
    public void deleteRoomById(int id) {
        final String DELETE_MEETING_EMPLOYEE_BY_ROOM = "DELETE me.* FROM meeting_employee me "
                + "JOIN meeting m ON me.meetingId = m.id WHERE m.roomId = ?";
        jdbc.update(DELETE_MEETING_EMPLOYEE_BY_ROOM, id);
        
        final String DELETE_MEETING_BY_ROOM = "DELETE FROM meeting WHERE roomId = ?";
        jdbc.update(DELETE_MEETING_BY_ROOM, id);
        
        final String DELETE_ROOM = "DELETE FROM room WHERE id = ?";
        jdbc.update(DELETE_ROOM, id);
    }
    
    public static final class RoomMapper implements RowMapper<Room> {

        @Override
        public Room mapRow(ResultSet rs, int index) throws SQLException {
            Room rm = new Room();
            rm.setId(rs.getInt("id"));
            rm.setName(rs.getString("name"));
            rm.setDescription(rs.getString("description"));
            return rm;
        }
    }
    
}
