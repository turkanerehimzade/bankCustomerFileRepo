package org.example.model;

import java.io.Serializable;
import java.util.StringJoiner;

public class Customer implements Serializable {
    public static final Long serialVersionUID = 1L;

    private  Long id;
    private   String name;
    private  String surname;
    private  String email;
    private  ActiveCustomer activeCustomer;

    public Customer(Long id, String name, String surname, String email, ActiveCustomer activeCustomer) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.activeCustomer = activeCustomer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public ActiveCustomer getActiveCustomer() {
        return activeCustomer;
    }

    public void setActiveCustomer(ActiveCustomer activeCustomer) {
        this.activeCustomer = activeCustomer;

    }



    @Override
    public String toString() {
        return new StringJoiner(", ", Customer.class.getSimpleName() + "[", "]")
                .add("id=" + this.id)
                .add("name='" + this.name + "'")
                .add("surname='" + this.surname + "'")
                .add("email='" + this.email + "'")
                .add("activeCustomer=" + this.activeCustomer)
                .toString();
    }
}
