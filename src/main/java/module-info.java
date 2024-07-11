module com.javaassignment.myassignment {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.javaassignment.myassignment to javafx.fxml;
    opens com.javaassignment.myassignment.model to javafx.fxml;
    opens com.javaassignment.myassignment.controller to javafx.fxml;
    exports com.javaassignment.myassignment;
    exports com.javaassignment.myassignment.model;
}
