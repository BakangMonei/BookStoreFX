package com.javaassignment.myassignment.controller;

import com.javaassignment.myassignment.model.Customer;
import com.javaassignment.myassignment.util.FileUtil;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.List;

public class CustomerManagementController {
    @FXML
    private TextField txtCustomerId;
    @FXML
    private TextField txtCustomerName;
    @FXML
    private TextField txtAddress;
    @FXML
    private TextField txtPhone;
    @FXML
    private TextField txtEmail;

    @FXML
    private void addCustomer() {
        String id = txtCustomerId.getText();
        String name = txtCustomerName.getText();
        String address = txtAddress.getText();
        String phone = txtPhone.getText();
        String email = txtEmail.getText();
        Customer customer = new Customer(id, name, address, phone, email);
        List<Customer> customers = FileUtil.readCustomers();
        customers.add(customer);
        FileUtil.writeCustomers(customers);

        // Clear the text fields
        txtCustomerId.clear();
        txtCustomerName.clear();
        txtAddress.clear();
        txtPhone.clear();
        txtEmail.clear();
    }
}