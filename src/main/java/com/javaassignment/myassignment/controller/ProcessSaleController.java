package com.javaassignment.myassignment.controller;

import com.javaassignment.myassignment.model.Book;
import com.javaassignment.myassignment.model.Sale;
import com.javaassignment.myassignment.util.FileUtil;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.List;
import java.util.UUID;

public class ProcessSaleController {
    @FXML
    private TextField txtISBN;
    @FXML
    private TextField txtQuantity;

    @FXML
    private void processSale() {
        String isbn = txtISBN.getText();
        int quantity;
        try {
            quantity = Integer.parseInt(txtQuantity.getText());
        } catch (NumberFormatException e) {
            // Handle invalid quantity input
            System.out.println("Invalid quantity input");
            return;
        }

        List<Book> books = FileUtil.readBooks();

        for (Book book : books) {
            if (book.getIsbn().equals(isbn) && book.getQuantity() >= quantity) {
                book.setQuantity(book.getQuantity() - quantity);
                Sale sale = new Sale(UUID.randomUUID().toString(), isbn, quantity, book.getPrice() * quantity);
                List<Sale> sales = FileUtil.readSales();
                sales.add(sale);
                FileUtil.writeSales(sales);
                FileUtil.writeBooks(books);
                break;
            } else if (book.getIsbn().equals(isbn) && book.getQuantity() < quantity) {
                // Handle insufficient quantity
                System.out.println("Insufficient quantity");
            }
        }
        // Clear the text fields
        txtISBN.clear();
        txtQuantity.clear();
    }
}