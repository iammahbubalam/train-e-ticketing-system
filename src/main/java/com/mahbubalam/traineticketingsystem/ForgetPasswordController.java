package com.mahbubalam.traineticketingsystem;

import com.mahbubalam.traineticketingsystem.server.controller.AuthenticationController;
import com.mahbubalam.traineticketingsystem.server.controller.PasswordController;
import com.mahbubalam.traineticketingsystem.server.controller.UserController;
import com.mahbubalam.traineticketingsystem.server.provider.SendEmail;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;

public class ForgetPasswordController implements Initializable {
    public TextField emailOrPhoneInputField;
    public TextField verificationCodeInputField;
    public Text warning;
    public TextField newPassWordField;
    public Text warning1;
    public TextField confirmPasswordField;
    public boolean isExist;
    private int code;
    String mail;

    public void onLoginButtonClick(ActionEvent event) throws IOException {
        nextPage("login-view.fxml", event);
    }

    public void onClickChangePassword(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        String np = newPassWordField.getText();
        String cp = confirmPasswordField.getText();
        if (np.equals(cp)) {
            PasswordController.updatePassword(mail,np);
            warning1.setText("Password Changed");
            nextPage("login-view.fxml", event);

        } else warning1.setText("Passwords are not same. Please try again!");

    }

    private void nextPage(String name, ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(name)));
        Stage loginStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        loginStage.setScene(new Scene(root));
        loginStage.show();
    }

    public void onVerifyButtonClick(ActionEvent event) {
        int inputCode = Integer.parseInt(verificationCodeInputField.getText());
        if (inputCode == code) {
            confirmPasswordField.setEditable(true);
            newPassWordField.setEditable(true);
            verificationCodeInputField.setEditable(false);
            emailOrPhoneInputField.setEditable(false);
            warning.setText("You are verified! \n Please update your password!");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        verificationCodeInputField.setEditable(false);
        confirmPasswordField.setEditable(false);
        newPassWordField.setEditable(false);

    }

    public void onSendCodeClick(ActionEvent event) {
        String emailOrPhone = emailOrPhoneInputField.getText();
        if (Objects.equals(emailOrPhone, "")) {
            warning.setText("Input a valid Phone Number or Email");
        } else {
            if (emailOrPhone.contains(".com")) {
                try {
                    isExist = AuthenticationController.isExistEmail(emailOrPhone);
                    if (!isExist) warning.setText("No user found with this email");
                    else {
                        mail=emailOrPhone;
                        sendVerificationCode(emailOrPhone);
                    }
                } catch (ClassNotFoundException | SQLException e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {

                    isExist = AuthenticationController.isExistPhone(emailOrPhone);
                    if (!isExist) warning.setText("No user found with this phone");
                    else{
                        mail = UserController.getEmailByPhoneNo(emailOrPhone);
                        sendVerificationCode(mail) ;
                    }
                } catch (ClassNotFoundException | SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            verificationCodeInputField.setEditable(true);

        }
    }

    private void sendVerificationCode(String emailOrPhone) {
        Random random = new Random();
        code = random.nextInt(999999);
        SendEmail.sendEmail(String.valueOf(code), emailOrPhone);
        warning.setText("Verification code sent! \n Please check your email!");
    }

    public void onKeyPressEmailInputField(KeyEvent keyEvent) {
        warning.setText("");
        warning1.setText("");
    }
}
