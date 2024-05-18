package org.example.Files;

import org.example.model.Cart;
import org.example.model.Db;
import org.example.util.DbUtil;

import java.io.*;
import java.util.Arrays;

public class CartFile {

    public static String location="C:\\Users\\User\\IdeaProjects\\BankCustomerFile\\carts.txt";

    public static void writeCartFile(Cart[] carts) throws IOException {
        FileOutputStream fileOutputStream=new FileOutputStream(location);
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(Db.carts);
        objectOutputStream.close();


    }

    public static Cart[] readCartFile() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(location);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
       Cart[] carts = (Cart[]) objectInputStream.readObject();
        return carts;

    }
    public static void checkFileCart(Cart[] carts) throws IOException, ClassNotFoundException {
        File file = new File(CartFile.location);
        if (!file.exists() || file.length() == 0) {
            return ;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Db.carts = (Cart[]) objectInputStream.readObject();
        Db.index = DbUtil.checkFileIndex(Db.carts);
    }

}
