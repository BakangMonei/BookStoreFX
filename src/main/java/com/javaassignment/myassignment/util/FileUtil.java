package com.javaassignment.myassignment.util;

import com.javaassignment.myassignment.model.*;
import javafx.collections.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.*;
import java.util.*;

public class FileUtil {
    public static final String BOOKS_FILE = "data/books.txt";
    public static final String CUSTOMERS_FILE = "data/customers.txt";
    public static final String SALES_FILE = "data/sales.txt";
    private static final String SALES_CUSTOMERS_FILE = "data/SalesCustomers.txt";

    // -----------------------------------------------------------------------------------------------------------------
    public static List<Book> readBooks() {
        List<Book> books = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(BOOKS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                books.add(new Book(parts[0], parts[1], parts[2], parts[3], Double.parseDouble(parts[4]), Integer.parseInt(parts[5])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }


    public static ObservableList<Book> readBooksForInventory() {
        ObservableList<Book> books = FXCollections.observableArrayList();
        try (BufferedReader reader = new BufferedReader(new FileReader(BOOKS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Book book = new Book(parts[0], parts[1], parts[2], parts[3], Double.parseDouble(parts[4]), Integer.parseInt(parts[5]));
                books.add(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

    public static void readToTable(TableView<Book> tableView) {
        ObservableList<Book> books = FXCollections.observableArrayList();
        try (BufferedReader reader = new BufferedReader(new FileReader(BOOKS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Book book = new Book(parts[0], parts[1], parts[2], parts[3], Double.parseDouble(parts[4]), Integer.parseInt(parts[5]));
                books.add(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Ensure the table columns are set correctly
        for (TableColumn<Book, ?> column : tableView.getColumns()) {
            String columnName = column.getText();
            switch (columnName) {
                case "ISBN":
                    column.setCellValueFactory(new PropertyValueFactory<>("isbn"));
                    break;
                case "Title":
                    column.setCellValueFactory(new PropertyValueFactory<>("title"));
                    break;
                case "Author":
                    column.setCellValueFactory(new PropertyValueFactory<>("author"));
                    break;
                case "Genre":
                    column.setCellValueFactory(new PropertyValueFactory<>("genre"));
                    break;
                case "Price":
                    column.setCellValueFactory(new PropertyValueFactory<>("price"));
                    break;
                case "Quantity":
                    column.setCellValueFactory(new PropertyValueFactory<>("quantity"));
                    break;
            }
        }

        tableView.setItems(books);
    }

    public static void writeBooks(List<Book> books) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOKS_FILE))) {
            for (Book book : books) {
                writer.write(book.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // -----------------------------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------
    public static List<Customer> readCustomers() {
        List<Customer> customers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CUSTOMERS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                customers.add(new Customer(parts[0], parts[1], parts[2], parts[3], parts[4]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public static void writeCustomers(List<Customer> customers) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CUSTOMERS_FILE))) {
            for (Customer customer : customers) {
                writer.write(customer.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // -----------------------------------------------------------------------------------------------------------------


    // -----------------------------------------------------------------------------------------------------------------
    public static List<Sale> readSales() {
        List<Sale> sales = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(SALES_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                sales.add(new Sale(parts[0], parts[1], Integer.parseInt(parts[2]), Double.parseDouble(parts[3])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sales;
    }

    public static void writeSales(List<Sale> sales) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SALES_FILE))) {
            for (Sale sale : sales) {
                writer.write(sale.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // -----------------------------------------------------------------------------------------------------------------

    public static void writeSalesCustomers(List<Sale> sales, List<Customer> customers) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(SALES_CUSTOMERS_FILE))) {
            for (Sale sale : sales) {
                for (Customer customer : customers) {
                    for (Sale customerSale : customer.getPurchaseHistory()) {
                        if (customerSale.getSaleId().equals(sale.getSaleId())) {
                            bw.write(sale.toString() + "," + customer.toString());
                            bw.newLine();
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<SaleCustomer> readSalesCustomers() {
        List<SaleCustomer> saleCustomers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(SALES_CUSTOMERS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                SaleCustomer saleCustomer = new SaleCustomer(parts[0], parts[1], Integer.parseInt(parts[2]), Double.parseDouble(parts[3]), LocalDateTime.parse(parts[4]), parts[5], parts[6], parts[7], parts[8], parts[9]);
                saleCustomers.add(saleCustomer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return saleCustomers;
    }
}
