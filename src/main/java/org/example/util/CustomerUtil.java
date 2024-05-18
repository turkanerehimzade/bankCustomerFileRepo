package org.example.util;

import org.example.Files.CustomerFile;
import org.example.model.*;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class CustomerUtil {
    public static void customerLogIn() throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 3; i++) {
            System.out.println("Please enter fin:");
            String a = scanner.next();
            System.out.println("Please enter password:");
            String b = scanner.next();

            if (CustomerLogIn.getFin().equals(a) && CustomerLogIn.getPassWord().equals(b)) {
                System.out.println("Successful login");
                while(true){
                CustomerMenu.printCustomerMenu();}
            } else {
                System.out.println("Fail!!!Please try again");
            }
            if (i == 3) {
                System.out.println("Unsuccessful!!! Exits the system...");
                System.exit(0);
            }
        }
    }

    public static void createCustomer() throws IOException, ClassNotFoundException {
        CustomerFile.checkFileCustomer(Db.customers);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please,enter a name:");
        String name = scanner.next();
        System.out.println("Please,enter a surname:");
        String surName = scanner.next();
        System.out.println("Please,enter a email:");
        String email = scanner.next();
        ActiveCustomer activeCustomer = ActiveCustomer.IS_ACTIVE;
        Customer customer = new Customer(Db.lastIndexCustomer++, name, surName, email, activeCustomer);
        DbUtil.addCustomer(customer);
        CustomerFile.writeCustomerFile(Db.customers);
        Customer[] customers = CustomerFile.readCustomerFile();
        System.out.println(Arrays.toString(customers));
        System.err.println("Customer created");
    }

    public static void deleteCustomer() throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter Customer'id that you want to delete:");
        int id = scanner.nextInt();
        for (Customer customer : Db.customers) {
            if (customer != null && customer.getId()==id) {
                if(customer.getActiveCustomer()!=ActiveCustomer.NOT_ACTIVE){
                customer.setActiveCustomer(ActiveCustomer.NOT_ACTIVE);
                    System.out.println("This customer is deleted...");
                CustomerFile.writeCustomerFile(Db.customers);
                Customer[] customers = CustomerFile.readCustomerFile();
                System.out.println(Arrays.toString(customers));}
                else{
                    System.out.println("There is no active customer with this id");
                }
            }
        }
    }
}