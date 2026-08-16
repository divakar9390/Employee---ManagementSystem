package com.example.features;

import java.util.Random;
import java.util.Scanner;

import com.example.model.Authentication;
import com.example.model.Employee;
import com.example.service.EmployeeService;

public class AddNewEmployee {

    public static void addNewEmployee(Scanner scanner,EmployeeService employeeService){
        Random random = new Random();
                    long newId = 10_000_000_000L + (long) (random.nextDouble() * 90_000_000_000L);

                    scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();

                    System.out.print("Enter Phone_no:");
                    long Phone_No = scanner.nextLong();
                    scanner.nextLine();
         


                    System.out.print("Enter password:");
                    String password = scanner.nextLine();


                    Authentication authentication = new Authentication(password);

                    Employee newEmployee =
                            new Employee(
                                    newId,
                                    name,
                                    email,
                                    department,
                                    salary,
                                    Phone_No
                            );

                    employeeService.saveEmployee(newEmployee,authentication);

                    System.out.println("Please wait.....................");
                     System.out.println("Your EmployeeId:"+newId);

    }
    
}
