package com.example.features.getdetails;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.dao.EmptyResultDataAccessException;

import com.example.model.Employee;
import com.example.service.EmployeeService;

public class GetDetailsById {
    public static  void getDetailsById(Scanner scanner,EmployeeService employeeService){
        try {
            System.out.print("Enter Employee ID: ");
            
            long id = scanner.nextLong();
            scanner.nextLine();

            System.out.print("Enter password: ");
            String password =scanner.nextLine();
            boolean authentication  = employeeService.passwordVerification(id,password);
            if(authentication){
                    Employee employee =
                employeeService.getEmployeeById(id);
            
            System.out.println(employee);

            }else{
                System.out.println("Authentication failed! Wrong Employee ID or Password ");

            }
        }
        catch (InputMismatchException e) {
                System.out.println("Invalid Input Please Try again");
                scanner.nextLine();
        } catch(EmptyResultDataAccessException e){
            System.out.println("Employee not found");
        }
    }
}
