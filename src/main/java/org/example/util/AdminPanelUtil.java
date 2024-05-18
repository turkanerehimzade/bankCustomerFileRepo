package org.example.util;

import org.example.model.Admin;
import org.example.model.AdminMenu;

import java.io.IOException;
import java.util.Scanner;

public class AdminPanelUtil {

    public static void adminLogIn() throws IOException, ClassNotFoundException {
        Scanner scanner=new Scanner(System.in);
        for(int i=1;i<=3;i++){
        System.out.println("Please enter username:");
        String a= scanner.next();
        System.out.println("Please enter password:");
        String b= scanner.next();

        if(Admin.getUserName().equals(a) && Admin.getPassWord().equals(b)){
            System.out.println("Successful login");
            while(true){
            AdminMenu.printAdminMenu();}
//            break;
        }else{
            System.out.println("Fail!!!Please try again");
        }
        if(i==3){
            System.out.println("Unsuccessful!!! Exits the system...");
            System.exit(0);
        }
    }}
}
