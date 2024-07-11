package com.javaassignment.myassignment.controller;

import com.javaassignment.myassignment.model.*;
import com.javaassignment.myassignment.util.*;
import javafx.fxml.*;
import javafx.scene.control.*;

public class RevenueReportController {
    @FXML
    private Label lblTotalRevenue;

    @FXML
    private void initialize() {
        calculateTotalRevenue();
    }

    private void calculateTotalRevenue() {
        double totalRevenue = 0;
        for (Sale sale : FileUtil.readSales()) {
            totalRevenue += sale.getTotalAmount();
        }
        lblTotalRevenue.setText("Total Revenue: $" + totalRevenue);
    }
}
