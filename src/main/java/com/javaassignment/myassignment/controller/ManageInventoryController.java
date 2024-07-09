package com.javaassignment.myassignment.controller;

import com.javaassignment.myassignment.model.Book;
import com.javaassignment.myassignment.util.FileUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ManageInventoryController {
    @FXML
    private TableView<Book> inventoryTableView;
    @FXML
    private TableColumn<Book, String> isbnColumn;
    @FXML
    private TableColumn<Book, String> titleColumn;
    @FXML
    private TableColumn<Book, String> authorColumn;
    @FXML
    private TableColumn<Book, String> genreColumn;
    @FXML
    private TableColumn<Book, Double> priceColumn;
    @FXML
    private TableColumn<Book, Integer> quantityColumn;




    @FXML
    private void initialize() {
        ObservableList<Book> books = FileUtil.readBooksForInventory();
        isbnColumn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        inventoryTableView.setItems(books);
    }
    
}