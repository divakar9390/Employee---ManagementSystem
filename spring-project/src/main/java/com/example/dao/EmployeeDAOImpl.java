package com.example.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.model.Authentication;
import com.example.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Employee> employeeRowMapper = (rs, rowNum) -> new Employee(
            rs.getLong("id"),
            rs.getString("name"),
            rs.getString("email"),
            rs.getString("department"),
            rs.getDouble("salary"),
            rs.getLong("phn_no") 
    );

    public EmployeeDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Employee getEmployeeById(long id) {
        String sql = "SELECT id, name, email, department, salary, phn_no FROM employee WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, employeeRowMapper, id);
        } catch (EmptyResultDataAccessException e) {
            return null; 
        }
    }
    @Override
    public Employee getEmployeeByEmail(String mail){
        String sql = "SELECT id,name,email,department,salary,phn_no FROM employee WHERE email = ?  ";
        try {
            return jdbcTemplate.queryForObject(sql, employeeRowMapper,mail);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    @Override
    public Employee getEmployeeByPhnNo(long phn_no){
        String sql = " SELECT id,name,email,department,salary,phn_no FROM employee WHERE phn_no = ?";
        try {
            return jdbcTemplate.queryForObject(sql, employeeRowMapper, phn_no);
        } catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void saveEmployee(Employee employee, Authentication authentication) {
        String sql = "INSERT INTO employee(id, name, email, department, salary, phn_no, pass) VALUES(?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, 
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getDepartment(),
                employee.getSalary(),
                employee.getPhnNo(),
                authentication.getPassword()
        );
    }
    

    @Override
    public int updateByName(Employee employee) {
        String sql = "UPDATE employee SET name = ? WHERE id = ?";
        return jdbcTemplate.update(sql, employee.getName(), employee.getId());
    }
    @Override
    public int updatePhoneNo(Employee employee){
        String sql =  "UPDATE employees SET phn_no = ? WHERE id = ?";
        return jdbcTemplate.update(sql,employee.getPhnNo(),employee.getId());
    }

     
    @Override
    public int deleteEmployee(long id) {
        String sql = "DELETE FROM employee WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public boolean passwordVerification(long id, String password) {
        String sql = "SELECT COUNT(*) FROM employee WHERE id = ? AND pass = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, id, password);
        return count != null && count == 1;
    }
}