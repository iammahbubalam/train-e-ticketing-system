module com.mahbubalam.traineticketingsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;
    requires java.mail;
    requires com.jfoenix;


    opens com.mahbubalam.traineticketingsystem to javafx.fxml;
    exports com.mahbubalam.traineticketingsystem;
}