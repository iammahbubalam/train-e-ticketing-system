package com.mahbubalam.traineticketingsystem;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class UserViewController {
    public JFXButton donateBloodButton;
    public JFXButton userProfileButton;
    public JFXButton requestBloodButton;
    public JFXButton logOutButton;
    public JFXButton changePasswordButton;
    @FXML
    private BorderPane borderPane;

    public void onClickBuyTicket(ActionEvent actionEvent) {
    }

    public void onClickUserProfileButton(ActionEvent actionEvent) {
    }

    public void onClickHistory(ActionEvent actionEvent) {
    }

    public void onClickLogOutButton(ActionEvent actionEvent) {
    }

    public void onClickUserChangePasswordButton(ActionEvent actionEvent) {
    }

    public void onClickEditProfile(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FxmlLoader.getAnchorPane("edit-profile-view.fxml");
        borderPane.setCenter(anchorPane);
    }


    public void onClickAddMoney(ActionEvent actionEvent) {
    }

    public void onAddressClick(ActionEvent actionEvent) {
    }
}
