package org.example.Files;

import org.example.model.ActiveCustomer;
import org.example.model.Cart;
import org.example.model.Customer;
import org.example.model.Db;
import org.example.util.DbUtil;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class CustomerFile {
    public static String location = "C:\\Users\\User\\IdeaProjects\\BankCustomerFile\\customers.txt";

    public static void writeCustomerFile(Customer[] customers) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(location);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(customers);
        objectOutputStream.close();
    }

    public static Customer[] readCustomerFile() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(location);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        return (Customer[]) objectInputStream.readObject();
    }
    public static void printCustomerCart() throws IOException, ClassNotFoundException {
        CustomerFile.checkFileCustomer(Db.customers);
        CartFile.checkFileCart(Db.carts);
        for (Cart cart : Db.carts) {
            if (cart != null) {
                System.out.println(cart);
            }
        }
    }

    public static void checkFileCustomer(Customer[] customers)  throws IOException, ClassNotFoundException {
        File file = new File(CustomerFile.location);
        if (!file.exists() || file.length() == 0) {
            return;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Db.customers = (Customer[]) objectInputStream.readObject();
        Db.lastIndexCustomer = (long) DbUtil.checkFileIndex(Db.customers);
    }
}

