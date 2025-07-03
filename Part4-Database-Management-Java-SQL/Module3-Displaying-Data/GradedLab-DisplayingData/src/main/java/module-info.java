module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires transitive javafx.base;
    opens com.example to javafx.fxml;
    exports com.example;
}
