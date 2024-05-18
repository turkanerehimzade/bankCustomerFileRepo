package org.example.model;

public class CustomerLogIn {

    private static String fin="abc";
    private static String passWord="1234";

    public CustomerLogIn() {
    }

    public CustomerLogIn(String fin, String passWord) {
        this.fin=fin;
        this.passWord=passWord;
    }

    public static String getFin() {
        return fin;
    }

    public static void setFin(String fin) {
        CustomerLogIn.fin = fin;
    }

    public static String getPassWord() {
        return passWord;
    }

    public static void setPassWord(String passWord) {
        CustomerLogIn.passWord = passWord;
    }
}
