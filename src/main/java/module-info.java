module com.antlrapplication {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires antlr;
    requires junit;

    opens com to javafx.fxml;
    exports com;
}