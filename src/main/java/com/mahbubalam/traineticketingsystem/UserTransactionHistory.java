package com.mahbubalam.traineticketingsystem;

import com.mahbubalam.traineticketingsystem.server.controller.TransactionController;
import com.mahbubalam.traineticketingsystem.server.model.UserTransaction;
import com.mahbubalam.traineticketingsystem.singletron.User;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UserTransactionHistory  implements Initializable {

    public TableColumn<UserTransaction,String> from;
    public TableColumn<UserTransaction,String> to;
    public TableColumn<UserTransaction, String> distance;
    public TableColumn<UserTransaction,String> ticketCount;
    public TableView<UserTransaction> tableView;
    public TableColumn<UserTransaction,String> price;
    ObservableList<UserTransaction> userObservableList;
    public void omMouseClick(MouseEvent mouseEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            userObservableList= TransactionController.getUserTransactionHistory(User.getInstance().getUserId());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        from.setCellValueFactory(new PropertyValueFactory<>("from"));
        to.setCellValueFactory(new PropertyValueFactory<>("to"));
        distance.setCellValueFactory(new PropertyValueFactory<>("distance"));
        ticketCount.setCellValueFactory(new PropertyValueFactory<>("count"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

        tableView.setItems(userObservableList);
    }

}
