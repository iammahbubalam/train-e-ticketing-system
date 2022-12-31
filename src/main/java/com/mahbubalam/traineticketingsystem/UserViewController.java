package com.mahbubalam.traineticketingsystem;

import com.jfoenix.controls.JFXButton;
import com.mahbubalam.traineticketingsystem.server.controller.RouteController;
import com.mahbubalam.traineticketingsystem.singletron.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class UserViewController implements Initializable {
    public JFXButton donateBloodButton;
    public JFXButton userProfileButton;
    public JFXButton requestBloodButton;
    public JFXButton logOutButton;
    public JFXButton changePasswordButton;
    public Label address;
    public Label warning;
    @FXML
    public ComboBox<String> routeComboBox = new ComboBox<>();
    @FXML
    private BorderPane borderPane;

    String[] route;

    public void onClickBuyTicket(ActionEvent actionEvent) throws IOException {

        if (routeComboBox.getValue()==null) warning.setText("Select a Route  ");
        else {
            User.getInstance().setRouteName(routeComboBox.getValue());
            AnchorPane anchorPane = FxmlLoader.getAnchorPane("buy-ticket-view.fxml");
            borderPane.setCenter(anchorPane);
        }

    }

    public void onClickUserProfileButton(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FxmlLoader.getAnchorPane("profile-view.fxml");
        borderPane.setCenter(anchorPane);
    }

    public void onClickHistory(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FxmlLoader.getAnchorPane("transaction-history-view.fxml");
        borderPane.setCenter(anchorPane);
    }

    public void onClickLogOutButton(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login-view.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("BD Rail e-Ticket");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void onClickUserChangePasswordButton(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FxmlLoader.getAnchorPane("change-password.fxml");
        borderPane.setCenter(anchorPane);
    }

    public void onClickEditProfile(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FxmlLoader.getAnchorPane("edit-profile-view.fxml");
        borderPane.setCenter(anchorPane);
    }


    public void onClickAddMoney(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FxmlLoader.getAnchorPane("add-money-view.fxml");
        borderPane.setCenter(anchorPane);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            route = RouteController.getRouteArray();
            routeComboBox.getItems().addAll(route);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
