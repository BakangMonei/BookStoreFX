package com.javaassignment.myassignment.controller;

import com.javaassignment.myassignment.model.*;
import com.javaassignment.myassignment.util.*;
import javafx.fxml.*;
import javafx.scene.control.*;

import java.util.List;

public class CustomerManagementController {
    @FXML
    private TextField txtCustomerId, txtCustomerName, txtAddress, txtPhone, txtEmail;

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

        txtCustomerId.clear();
        txtCustomerName.clear();
        txtAddress.clear();
        txtPhone.clear();
        txtEmail.clear();
    }
}