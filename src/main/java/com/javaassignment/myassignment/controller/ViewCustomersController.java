package com.javaassignment.myassignment.controller;

import com.javaassignment.myassignment.model.Customer;
import com.javaassignment.myassignment.util.FileUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class ViewCustomersController {
    @FXML
    private TableView<Customer> customerTableView;
    @FXML
    private TableColumn<Customer, String> idColumn;
    @FXML
    private TableColumn<Customer, String> nameColumn;
    @FXML
    private TableColumn<Customer, String> addressColumn;
    @FXML
    private TableColumn<Customer, String> phoneColumn;
    @FXML
    private TableColumn<Customer, String> emailColumn;

    @FXML
    private void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        ObservableList<Customer> customers = FXCollections.observableArrayList();
        List<Customer> customersFromFile = FileUtil.readCustomers();
        customers.addAll(customersFromFile);
        customerTableView.setItems(customers);
    }
}