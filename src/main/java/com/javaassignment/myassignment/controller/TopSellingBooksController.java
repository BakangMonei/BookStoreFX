package com.javaassignment.myassignment.controller;

import com.javaassignment.myassignment.model.*;
import com.javaassignment.myassignment.util.*;
import javafx.collections.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import java.util.*;
import java.util.stream.*;

public class TopSellingBooksController {
    @FXML
    private ListView<String> topSellingBooksListView;

    @FXML
    private void initialize() {
        loadTopSellingBooks();
    }

    private void loadTopSellingBooks() {
        Map<String, Integer> bookSales = new HashMap<>();
        List<Sale> sales = FileUtil.readSales();

        for (Sale sale : sales) {
            bookSales.put(sale.getBookIsbn(), bookSales.getOrDefault(sale.getBookIsbn(), 0) + sale.getQuantity());
        }

        ObservableList<String> topSellingBooks = FXCollections.observableArrayList(
                bookSales.entrySet().stream()
                        .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                        .limit(10)
                        .map(entry -> {
                            Book book = FileUtil.readBooks().stream()
                                    .filter(b -> b.getIsbn().equals(entry.getKey()))
                                    .findFirst()
                                    .orElse(null);
                            return book != null ? book.getTitle() + " - " + entry.getValue() + " sold" : "";
                        })
                        .collect(Collectors.toList())
        );

        topSellingBooksListView.setItems(topSellingBooks);
    }
}