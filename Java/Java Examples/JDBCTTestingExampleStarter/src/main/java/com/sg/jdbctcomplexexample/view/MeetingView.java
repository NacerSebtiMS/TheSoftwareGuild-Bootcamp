package com.sg.jdbctcomplexexample.view;

import com.sg.jdbctcomplexexample.entity.Employee;
import com.sg.jdbctcomplexexample.entity.Meeting;
import com.sg.jdbctcomplexexample.entity.Room;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author kylerudy
 */
@Component
public class MeetingView {

    @Autowired
    UserIO io;

    public void printError(Exception ex) {
        io.print("ERROR: " + ex.getMessage());
        ex.printStackTrace();
    }

    public void displayProgramBanner() {
        io.print("Meeting Manager");
    }

    public void displayMenu() {
        io.print("1. Meetings");
        io.print("2. Rooms");
        io.print("3. Employees");
        io.print("4. Exit");
    }

    public int getMenuChoice(int maxChoice) {
        return io.readInt("Enter menu selection", 1, maxChoice);
    }

    public void exit() {
        io.print("Existing Meeting Manager");
    }

    public void displayEmployeesBanner() {
        io.print("");
        io.print("Employee Menu");
    }

    public void displayEmployeesMenu() {
        io.print("1. List Employees");
        io.print("2. Add Employee");
        io.print("3. Update Employee");
        io.print("4. Delete Employee");
        io.print("5. View Meetings for Employee");
        io.print("6. Add Employee to Meeting");
        io.print("7. Return to Main Menu");
    }

    public void returnToMainMenu() {
        io.print("Returning to Main Menu");
        io.print("");
    }

    public void listEmployeesBanner() {
        io.print("All Employees");
    }

    public void listEmployees(List<Employee> employees) {
        for (Employee e : employees) {
            StringBuilder sb = new StringBuilder();
            sb.append(e.getId());
            sb.append(" -- ");
            sb.append(e.getFirstName());
            sb.append(" -- ");
            sb.append(e.getLastName());
            io.print(sb.toString());
        }
        io.print("");
    }

    public void addEmployeeBanner() {
        io.print("Adding Employee");
    }

    public String getEmployeeFirstName() {
        return io.readString("Enter employee first name: ");
    }

    public String getEmployeeLastName() {
        return io.readString("Enter employee last name: ");
    }

    public void addEmployeeSuccess() {
        io.print("Employee added successfully");
    }

    public void updateEmployeeBanner() {
        io.print("Updating Employee");
    }

    public int getEmployeeId() {
        return io.readInt("Enter ID of employee: ");
    }

    public String updateField(String fieldName, String original) {
        String update = io.readString("Update " + fieldName + " (" + original + "): ");
        if (update.trim().isEmpty()) {
            return original;
        }
        return update;
    }

    public void updateEmployeeSuccess() {
        io.print("Employee updated successfully");
    }

    public void displayUpdateInstructions() {
        io.print("Hit enter to keep original value.");
    }

    public void invalidEmployee() {
        io.print("No employee with that ID.");
    }

    public void deleteEmployeeBanner() {
        io.print("Deleting Employee");
    }

    public void deleteEmployeeSuccess() {
        io.print("Employee deleted successfully");
    }

    public void listMeetingsForEmployeeBanner() {
        io.print("Listing meetings for employee");
    }

    public void displayEmployee(Employee employee) {
        StringBuilder sb = new StringBuilder();
        sb.append(employee.getId());
        sb.append(" -- ");
        sb.append(employee.getFirstName());
        sb.append(" -- ");
        sb.append(employee.getLastName());
        io.print(sb.toString());
    }

    public void displayMeetings(List<Meeting> meetings) {
        io.print("");
        for (Meeting meeting : meetings) {
            StringBuilder sb = new StringBuilder();
            sb.append(meeting.getId());
            sb.append(" -- ");
            sb.append(meeting.getName());
            sb.append(" -- ");
            sb.append(meeting.getTime());
            sb.append(" -- ");
            sb.append(meeting.getRoom().getName());
            sb.append(" -- ");
            sb.append("# of Attendees: ");
            sb.append(meeting.getAttendees().size());
            io.print(sb.toString());
        }
    }

    public void displayRoomBanner() {
        io.print("");
        io.print("Room Menu");
    }

    public void displayRoomMenu() {
        io.print("1. List Rooms");
        io.print("2. Add Room");
        io.print("3. Update Room");
        io.print("4. Delete Room");
        io.print("5. View Meetings for Room");
        io.print("6. Return to Main Menu");
    }

    public void listRoomsBanner() {
        io.print("All Rooms");
    }

    public void displayRooms(List<Room> rooms) {
        for (Room room : rooms) {
            StringBuilder sb = new StringBuilder();
            sb.append(room.getId());
            sb.append(" -- ");
            sb.append(room.getName());
            sb.append(" -- ");
            sb.append(room.getDescription());
            io.print(sb.toString());
        }
        io.print("");
    }

    public void addRoomBanner() {
        io.print("Adding Room");
    }

    public String getRoomName() {
        return io.readString("Enter room name: ");
    }

    public String getRoomDescription() {
        return io.readString("Enter room description");
    }

    public void addRoomSuccess() {
        io.print("Room added successfully");
    }

    public int getMeetingIdToJoin() {
        return io.readInt("Enter ID of meeting to add employee to: ");
    }

    public void addEmployeToMeetingBanner() {
        io.print("Adding Employee to Meeting");
    }

    public void addEmployeeToMeetingSuccess() {
        io.print("Employee added to meeting");
    }

    public void updateRoomBanner() {
        io.print("Updating Room");
    }

    public int getRoomId() {
        return io.readInt("Enter ID of room: ");
    }

    public void invalidRoom() {
        io.print("No room with that ID");
    }

    public void updateRoomSuccess() {
        io.print("Room updated successfully");
    }

    public void deleteRoomBanner() {
        io.print("Deleting Room");
    }

    public void deleteRoomSuccess() {
        io.print("Room deleted successfully");
    }

    public void listMeetingsForRoomBanner() {
        io.print("Listing meetings for room");
    }

    public void displayRoom(Room room) {
        StringBuilder sb = new StringBuilder();
        sb.append(room.getId());
        sb.append(" -- ");
        sb.append(room.getName());
        sb.append(" -- ");
        sb.append(room.getDescription());
        io.print(sb.toString());
    }

    public void displayMeetingBanner() {
        io.print("");
        io.print("Meeting Menu");
    }

    public void displayMeetingMenu() {
        io.print("1. List Meetings");
        io.print("2. Add Meeting");
        io.print("3. Update Meeting");
        io.print("4. Delete Meeting");
        io.print("5. Return to Main Menu");
    }

    public void listMeetingsBanner() {
        io.print("All Meetings");
    }

    public void addMeetingBanner() {
        io.print("Adding Meeting");
    }

    public String getMeetingName() {
        return io.readString("Enter meeting name: ");
    }

    public LocalDateTime getMeetingDatetime() {
        int year = io.readInt("Enter meeting year: ");
        int month = io.readInt("Enter meeting month: ");
        int day = io.readInt("Enter meeting day: ");
        int hour = io.readInt("Enter meeting hour (0-23): ");
        int minute = io.readInt("Enter meeting minute: ");
        
        return LocalDateTime.of(year, month, day, hour, minute);
    }

    public int getMeetingRoomId() {
        return io.readInt("Enter room ID: ");
    }

    public void addMeetingSuccess() {
        io.print("Meeting added successfully");
    }

    public void updateMeetingBanner() {
        io.print("Updating Meeting");
    }

    public int getMeetingId() {
        return io.readInt("Enter ID of Meeting: ");
    }

    public LocalDateTime updateMeetingTime(LocalDateTime time) {
        String year = io.readString("Enter meeting year(" + time.getYear() + "): ");
        String month = io.readString("Enter meeting month(" + time.getMonth().getValue() + "): ");
        String day = io.readString("Enter meeting day(" + time.getDayOfMonth()+ "): ");
        String hour = io.readString("Enter meeting hour (0-23) (" + time.getHour()+ "): ");
        String minute = io.readString("Enter meeting minute(" + time.getMinute()+ "): ");
        if(!year.trim().isEmpty()) {
            time.withYear(Integer.parseInt(year));
        }
        if(!month.trim().isEmpty()) {
            time.withMonth(Integer.parseInt(month));
        }
        if(!day.trim().isEmpty()) {
            time.withDayOfMonth(Integer.parseInt(day));
        }
        if(!hour.trim().isEmpty()) {
            time.withHour(Integer.parseInt(hour));
        }
        if(!minute.trim().isEmpty()) {
            time.withMinute(Integer.parseInt(minute));
        }
        
        return time;
    }

    public void updateMeetingSuccess() {
        io.print("Meeting updated successfully");
    }

    public void invalidMeeting() {
        io.print("No meeting with that ID");
    }

    public void deleteMeetingBanner() {
        io.print("Deleting Meeting");
    }

    public void deleteMeetingSuccess() {
        io.print("Meeting deleted successfully");
    }
}
