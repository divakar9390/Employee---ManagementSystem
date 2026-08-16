package com.example.features.updates;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.example.model.Employee;
import com.example.service.EmployeeService;

public class UpdateName {

    public static void updateName(Scanner scanner ,EmployeeService employeeService){
        try {
                        System.out.print("Enter Employee ID: ");
                        long id = scanner.nextLong();

                        scanner.nextLine();

                        System.out.print("Enter password:");
                        String password = scanner.nextLine();

                        boolean authentication = employeeService.passwordVerification(id, password);


                        if(authentication){
                            System.out.print("Enter New Name: ");
                            String updateName = scanner.nextLine();

                            Employee updateEmployee =
                                    new Employee();

                            updateEmployee.setId(id);
                            updateEmployee.setName(updateName);

                            int rows = employeeService.updateByName(updateEmployee);
                            if(rows>=1){
                                System.out.println("Updated Employee Details Successfully");
                            }else{
                                System.out.println("Employee Not found ");
                            }


                        }else{

                             System.out.println("Authentication failed! Wrong Employee ID or Password ");


                        }
                        
                    } catch (InputMismatchException e) {
                        System.out.println("Please Enter Valid Details");
                        scanner.nextLine();

                    }
                
    }
    
}
