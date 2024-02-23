module com.example.proiectsqljava_vapoare {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires com.oracle.database.jdbc;

    opens Controllers;
    opens com.example.proiectsqljava_vapoare to javafx.fxml;
    exports com.example.proiectsqljava_vapoare;
}