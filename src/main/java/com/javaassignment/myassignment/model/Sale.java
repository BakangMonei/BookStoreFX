package com.javaassignment.myassignment.model;

import java.io.*;
import java.time.*;

public class Sale implements Serializable {
    private String saleId, bookIsbn;
    private int quantity;
    private double totalAmount;
    private LocalDateTime saleDate;

    public Sale(){
        super();
    }

    public Sale(String saleId, String bookIsbn, int quantity, double totalAmount) {
        this.saleId = saleId;
        this.bookIsbn = bookIsbn;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.saleDate = LocalDateTime.now();
    }

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
    }

    @Override
    public String toString() {
        return saleId + "," + bookIsbn + "," + quantity + "," + totalAmount + "," + saleDate;
    }
}
