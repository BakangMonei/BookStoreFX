package com.javaassignment.myassignment.controller;

import com.javaassignment.myassignment.model.*;
import com.javaassignment.myassignment.util.*;
import javafx.fxml.*;
import javafx.scene.control.*;

public class ManageInventoryController {
    @FXML
    public TableView<Book> inventoryTableView;
    @FXML
    public TableColumn<Book, String> isbnColumn;
    @FXML
    public TableColumn<Book, String> titleColumn;
    @FXML
    public TableColumn<Book, String> authorColumn;
    @FXML
    public TableColumn<Book, String> genreColumn;
    @FXML
    public TableColumn<Book, Double> priceColumn;
    @FXML
    public TableColumn<Book, Integer> quantityColumn;

    @FXML
    public void initialize() {
        FileUtil.readToTable(inventoryTableView);
    }
}
