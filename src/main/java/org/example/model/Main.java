package org.example.model;

import org.example.Files.CustomerFile;
import org.example.Files.TransactionsFile;
import org.example.util.AdminPanelUtil;
import org.example.util.CartUtil;
import org.example.util.CustomerUtil;
import org.example.util.DbUtil;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
           Class.forName("org.example.util.DbUtil");
            Scanner scanner=new Scanner(System.in);
            System.out.println("Admin(1) or Customer(2) ?");
            int a=scanner.nextInt();
            switch (a){
                case 1:AdminPanelUtil.adminLogIn();break;
                case 2:CustomerUtil.customerLogIn();break;
                default:
                    System.out.println("Please select one of the options");
            }
    }
}
