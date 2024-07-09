package com.javaassignment.myassignment.controller;

import com.javaassignment.myassignment.model.Book;
import com.javaassignment.myassignment.util.FileUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class SearchBookController {
    @FXML
    private TextField txtSearch;
    @FXML
    private ListView<String> searchResultsListView;

    @FXML
    private void searchBooks() {
        String query = txtSearch.getText().toLowerCase();
        ObservableList<String> searchResults = FXCollections.observableArrayList();
        for (Book book : FileUtil.readBooks()) {
            if (book.getTitle().toLowerCase().contains(query) ||
                    book.getAuthor().toLowerCase().contains(query) ||
                    book.getGenre().toLowerCase().contains(query)) {
                searchResults.add(book.toString());
            }
        }
        searchResultsListView.setItems(searchResults);
    }
}