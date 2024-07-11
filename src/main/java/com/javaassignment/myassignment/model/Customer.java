package com.javaassignment.myassignment.model;

import java.io.*;
import java.util.*;

public class Customer implements Serializable {
    private String id, name, address, phone, email;
    private List<Sale> purchaseHistory;

    public Customer(){
        super();
    }

    public Customer(String id, String name, String address, String phone, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.purchaseHistory = new ArrayList<>();
    }

    public void addPurchase(Sale sale) {
        purchaseHistory.add(sale);
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Sale> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void setPurchaseHistory(List<Sale> purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + address + "," + phone + "," + email;
    }
}
