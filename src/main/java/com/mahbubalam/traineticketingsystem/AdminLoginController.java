package com.mahbubalam.traineticketingsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AdminLoginController {

    private Parent root;
    private Stage registerStage;

    private void nextPage(String name, ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(name)));
        registerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        registerStage.setScene(new Scene(root));
        registerStage.show();
    }

    public void onBackToLoginButtonClick(ActionEvent actionEvent) throws IOException {
        nextPage("login-view.fxml", actionEvent);
    }

    public void onLoginButtonClick(ActionEvent actionEvent) {
    }
}
