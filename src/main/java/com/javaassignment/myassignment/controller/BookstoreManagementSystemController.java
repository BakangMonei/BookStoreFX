package com.javaassignment.myassignment.controller;

import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;

import java.io.*;
import java.net.*;

public class BookstoreManagementSystemController {

    @FXML
    private MenuItem btnAddBook, btnManageInventory, btnProcessSale,
            btnSearchBook, btnCustomerManagement, btnViewCustomersSales,
            btnRevenueReport, btnTopSellingBooks, btnViewCustomers, btnAnalyticalCharts;
    @FXML
    private Button btnRevenueReportCenter, btnTopSellingBooksCenter, btnAnalyticalChartsCenter;

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
        btnAnalyticalCharts.setOnAction(event -> openView("/com/javaassignment/myassignment/view/AnalyticalCharts.fxml", "Analytical Charts"));
        btnViewCustomersSales.setOnAction(actionEvent -> openView("/com/javaassignment/myassignment/view/SalesCustomersView.fxml", "Customer Sales"));
        btnRevenueReportCenter.setOnAction(event -> openView("/com/javaassignment/myassignment/view/RevenueReport.fxml", "Revenue Report"));
        btnTopSellingBooksCenter.setOnAction(event -> openView("/com/javaassignment/myassignment/view/TopSellingBooks.fxml", "Top Selling Books"));
        btnAnalyticalChartsCenter.setOnAction(event -> openView("/com/javaassignment/myassignment/view/AnalyticalCharts.fxml", "Analytical Charts"));
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
