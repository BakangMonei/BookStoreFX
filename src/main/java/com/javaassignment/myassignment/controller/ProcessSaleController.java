package com.javaassignment.myassignment.controller;

import com.javaassignment.myassignment.model.Book;
import com.javaassignment.myassignment.model.Customer;
import com.javaassignment.myassignment.model.Sale;
import com.javaassignment.myassignment.util.FileUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.List;
import java.util.UUID;

public class ProcessSaleController {
    @FXML
    private ComboBox<String> cbISBN;
    @FXML
    private TextField txtTitle;
    @FXML
    private TextField txtAuthor;
    @FXML
    private TextField txtPrice;
    @FXML
    private TextField txtQuantity;
    @FXML
    private TextField txtCustomerId;
    @FXML
    private TextField txtCustomerName;
    @FXML
    private TextField txtCustomerAddress;
    @FXML
    private TextField txtCustomerPhone;
    @FXML
    private TextField txtCustomerEmail;

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
            // Handle invalid quantity input
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
                // Handle insufficient quantity
                System.out.println("Insufficient quantity");
            }
        }
        // Clear the text fields
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
