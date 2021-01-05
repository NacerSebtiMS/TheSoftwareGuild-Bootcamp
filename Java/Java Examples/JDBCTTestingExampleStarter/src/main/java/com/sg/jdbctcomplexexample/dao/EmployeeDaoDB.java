package com.sg.jdbctcomplexexample.dao;

import com.sg.jdbctcomplexexample.entity.Employee;
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
public class EmployeeDaoDB implements EmployeeDao {
    
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public List<Employee> getAllEmployees() {
        final String SELECT_ALL_EMPLOYEES = "SELECT * FROM employee";
        return jdbc.query(SELECT_ALL_EMPLOYEES, new EmployeeMapper());
    }

    @Override
    public Employee getEmployeeById(int id) {
        try {
            final String SELECT_EMPLOYEE_BY_ID = "SELECT * FROM employee WHERE id = ?";
            return jdbc.queryForObject(SELECT_EMPLOYEE_BY_ID, new EmployeeMapper(), id);
        } catch(DataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional
    public Employee addEmployee(Employee employee) {
        final String INSERT_EMPLOYEE = "INSERT INTO employee(firstName, lastName) "
                + "VALUES(?,?)";
        jdbc.update(INSERT_EMPLOYEE, 
                employee.getFirstName(),
                employee.getLastName());
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        employee.setId(newId);
        return employee;
    }

    @Override
    public void updateEmployee(Employee employee) {
        final String UPDATE_EMPLOYEE = "UPDATE employee SET firstName = ?, lastName = ? "
                + "WHERE id = ?";
        jdbc.update(UPDATE_EMPLOYEE,
                employee.getFirstName(),
                employee.getLastName(),
                employee.getId());
    }

    @Override
    @Transactional
    public void deleteEmployeeById(int id) {
        final String DELETE_MEETING_EMPLOYEE = "DELETE FROM meeting_employee "
                + "WHERE employeeId = ?";
        jdbc.update(DELETE_MEETING_EMPLOYEE, id);
        
        final String DELETE_EMPLOYEE = "DELETE FROM employee WHERE id = ?";
        jdbc.update(DELETE_EMPLOYEE, id);
    }
    
    public static final class EmployeeMapper implements RowMapper<Employee> {

        @Override
        public Employee mapRow(ResultSet rs, int index) throws SQLException {
            Employee emp = new Employee();
            emp.setId(rs.getInt("id"));
            emp.setFirstName(rs.getString("firstName"));
            emp.setLastName(rs.getString("lastName"));
            return emp;
        }
    }
    
}
