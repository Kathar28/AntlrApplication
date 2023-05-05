module com.antlrapplication {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires antlr;

    opens com to javafx.fxml;
    exports com;
    exports com.model;
    exports com.controller;
    opens com.model to javafx.fxml;
    exports com.view;
    opens com.view to javafx.fxml;
}