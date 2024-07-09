package com.javaassignment.myassignment.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class BookstoreManagementSystemController {

    @FXML
    private MenuItem btnAddBook;
    @FXML
    private MenuItem btnManageInventory;
    @FXML
    private MenuItem btnProcessSale;
    @FXML
    private MenuItem btnSearchBook;
    @FXML
    private MenuItem btnCustomerManagement;
    @FXML
    private MenuItem btnRevenueReport;
    @FXML
    private MenuItem btnTopSellingBooks, btnViewCustomers;


    @FXML
    private void initialize() {
        btnAddBook.setOnAction(event -> openView("/com/javaassignment/myassignment/view/AddBook.fxml", "Add Book"));
        btnManageInventory.setOnAction(event -> openView("/com/javaassignment/myassignment/view/ManageInventory.fxml", "Manage Inventory"));
        btnProcessSale.setOnAction(event -> openView("/com/javaassignment/myassignment/view/ProcessSale.fxml", "Process Sale"));
        btnSearchBook.setOnAction(event -> openView("/com/javaassignment/myassignment/view/SearchBook.fxml", "Search Book"));
        btnCustomerManagement.setOnAction(event -> openView("/com/javaassignment/myassignment/view/CustomerManagement.fxml", "Customer Management"));
        btnRevenueReport.setOnAction(event -> openView("/com/javaassignment/myassignment/view/RevenueReport.fxml", "Revenue Report"));
        btnTopSellingBooks.setOnAction(event -> openView("/com/javaassignment/myassignment/view/TopSellingBooks.fxml", "Top Selling Books"));
        btnViewCustomers.setOnAction(event -> openView("/com/javaassignment/myassignment/view/ViewCustomers.fxml", "View All Customers"));
    }

    private void openView(String fxmlPath, String title) {
        try {
            URL fxmlLocation = getClass().getResource(fxmlPath);
            if (fxmlLocation == null) {
                throw new IllegalStateException("Cannot find FXML file: " + fxmlPath);
            }
            FXMLLoader loader = new FXMLLoader(fxmlLocation);
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}