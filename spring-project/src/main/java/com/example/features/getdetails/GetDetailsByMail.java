package com.example.features.getdetails;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.dao.EmptyResultDataAccessException;

import com.example.model.Employee;
import com.example.service.EmployeeService;

public class GetDetailsByMail {
    public static void getDetailsByMail(Scanner scanner,EmployeeService employeeService){

        try {
            System.out.print("Enter Employee Id:");
            long id = scanner.nextLong();
            scanner.nextLine();

            System.out.print("Enter password:");
            String password = scanner.nextLine();

            boolean authentication = employeeService.passwordVerification(id,password);
            if(authentication){
                System.out.print("Please Enter Employee mail:");
                String email = scanner.nextLine();
                Employee employee = employeeService.getEmployeeByEmail(email);
                System.out.println(employee);
                
            }else{
                System.out.println("Authentication Failed!");
            }
            
        } catch (InputMismatchException e) {
            System.out.println("Please Enter Valid Details");
        }catch (EmptyResultDataAccessException e){
            System.out.println("Employee Not  Founnd!");

        }

        
    }
    
}
