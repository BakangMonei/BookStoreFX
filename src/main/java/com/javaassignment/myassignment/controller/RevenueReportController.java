package com.javaassignment.myassignment.controller;

import com.javaassignment.myassignment.model.Sale;
import com.javaassignment.myassignment.util.FileUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

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
