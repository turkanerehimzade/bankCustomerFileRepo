package org.example.model;

import org.example.model.Cart;
import org.example.model.Customer;
import org.example.util.DbUtil;

import java.io.IOException;

public class Db {
    public static Transfer[] transfers = new Transfer[20];
    public static Customer[] customers = new Customer[20];
    public static int index=0;
    public static Cart[] carts = new Cart[20];
    public static Long lastIndexCustomer=1L;
    public static Long lastIndexTransfer = 1L;
    public static Long lastIndexCart = 1L;
    public static int lastIndexCart1 = 0;

}
