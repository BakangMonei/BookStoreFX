package com.javaassignment.myassignment.controller;

import com.javaassignment.myassignment.model.*;
import com.javaassignment.myassignment.util.*;
import javafx.fxml.*;
import javafx.scene.control.TextField;

import java.util.*;

public class AddBookController {
    @FXML
    private TextField txtISBN, txtTitle, txtAuthor, txtGenre, txtPrice, txtQuantity;

    @FXML
    private void addBook() {
        String isbn = txtISBN.getText();
        String title = txtTitle.getText();
        String author = txtAuthor.getText();
        String genre = txtGenre.getText();
        double price = Double.parseDouble(txtPrice.getText());
        int quantity = Integer.parseInt(txtQuantity.getText());

        Book book = new Book(isbn, title, author, genre, price, quantity);
        List<Book> books = FileUtil.readBooks();
        books.add(book);
        FileUtil.writeBooks(books);

        txtISBN.clear();
        txtTitle.clear();
        txtAuthor.clear();
        txtGenre.clear();
        txtPrice.clear();
        txtQuantity.clear();
    }
}