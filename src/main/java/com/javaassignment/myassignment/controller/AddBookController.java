package com.javaassignment.myassignment.controller;

import com.javaassignment.myassignment.model.Book;
import com.javaassignment.myassignment.util.FileUtil;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.List;

public class AddBookController {
    @FXML
    private TextField txtISBN;
    @FXML
    private TextField txtTitle;
    @FXML
    private TextField txtAuthor;
    @FXML
    private TextField txtGenre;
    @FXML
    private TextField txtPrice;
    @FXML
    private TextField txtQuantity;

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

        // Clear the text fields
        txtISBN.clear();
        txtTitle.clear();
        txtAuthor.clear();
        txtGenre.clear();
        txtPrice.clear();
        txtQuantity.clear();
    }
}