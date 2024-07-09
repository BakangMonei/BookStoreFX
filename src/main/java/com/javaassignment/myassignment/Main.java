package com.javaassignment.myassignment;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            URL fxmlLocation = getClass().getResource("/com/javaassignment/myassignment/view/BookstoreManagementSystem.fxml");
            if (fxmlLocation == null) {
                throw new IllegalStateException("Cannot find FXML file");
            }
            FXMLLoader loader = new FXMLLoader(fxmlLocation);
            Scene scene = new Scene(loader.load());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Bookstore Management System");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
