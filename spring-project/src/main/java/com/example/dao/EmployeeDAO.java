package com.example.dao;

import com.example.model.Authentication;
import com.example.model.Employee;

public interface EmployeeDAO {

    Employee getEmployeeById(long id);
    Employee getEmployeeByEmail(String mail);
    Employee getEmployeeByPhnNo(long phn_no);

    void saveEmployee(Employee employee,Authentication authentication);

    int updateByName(Employee employee);
    int updatePhoneNo(Employee employee);
    
    int deleteEmployee(long id);
    boolean passwordVerification(long id,String password);
    

    
    
}
