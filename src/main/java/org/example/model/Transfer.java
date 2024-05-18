package org.example.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.StringJoiner;

public class Transfer implements Serializable {
    public static final Long serialVersionUID = 1L;
    private TransferForm transferForm;
    private LocalDateTime localDateTime;
    private String senderCart;
    private String receiver;
    private int amount;

    public Transfer(TransferForm transferForm, LocalDateTime localDateTime, String senderCart, String receiver, int amount) {
        this.transferForm = transferForm;
        this.localDateTime = localDateTime;
        this.senderCart = senderCart;
        this.receiver = receiver;
        this.amount = amount;
    }
    public TransferForm getTransferForm() {
        return transferForm;
    }

    public void setTransferForm(TransferForm transferForm) {
        this.transferForm = transferForm;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getSenderCart() {
        return senderCart;
    }

    public void setSenderCart(String senderCart) {
        this.senderCart = senderCart;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Transfer.class.getSimpleName() + "[", "]")
                .add("transferForm=" + transferForm)
                .add("localDateTime=" + localDateTime)
                .add("senderCart='" + senderCart + "'")
                .add("receiver='" + receiver + "'")
                .add("amount=" + amount)
                .toString();
    }

}
