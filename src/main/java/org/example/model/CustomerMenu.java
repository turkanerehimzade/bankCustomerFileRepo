package org.example.model;

import org.example.Files.CustomerFile;
import org.example.util.CartsOfCustomer;
import org.example.util.TransferUtil;

import java.io.IOException;
import java.util.Scanner;

public class CustomerMenu {
    private static String Menu =
            "1.He see the cards he has\n" +
                    "2.Money transfer to another card\n" +
                    "3.Money from your card to your phone number to send\n" +
                    "4.Change user password\n" +
                    "5.Sign out";

    public static void printCustomerMenu() throws IOException, ClassNotFoundException {
        System.err.println(Menu);
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        switch (a) {
            case 1 -> CartsOfCustomer.seeCarts();
            case 2 -> TransferUtil.createTransfer();
            case 3 -> TransferUtil.moneyTransferToPhoneNumber();
            case 4 -> CartsOfCustomer.changePassword();
            case 5 -> System.exit(0);
            default -> System.out.println("Please select one of the options ");
        }
    }
}
