module com.mahbubalam.traineticketingsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;
    requires java.mail;
    requires com.jfoenix;
    requires org.controlsfx.controls;
    requires javafx.base;


    opens com.mahbubalam.traineticketingsystem.server.model to javafx.base;
    opens com.mahbubalam.traineticketingsystem.server.entity to javafx.base;
    opens com.mahbubalam.traineticketingsystem to javafx.fxml;
    exports com.mahbubalam.traineticketingsystem;


}