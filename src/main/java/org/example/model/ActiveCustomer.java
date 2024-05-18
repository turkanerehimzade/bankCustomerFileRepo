package org.example.model;

public enum ActiveCustomer {
    IS_ACTIVE(1),
    NOT_ACTIVE(0);
    private int a;

    ActiveCustomer(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;

    }

}
