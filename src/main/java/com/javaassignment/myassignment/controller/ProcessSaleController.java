package com.javaassignment.myassignment.controller;

import com.javaassignment.myassignment.model.*;
import com.javaassignment.myassignment.util.*;
import javafx.collections.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import java.util.*;

public class ProcessSaleController {
    @FXML
    private ComboBox<String> cbISBN;
    @FXML
    private TextField txtTitle, txtAuthor, txtPrice, txtQuantity,
            txtCustomerId, txtCustomerName, txtCustomerAddress, txtCustomerPhone, txtCustomerEmail;

    @FXML
    private void initialize() {
        List<Book> books = FileUtil.readBooks();
        ObservableList<String> bookIsbns = FXCollections.observableArrayList();

        for (Book book : books) {
            bookIsbns.add(book.getIsbn());
        }

        cbISBN.setItems(bookIsbns);
        cbISBN.setOnAction(event -> {
            String selectedISBN = cbISBN.getSelectionModel().getSelectedItem();
            for (Book book : books) {
                if (book.getIsbn().equals(selectedISBN)) {
                    txtTitle.setText(book.getTitle());
                    txtAuthor.setText(book.getAuthor());
                    txtPrice.setText(String.valueOf(book.getPrice()));
                }
            }
        });
    }

    @FXML
    private void processSale() {
        String isbn = cbISBN.getValue();
        int quantity;
        try {
            quantity = Integer.parseInt(txtQuantity.getText());
        } catch (NumberFormatException e) {
            System.out.println("Invalid quantity input");
            return;
        }

        String customerId = txtCustomerId.getText();
        String customerName = txtCustomerName.getText();
        String customerAddress = txtCustomerAddress.getText();
        String customerPhone = txtCustomerPhone.getText();
        String customerEmail = txtCustomerEmail.getText();

        Customer customer = new Customer(customerId, customerName, customerAddress, customerPhone, customerEmail);

        List<Book> books = FileUtil.readBooks();
        List<Sale> sales = FileUtil.readSales();
        List<Customer> customers = FileUtil.readCustomers();

        for (Book book : books) {
            if (book.getIsbn().equals(isbn) && book.getQuantity() >= quantity) {
                book.setQuantity(book.getQuantity() - quantity);
                Sale sale = new Sale(UUID.randomUUID().toString(), isbn, quantity, book.getPrice() * quantity);
                sales.add(sale);
                customer.addPurchase(sale);
                customers.add(customer);
                FileUtil.writeSales(sales);
                FileUtil.writeBooks(books);
                FileUtil.writeCustomers(customers);
                FileUtil.writeSalesCustomers(sales, customers);
                break;
            } else if (book.getIsbn().equals(isbn) && book.getQuantity() < quantity) {
                System.out.println("Insufficient quantity");
            }
        }
        cbISBN.setValue(null);
        txtTitle.clear();
        txtAuthor.clear();
        txtPrice.clear();
        txtQuantity.clear();
        txtCustomerId.clear();
        txtCustomerName.clear();
        txtCustomerAddress.clear();
        txtCustomerPhone.clear();
        txtCustomerEmail.clear();
    }
}
