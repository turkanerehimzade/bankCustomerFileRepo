package org.example.util;

import org.example.Files.CartFile;
import org.example.Files.CustomerFile;
import org.example.model.Cart;
import org.example.model.Customer;
import org.example.model.CustomerLogIn;
import org.example.model.Db;

import java.io.IOException;
import java.util.Scanner;

public class CartsOfCustomer {
    public static void seeCarts() throws IOException, ClassNotFoundException {
        CartFile.checkFileCart(Db.carts);
        CustomerFile.checkFileCustomer(Db.customers);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter own id:");
        int id = scanner.nextInt();
        for (Cart cart : Db.carts) {
            if (cart != null && cart.getCustomer().getId() == id) {
                System.out.println(cart);
            }
        }
    }

    public static void changePassword() throws IOException, ClassNotFoundException {
        CartFile.checkFileCart(Db.carts);
        CustomerFile.checkFileCustomer(Db.customers);
        Scanner scanner = new Scanner(System.in);
        String fin=CustomerLogIn.getFin();
        String passWord=CustomerLogIn.getPassWord();
        System.out.println("Enter old password:");
        String oldPassword = scanner.next();
        System.out.println("Enter new password:");
        String newPassword1 = scanner.next();
        System.out.println("Re-enter new password:");
        String newPassword2 = scanner.next();
        CustomerLogIn customerLogIn = new CustomerLogIn(fin,passWord);
        if (passWord.equals(oldPassword) && newPassword1.equals(newPassword2)) {
            customerLogIn.setPassWord(newPassword1);
            System.out.println("The password changed successfully..,");
            System.out.println(customerLogIn.getPassWord());
        }
    }
}
