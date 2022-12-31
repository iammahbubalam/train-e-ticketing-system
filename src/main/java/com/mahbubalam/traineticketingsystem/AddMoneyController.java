package com.mahbubalam.traineticketingsystem;

import com.jfoenix.controls.JFXButton;
import com.mahbubalam.traineticketingsystem.server.controller.BalanceController;
import com.mahbubalam.traineticketingsystem.server.controller.PasswordController;
import com.mahbubalam.traineticketingsystem.singletron.User;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.SQLException;

public class AddMoneyController {
    public JFXButton saveButton;
    public Text warning;
    public PasswordField passwordInputField;
    public TextField amountFild;

    public void confirm(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (passwordInputField.getText().isEmpty()||amountFild.getText().isEmpty())warning.setText("Enter Password Or Amount");
        else{
            if (PasswordController.getPassword(User.getInstance().getUserId()).equals(passwordInputField.getText())){
                BalanceController.updateBalance(User.getInstance().getUserId(), Float.parseFloat(amountFild.getText()));
                warning.setText("Balance Updated");
            }else warning.setText("Wrong Password");
        }
    }
}
