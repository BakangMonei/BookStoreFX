package com.javaassignment.myassignment.controller;

import com.javaassignment.myassignment.model.Book;
import com.javaassignment.myassignment.model.Sale;
import com.javaassignment.myassignment.util.FileUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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