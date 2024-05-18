package org.example.model;

import java.io.Serializable;
import java.util.StringJoiner;

public class Cart implements Serializable {
    public static final Long serialVersionUID = 1L;
    private Long id;
    private String pan;
    private String cvv;
    private String expiryDate;
    private StatusCart statusCart;
    private Customer customer;
    private int amount;

    public Cart(Long id, String pan, String cvv, String expiryDate, StatusCart statusCart,int amount, Customer customer) {
        this.id = id;
        this.pan = pan;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
        this.statusCart = statusCart;
        this.customer = customer;
        this.amount=amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public StatusCart getStatusCart() {
        return statusCart;
    }

    public void setStatusCart(StatusCart statusCart) {
        this.statusCart = statusCart;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Cart.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("pan='" + pan + "'")
                .add("cvv='" + cvv + "'")
                .add("expiryDate='" + expiryDate + "'")
                .add("statusCart=" + statusCart)
                .add("customer=" + customer)
                .add("amount=" + amount)
                .toString();
    }
}
