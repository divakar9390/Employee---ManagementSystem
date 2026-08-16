package com.example.features.getdetails;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.dao.EmptyResultDataAccessException;

import com.example.model.Employee;
import com.example.service.EmployeeService;



public class GetDetailsByPhnNo {

    public static void getDetailsByPhnNo(Scanner scanner,EmployeeService employeeService){
         try {
            System.out.print("Enter Employee Id:");
            long id = scanner.nextLong();
            scanner.nextLine();

            System.out.println("Enter password:");
            String password = scanner.nextLine();

            boolean authentication = employeeService.passwordVerification(id,password);
            if(authentication){
                long phn_no = scanner.nextLong();
                Employee employee = employeeService.getEmployeeByPhnNo(phn_no);
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
