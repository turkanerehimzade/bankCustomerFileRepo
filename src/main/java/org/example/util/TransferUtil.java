package org.example.util;

import org.example.Files.CartFile;
import org.example.Files.CustomerFile;
import org.example.Files.TransactionsFile;
import org.example.model.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class TransferUtil {
    public static void createTransfer() throws IOException, ClassNotFoundException {
        TransactionsFile.checkFileTransfer(Db.transfers);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter sender cart:");
        String senderCart = scanner.next();
        System.out.println("Enter receiver cart:");
        String receiverCart = scanner.next();
        System.out.println("The amount you want to send:");
        int amount = scanner.nextInt();
        TransferForm transferType = TransferForm.CART_TO_CART;
        LocalDateTime localDateTime = LocalDateTime.now();
        Transfer transfer = new Transfer(transferType, localDateTime, senderCart, receiverCart, amount);
        System.out.println(transfer);
        DbUtil.addTransfer(transfer);
        TransactionsFile.writeTransferFile(Db.transfers);
        Transfer[] transfers=TransactionsFile.readTransferFile();
        System.out.println(Arrays.toString(transfers));
        CartFile.checkFileCart(Db.carts);
        for (Cart cart : Db.carts) {
            if (cart != null && cart.getPan().equals(senderCart) && cart.getStatusCart().equals(StatusCart.UNBLOCKING)) {
                try {
                    if (cart.getAmount() >= transfer.getAmount()) {
                        cart.setAmount(cart.getAmount() - transfer.getAmount());
                        System.out.println(cart);
                        CartFile.writeCartFile(Db.carts);
                        throw new IllegalArgumentException();
                    } else if (cart.getAmount() < transfer.getAmount()) {
                        System.out.println("There is not enough money in the cart");
                    } else {
                        System.out.println("Enter correct amount");
                    }
                } catch (IllegalArgumentException exception) {
                }
                CartFile.writeCartFile(Db.carts);
            }
            if (cart != null && cart.getPan().equals(receiverCart)  && cart.getStatusCart().equals(StatusCart.UNBLOCKING)) {
                int fourDigitsFromCart = Integer.parseInt(cart.getPan().substring(0, 4));
                int fourDigitsToCart = Integer.parseInt(transfer.getReceiver().substring(0, 4));
                if (fourDigitsFromCart != fourDigitsToCart) {
                    int amountCom = transfer.getAmount() * 95 / 100;
                    cart.setAmount(cart.getAmount() + amountCom);
                    System.out.println(cart);
                }
            }
        }
    }

    public static void moneyTransferToPhoneNumber() throws IOException, ClassNotFoundException {
        TransactionsFile.checkFileTransfer(Db.transfers);
        CartFile.checkFileCart(Db.carts);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter sender cart:");
        String senderCart = scanner.next();
        System.out.println("The phone number we will send:");
        String phoneNumber = scanner.next();
        System.out.println("The amount you want to send:");
        int amount = scanner.nextInt();
        TransferForm transferForm=TransferForm.CART_TO_PHONENUMBER;
        LocalDateTime localDateTime = LocalDateTime.now();
        Transfer transfer = new Transfer(transferForm,localDateTime,senderCart,phoneNumber,amount);
        System.out.println(transfer);
        for (Cart cart : Db.carts) {
            if (cart != null && cart.getPan().equals(transfer.getSenderCart()) && cart.getStatusCart().equals(StatusCart.UNBLOCKING)
            ) {
                try {
                    if (cart.getAmount() >= transfer.getAmount()) {
                        cart.setAmount(cart.getAmount() - transfer.getAmount());
                        System.out.println(cart);
                        CartFile.writeCartFile(Db.carts);
                    } else if (cart.getAmount() < transfer.getAmount()) {
                        throw new IllegalArgumentException("There is not enough money in the cart");
                    } else {
                        System.out.println("Enter correct amount");
                    }
                } catch (IllegalArgumentException exception) {

                }
            }
        }
    }
}

