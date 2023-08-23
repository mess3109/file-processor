module com.example.fileprocessor {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires com.opencsv;
    requires java.sql;


    opens com.example.fileprocessor.models to com.google.gson, com.opencsv;
    opens com.example.fileprocessor to com.google.gson, com.opencsv;
    exports com.example.fileprocessor;
}
