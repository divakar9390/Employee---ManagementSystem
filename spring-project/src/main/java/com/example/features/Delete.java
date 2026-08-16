package com.example.features;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.example.service.EmployeeService;

public class Delete {
    public static void delete(Scanner scanner,EmployeeService employeeService ){
        try {
                         System.out.print("Enter Employee ID: ");
                        long id = scanner.nextLong();
                        scanner.nextLine();

                        System.out.print("Enter password:");
                        String password = scanner.nextLine();

                        boolean authentication = employeeService.passwordVerification(id, password);

                        if(authentication){
                            int rows = employeeService.deleteEmployee(id);
                            if(rows==1){
                                System.out.println("Employee Details Deleted");
                            }else{
                                System.out.println("Employee Not Found!");
                            }
                        }else{
                            System.out.println("Authentication failed! Wrong Employee ID or Password ");

                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Please Enter Valid Details of the Employee");
                        scanner.nextLine();
                    }

    }
    
}
