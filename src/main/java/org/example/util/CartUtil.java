package org.example.util;

import org.example.Files.CartFile;
import org.example.Files.CustomerFile;
import org.example.model.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class CartUtil {
    public static void createCart() throws IOException, ClassNotFoundException {
        CartFile.checkFileCart(Db.carts);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter customer's id :");
        int id = scanner.nextInt();
        System.out.println("Please,enter a pan:");
        String pan = scanner.next();
        System.out.println("Please,enter a cvv:");
        String cvv = scanner.next();
        System.out.println("Please,enter a expirydate:");
        String expiryDate = scanner.next();
        StatusCart statusCart = StatusCart.UNBLOCKING;
        System.out.println("Please,enter a amount:");
        int amount = scanner.nextInt();
        Cart cart = new Cart(Db.lastIndexCart++, pan, cvv, expiryDate, statusCart, amount, Db.customers[id - 1]);
        DbUtil.addCart(cart);
        CartFile.writeCartFile(Db.carts);
        Cart[] carts = CartFile.readCartFile();
        System.out.println(Arrays.toString(carts));
        System.err.println("Cart Created");

    }

    public static void blockCart() throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter Cart's id that you want to blocking:");
        int id = scanner.nextInt();
        for (Cart cart : Db.carts) {
            if (cart != null && cart.getId() == id) {
                if (cart.getStatusCart() != StatusCart.UNBLOCKING) {
                    cart.setStatusCart(StatusCart.BLOCKING);
                    System.out.println("The cart of this customer is blocking...");
                    CartFile.writeCartFile(Db.carts);
                    Cart[] carts = CartFile.readCartFile();
                    System.out.println(Arrays.toString(carts));
                } else {
                    System.out.println("The cart of the customer with this id already is blocked!!!");
                }
            }
        }
    }

    public static void unblockCart() throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter Cart's id that you want to unblocking:");
        int id = scanner.nextInt();
        for (Cart cart : Db.carts) {
            if (cart != null && cart.getId() == id) {
                if (cart.getStatusCart() != StatusCart.UNBLOCKING) {
                    cart.setStatusCart(StatusCart.UNBLOCKING);
                    System.out.println("The cart of this customer is unblocking...");
                    CartFile.writeCartFile(Db.carts);
                    Cart[] carts = CartFile.readCartFile();
                    System.out.println(Arrays.toString(carts));
                }else {
                    System.out.println("The cart of the customer with this id already is unblocked!!!");
                }
            }
        }
    }
}
