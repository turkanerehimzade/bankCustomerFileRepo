package org.example.Files;

import org.example.model.Customer;
import org.example.model.Db;
import org.example.model.Transfer;
import org.example.util.DbUtil;

import java.io.*;

public class TransactionsFile {
    public static String location = "C:\\Users\\User\\IdeaProjects\\BankCustomerFile\\transactions.txt";

    public static void writeTransferFile(Transfer[] transfers) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(location);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(transfers);
        objectOutputStream.close();
    }

    public static Transfer[] readTransferFile() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(location);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return (Transfer[]) objectInputStream.readObject();
    }

    public static void checkFileTransfer(Transfer[] transfers) throws IOException, ClassNotFoundException {
        File file = new File(TransactionsFile.location);
        if (!file.exists() || file.length() == 0) {
            return;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Db.transfers = (Transfer[]) objectInputStream.readObject();
        Db.lastIndexTransfer = (long) DbUtil.checkFileIndex(Db.transfers);
    }

    public static void printTransfer() throws IOException, ClassNotFoundException {
        checkFileTransfer(Db.transfers);
        for (Transfer transfer : Db.transfers){
            if(transfer!=null){
                System.out.println(transfer);
            }
        }
    }
}
