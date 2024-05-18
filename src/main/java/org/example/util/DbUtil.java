package org.example.util;

import org.example.Files.CartFile;
import org.example.Files.CustomerFile;
import org.example.model.Cart;
import org.example.model.Customer;
import org.example.model.Db;
import org.example.model.Transfer;

import java.io.*;

public class DbUtil {
    public static void addCustomer(Customer customer) throws IOException, ClassNotFoundException {
        Db.customers[Db.index++] = customer;
    }

    public static void addCart(Cart cart) throws IOException, ClassNotFoundException {
        Db.carts[Db.lastIndexCart1++] = cart;
    }

    public static void addTransfer(Transfer transfer) {
        Db.transfers[Db.index++]=transfer;

    }

    public static int checkFileIndex(Object[] objects) {
        int index=1;
        for (Object object : objects) {
            if (object != null) {
                index++;
            }
        }return index;
    }



}
