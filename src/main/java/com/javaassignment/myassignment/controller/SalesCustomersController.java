package com.javaassignment.myassignment.controller;

import com.javaassignment.myassignment.model.*;
import com.javaassignment.myassignment.util.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.*;

public class SalesCustomersController {
    @FXML
    private TableView<SaleCustomer> salesCustomersTable;
    @FXML
    private TableColumn<SaleCustomer, String> saleIdColumn;
    @FXML
    private TableColumn<SaleCustomer, String> bookIsbnColumn;
    @FXML
    private TableColumn<SaleCustomer, Integer> quantityColumn;
    @FXML
    private TableColumn<SaleCustomer, Double> totalAmountColumn;
    @FXML
    private TableColumn<SaleCustomer, String> saleDateColumn;
    @FXML
    private TableColumn<SaleCustomer, String> customerIdColumn;
    @FXML
    private TableColumn<SaleCustomer, String> customerNameColumn;
    @FXML
    private TableColumn<SaleCustomer, String> customerAddressColumn;
    @FXML
    private TableColumn<SaleCustomer, String> customerPhoneColumn;
    @FXML
    private TableColumn<SaleCustomer, String> customerEmailColumn;

    @FXML
    private void initialize() {
        saleIdColumn.setCellValueFactory(new PropertyValueFactory<>("saleId"));
        bookIsbnColumn.setCellValueFactory(new PropertyValueFactory<>("bookIsbn"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        totalAmountColumn.setCellValueFactory(new PropertyValueFactory<>("totalAmount"));
        saleDateColumn.setCellValueFactory(new PropertyValueFactory<>("saleDate"));
        customerIdColumn.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        customerAddressColumn.setCellValueFactory(new PropertyValueFactory<>("customerAddress"));
        customerPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("customerPhone"));
        customerEmailColumn.setCellValueFactory(new PropertyValueFactory<>("customerEmail"));

        ObservableList<SaleCustomer> saleCustomerList = FXCollections.observableArrayList(FileUtil.readSalesCustomers());
        salesCustomersTable.setItems(saleCustomerList);
    }
}
