package com.sg.jdbctcomplexexample.dao;

import com.sg.jdbctcomplexexample.dao.EmployeeDaoDB.EmployeeMapper;
import com.sg.jdbctcomplexexample.dao.RoomDaoDB.RoomMapper;
import com.sg.jdbctcomplexexample.entity.Employee;
import com.sg.jdbctcomplexexample.entity.Meeting;
import com.sg.jdbctcomplexexample.entity.Room;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
public class MeetingDaoDB implements MeetingDao {
    
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public List<Meeting> getAllMeetings() {
        final String SELECT_ALL_MEETINGS = "SELECT * FROM meeting";
        List<Meeting> meetings = jdbc.query(SELECT_ALL_MEETINGS, new MeetingMapper());
        
        addRoomAndEmployeesToMeetings(meetings);
        
        return meetings;
    }

    @Override
    public Meeting getMeetingByid(int id) {
        try {
            final String SELECT_MEETING_BY_ID = "SELECT * FROM meeting WHERE id = ?";
            Meeting meeting = jdbc.queryForObject(SELECT_MEETING_BY_ID, 
                    new MeetingMapper(), id);
            meeting.setRoom(getRoomForMeeting(meeting));
            meeting.setAttendees(getEmployeesForMeeting(meeting));
            return meeting;
        } catch(DataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional
    public Meeting addMeeting(Meeting meeting) {
        final String INSERT_MEETING = "INSERT INTO meeting(name, time, roomId) VALUES(?,?,?)";
        jdbc.update(INSERT_MEETING,
                meeting.getName(),
                Timestamp.valueOf(meeting.getTime()),
                meeting.getRoom().getId());
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        meeting.setId(newId);
        
        insertMeetingEmployee(meeting);
        
        return meeting;
    }

    @Override
    @Transactional
    public void updateMeeting(Meeting meeting) {
        final String UPDATE_MEETING = "UPDATE meeting "
                + "SET name = ?, time = ?, roomId = ? WHERE id = ?";
        jdbc.update(UPDATE_MEETING,
                meeting.getName(),
                Timestamp.valueOf(meeting.getTime()),
                meeting.getRoom().getId(),
                meeting.getId());
        
        final String DELETE_MEETING_EMPLOYEE = "DELETE FROM meeting_employee "
                + "WHERE meetingId = ?";
        jdbc.update(DELETE_MEETING_EMPLOYEE, meeting.getId());
        insertMeetingEmployee(meeting);
    }

    @Override
    public void deleteMeetingById(int id) {
        final String DELETE_MEETING_EMPLOYEE = "DELETE FROM meeting_employee "
                + "WHERE meetingId = ?";
        jdbc.update(DELETE_MEETING_EMPLOYEE, id);
        
        final String DELETE_MEETING = "DELETE FROM meeting WHERE id = ?";
        jdbc.update(DELETE_MEETING, id);
    }
    
    @Override
    public List<Meeting> getMeetingsForRoom(Room room) {
        final String SELECT_MEETINGS_FOR_ROOM = "SELECT * FROM meeting WHERE roomId = ?";
        List<Meeting> meetings = jdbc.query(SELECT_MEETINGS_FOR_ROOM, 
                new MeetingMapper(), room.getId());
        
        addRoomAndEmployeesToMeetings(meetings);
        
        return meetings;
    }

    @Override
    public List<Meeting> getMeetingsForEmployee(Employee employee) {
        final String SELECT_MEETINGS_FOR_EMPLOYEE = "SELECT * FROM meeting m "
                + "JOIN meeting_employee me ON m.id = me.meetingId WHERE me.employeeId = ?";
        List<Meeting> meetings = jdbc.query(SELECT_MEETINGS_FOR_EMPLOYEE, 
                new MeetingMapper(), employee.getId());
        
        addRoomAndEmployeesToMeetings(meetings);
        
        return meetings;
    }
    
    private void addRoomAndEmployeesToMeetings(List<Meeting> meetings) {
        for(Meeting meeting : meetings) {
            meeting.setRoom(getRoomForMeeting(meeting));
            meeting.setAttendees(getEmployeesForMeeting(meeting));
        }
    }
    
    private Room getRoomForMeeting(Meeting meeting) {
        final String SELECT_ROOM_FOR_MEETING = "SELECT r.* FROM room r "
                + "JOIN meeting m ON r.id = m.roomId WHERE m.id = ?";
        return jdbc.queryForObject(SELECT_ROOM_FOR_MEETING, new RoomMapper(), 
                meeting.getId());
    }
    
    private List<Employee> getEmployeesForMeeting(Meeting meeting) {
        final String SELECT_EMPLOYEES_FOR_MEETING = "SELECT e.* FROM employee e "
                + "JOIN meeting_employee me ON e.id = me.employeeId WHERE me.meetingId = ?";
        return jdbc.query(SELECT_EMPLOYEES_FOR_MEETING, new EmployeeMapper(), 
                meeting.getId());
    }
    
    private void insertMeetingEmployee(Meeting meeting) {
        final String INSERT_MEETING_EMPLOYEE = "INSERT INTO meeting_employee"
                + "(meetingId, employeeId) VALUES(?,?)";
        for(Employee employee : meeting.getAttendees()) {
            jdbc.update(INSERT_MEETING_EMPLOYEE, meeting.getId(), employee.getId());
        }
    }

    
    public static final class MeetingMapper implements RowMapper<Meeting> {

        @Override
        public Meeting mapRow(ResultSet rs, int index) throws SQLException {
            Meeting meet = new Meeting();
            meet.setId(rs.getInt("id"));
            meet.setName(rs.getString("name"));
            meet.setTime(rs.getTimestamp("time").toLocalDateTime());
            return meet;
        }
    }
    
}
