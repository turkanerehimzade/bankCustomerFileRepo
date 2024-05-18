package org.example.model;


public class Admin {
    private static String userName="abc";
    private static String passWord="abc123";

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        Admin.userName = userName;
    }

    public static String getPassWord() {
        return passWord;
    }

    public static void setPassWord(String passWord) {
        Admin.passWord = passWord;
    }
}
