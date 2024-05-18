package org.example.model;

import org.example.Files.CustomerFile;
import org.example.Files.TransactionsFile;
import org.example.util.*;

import java.io.IOException;
import java.util.Scanner;


public class AdminMenu {
    private static String Menu =
                    "1.Add customers\n" +
                    "2.Remove customers\n" +
                    "3.Create a card for customer\n" +
                    "4.Block the customer's card\n" +
                            "5.UnBlock the customer's card\n"+
                    "6.A list of customers and their cards\n" +
                    "7.Money between customers see transfers\n" +
                    "8.Sign out";

    public static void printAdminMenu() throws IOException, ClassNotFoundException {
        System.err.println(Menu);
        Scanner scanner = new Scanner(System.in);
        int b = scanner.nextInt();
        switch (b) {
            case 1 ->CustomerUtil.createCustomer();
            case 2 ->CustomerUtil.deleteCustomer();
            case 3 ->CartUtil.createCart();
            case 4 ->CartUtil.blockCart();
            case 5->CartUtil.unblockCart();
            case 6 ->CustomerFile.printCustomerCart();
            case 7 -> TransactionsFile.printTransfer();
            case 8 ->System.exit(0);
            default ->System.err.println("Please select one of the options ");
        }
    }
}
