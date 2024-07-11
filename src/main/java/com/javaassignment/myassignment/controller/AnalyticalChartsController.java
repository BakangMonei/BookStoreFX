package com.javaassignment.myassignment.controller;

import javafx.fxml.*;
import javafx.scene.chart.*;

import java.io.*;
import java.util.*;

public class AnalyticalChartsController {

    public static final String BOOKS_FILE = "data/books.txt";
    public static final String CUSTOMERS_FILE = "data/customers.txt";
    public static final String SALES_FILE = "data/sales.txt";

    @FXML
    private BarChart<String, Number> salesBarChart;
    @FXML
    private CategoryAxis xAxis;
    @FXML
    private NumberAxis yAxis;

    @FXML
    private void initialize() {
        xAxis.setLabel("Book Titles");
        yAxis.setLabel("Copies Sold");

        Map<String, Integer> salesData = readSalesData();
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Sales Data");

        for (Map.Entry<String, Integer> entry : salesData.entrySet()) {
            series.getData().add(new XYChart.Data<>(entry.getKey(), entry.getValue()));
        }

        salesBarChart.getData().add(series);
    }

    private Map<String, Integer> readSalesData() {
        Map<String, String> bookTitles = new HashMap<>();
        Map<String, Integer> salesData = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(BOOKS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String isbn = parts[0];
                String title = parts[1];
                bookTitles.put(isbn, title);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(SALES_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String isbn = parts[1];
                int quantity = Integer.parseInt(parts[2]);

                String title = bookTitles.get(isbn);
                salesData.put(title, salesData.getOrDefault(title, 0) + quantity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return salesData;
    }
}
