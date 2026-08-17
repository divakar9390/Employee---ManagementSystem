package com.example;


import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.AppConfig;
import com.example.features.AddNewEmployee;
import com.example.features.Delete;
import com.example.features.getdetails.GetDetailsById;
import com.example.features.getdetails.GetDetailsByMail;
import com.example.features.getdetails.GetDetailsByPhnNo;
import com.example.features.updates.UpdateName;
import com.example.features.updates.UpdatePhnNo;
import com.example.service.EmployeeService;


public class App {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        EmployeeService employeeService =
                context.getBean(EmployeeService.class);

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Get Employee Details");
            System.out.println("2. Add Employee details ");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: {

                        boolean exitDetailsMenu = false;

                        while (!exitDetailsMenu) {

                            System.out.println("\n===== Get Employee Details =====");
                            System.out.println("1. Get Details Using Id");
                            System.out.println("2. Get Details Using Email");
                            System.out.println("3. Get Details Using PhoneNo");
                            System.out.println("4. Main menu");
                            System.out.print("Enter your choice: ");

                            int choice2 = scanner.nextInt();

                            switch (choice2) {

                                case 1:
                                    GetDetailsById.getDetailsById(scanner, employeeService);
                                    break;

                                case 2:
                                    GetDetailsByMail.getDetailsByMail(scanner, employeeService);
                                    break;

                                case 3:
                                    GetDetailsByPhnNo.getDetailsByPhnNo(scanner, employeeService);
                                    break;

                                case 4:
                                    try {
                                        System.out.println("Returning to Main menu.........");
                                        Thread.sleep(1000);

                                        System.out.println("Please wait..........");
                                        Thread.sleep(2000);

                                    } catch (InterruptedException e) {
                                        Thread.currentThread().interrupt();
                                    }

                                    exitDetailsMenu = true;
                                    break;

                                default:
                                    System.out.println("Invalid choice. Please try again.");
                            }
                        }

                        break;
                    }

                
                        
                case 2: {
                    
                    AddNewEmployee.addNewEmployee(scanner, employeeService);
                    break;
                        }

                case 3:{
                    boolean exitDetailsMenu = false;

                        while (!exitDetailsMenu) {

                            System.out.println("\n===== Update Employee Details =====");
                            System.out.println("1.Update Name");
                            System.out.println("2. Update PhoneNo");
                            System.out.println("3. Main menu");
                            System.out.print("Enter your choice: ");

                            int choice3 = scanner.nextInt();

                            switch (choice3) {

                                case 1:
                                    UpdateName.updateName(scanner, employeeService);
                                    break;

                                case 2:
                                    UpdatePhnNo.UpdatePhnNo(scanner, employeeService);
                                    break;

                                case 3:
                                    try {
                                        System.out.println("Returning to Main menu.........");
                                        Thread.sleep(1000);

                                        System.out.println("Please wait..........");
                                        Thread.sleep(2000);

                                    } catch (InterruptedException e) {
                                        Thread.currentThread().interrupt();
                                    }

                                    exitDetailsMenu = true;
                                    break;

                                default:
                                    System.out.println("Invalid choice. Please try again.");
                            }
                        }

                    
                    break;
                }

                case 4:{
                    Delete.delete(scanner, employeeService);     
                    break;
                }
                case 5:{
                    System.out.println("Thank you for using Employee Management System!");
                    scanner.close();
                    return;
                }
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        }
    }
}
