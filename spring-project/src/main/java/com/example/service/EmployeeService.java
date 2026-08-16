package com.example.service;

import org.springframework.stereotype.Service;

import com.example.dao.EmployeeDAO;
import com.example.model.Authentication;
import com.example.model.Employee;

@Service
public class EmployeeService {

    private final EmployeeDAO employeeDAO;

    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public Employee getEmployeeById(long id) {

        return employeeDAO.getEmployeeById(id);
    }
    public Employee  getEmployeeByEmail(String mail){
        return employeeDAO.getEmployeeByEmail(mail);
    }
    public Employee getEmployeeByPhnNo(long phn_no){
        return employeeDAO.getEmployeeByPhnNo(phn_no);
    }

    
    public void saveEmployee(Employee employee,Authentication authentication){
         employeeDAO.saveEmployee(employee,authentication);
          System.out.println("Employee details saved  successfully");
    }
    
    public int updateByName(Employee employee){
        int rows =  employeeDAO.updateByName(employee);
         return rows;
    }
    public int updatePhoneNo(Employee employee){
        int rows = employeeDAO.updatePhoneNo(employee);
        return rows;
    }
    public int  deleteEmployee(long id){
        int rows = employeeDAO.deleteEmployee(id);
        return rows;
    }

    public boolean passwordVerification(long id,String password){
        boolean rows = employeeDAO.passwordVerification(id, password);
        return rows;
    }
     
    
}
