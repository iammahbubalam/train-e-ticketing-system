package com.mahbubalam.traineticketingsystem;

import com.mahbubalam.traineticketingsystem.server.controller.UserController;
import com.mahbubalam.traineticketingsystem.server.entity.User;
import com.mahbubalam.traineticketingsystem.server.provider.SendEmail;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Random;
import java.util.regex.Pattern;

public class RegisterMenuController {
    final String emailRegex = "^(.+)@(.+)$";
    final String phoneRegex = "^01[13-9]\\d{8}$";
    private final String[] divisionList = {"Dhaka", "Chattogram", "Rajshahi", "Sylhet", "Barisal", "Khulna", "Rangpur",
            "Mymensingh"};
    private final String[] districtList = {"Dhaka", "Faridpur", "Gazipur", "Gopalganj", "Jamalpur", "Kishoreganj", "Madaripur",
            "Manikganj", "Munshiganj", "Mymensingh", "Narayanganj", "Narsingdi", "Netrokona", "Rajbari", "Shariatpur", "Sherpur", "Tangail", "Bogra", "Joypurhat", "Naogaon", "Natore", "Nawabganj", "Pabna", "Rajshahi", "Sirajgonj", "Dinajpur", "Gaibandha", "Kurigram", "Lalmonirhat", "Nilphamari", "Panchagarh", "Rangpur", "Thakurgaon", "Barguna", "Barisal", "Bhola", "Jhalokati", "Patuakhali", "Pirojpur", "Bandarban", "Brahmanbaria", "Chandpur", "Chittagong", "Comilla", "Cox''s Bazar", "Feni", "Khagrachari", "Lakshmipur", "Noakhali", "Rangamati", "Habiganj", "Maulvibazar", "Sunamganj", "Sylhet", "Bagerhat", "Chuadanga", "Jessore", "Jhenaidah", "Khulna", "Kushtia", "Magura", "Meherpur", "Narail", "Satkhira"};
    //    private final Person p = Person.getInstanceOfModelPerson();
    public Text firstNameWarning;
    public Text lastNameWarning;
    public Text emailWarning;
    public Text mobileWarning;
    public Text passwordWarning;
    public Text addressWarning;
    public PasswordField confirmPasswordField;
    public Text confirmPasswordWarning;
    public TextField nidTextField;
    public Text nidWarning;
    public Text showWarning;
    public PasswordField verificationText;
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private Parent root;
    @FXML
    private Stage registerStage;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField mobileNumTextField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private ComboBox<String> divisionComboBox = new ComboBox<>();
    @FXML
    private ComboBox<String> districtComboBox = new ComboBox<>();
    @FXML
    private Button registerButton;
    private User user;
    int random ;
    String message ;



//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        divisionComboBox.getItems().addAll(divisionList);
//        districtComboBox.getItems().addAll(districtList);
//    }

    private void nextPage(String name, ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(name)));
        registerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        registerStage.setScene(new Scene(root));
        registerStage.show();
    }

    private boolean fieldCheck() {
        if (firstNameTextField.getText().isBlank()) {
            firstNameWarning.setText("first name can't be empty");
            return false;
        }
        if (lastNameTextField.getText().isBlank()) {
            lastNameWarning.setText("last name can't be empty");
            return false;
        }
        if (emailTextField.getText().isBlank()) {
            emailWarning.setText("email required");
            return false;
        }
        if (mobileNumTextField.getText().isBlank()) {
            mobileWarning.setText("mobile no required");
            return false;
        }
        if (passwordField.getText().isEmpty()) {
            passwordWarning.setText("password required");
            return false;
        }
        if (nidTextField.getText().isEmpty()) {
            nidWarning.setText("nid required");
            return false;
        }
        if (confirmPasswordField.getText().isEmpty()) {
            confirmPasswordField.setText("you have to confirm your password");
            return false;
        }
//        if (divisionComboBox.getValue()==null){
//            addressWarning.setText("division required");
//            return false;
//        } else if (districtComboBox.getValue()==null){
//            addressWarning.setText("district required");
//            return false;
//        } else if (thanaTextField.getText().isBlank()) {
//            addressWarning.setText("thana required");
//            return false;
//        }
        if (!checkIsValidEmail()) {
            emailWarning.setText("invalid email");
            return false;
        }
        if (!confirmPassword()) {
            confirmPasswordWarning.setText("Password did not matched");
            return false;
        }
        if (!checkIsValidPhone()) {
            mobileNumTextField.setText("invalid phone no");
            return false;
        }
        return true;
    }

    private boolean confirmPassword() {
        return passwordField.getText().equals(confirmPasswordField.getText());
    }


    private void takingInput() {
        user = new User(firstNameTextField.getText(), lastNameTextField.getText(), emailTextField.getText(), mobileNumTextField.getText(), nidTextField.getText(), passwordField.getText());
    }

    @FXML
    public void onClickRegisterButton(ActionEvent event) {

        if (fieldCheck()) {
            takingInput();
            try {
                UserController.saveUser(user);
                com.mahbubalam.traineticketingsystem.singletron.User.getInstance().setUserEmail(user.getEmail());
                nextPage("login-view.fxml", event);
            } catch (SQLException | ClassNotFoundException | IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public void onKeyReleasedFirstNameTextField(KeyEvent keyEvent) {
        firstNameWarning.setText("");
    }

    public void onKeyReleasedLastNameTextField(KeyEvent keyEvent) {
        lastNameWarning.setText("");
    }

    public void onKeyReleaseEmailInputValidation(KeyEvent keyEvent) {

        if (!checkIsValidEmail()) {
            emailWarning.setText("invalid Email");
        } else emailWarning.setText("");
    }

    public void onKeyReleaseMobileTextField(KeyEvent keyEvent) {
        if (!checkIsValidPhone()) {
            mobileWarning.setText("invalid Phone No");
        } else mobileWarning.setText("");

    }


    private boolean checkIsValidEmail() {
        return Pattern.compile(emailRegex).matcher(emailTextField.getText()).matches();
    }

    private boolean checkIsValidPhone() {
        return Pattern.compile(phoneRegex).matcher(mobileNumTextField.getText()).matches();
    }

//    public void onClickDivision(ActionEvent event) {
//        addressWarning.setText("");
//
//    }
//
//    public void onClickDistrict(ActionEvent event) {
//        addressWarning.setText("");
//    }
//
//    public void onClickThana(ActionEvent event) {
//        addressWarning.setText("");
//    }

    public void onLoginButtonClick(ActionEvent event) throws IOException {

        nextPage("login-view.fxml", event);
    }

//    public void onClickResendCodeButton(ActionEvent actionEvent) {
//        sendEmail(com.mahbubalam.traineticketingsystem.singletron.User.getInstance().getUserEmail());
//        showWarning.setText("Code Sent");
//    }
//
//    public void onclickVerifyButton(ActionEvent actionEvent) {
//        System.out.println(1);
//        if (Integer.valueOf(verificationText.getText())==random){
//            System.out.println(2);
//            showWarning.setText("You are verified , Please log-in to your account");
//            System.out.println(4);
//            try {
//                System.out.println(3);
//                UserController.activeUser(com.mahbubalam.traineticketingsystem.singletron.User.getInstance().getUserEmail());
//                System.out.println(4);
//                nextPage("login-view.fxml", actionEvent);
//
//            } catch (IOException | ClassNotFoundException | SQLException e) {
//
//            }
//        }
//    }
    private void sendEmail(String email){
        this.random= new Random().nextInt(900000) ;
        this.message = " <h2>your verification code is</h2><br/><h1><b>"+"    "+random+"</b></h1> ";
        SendEmail.sendEmail(message, email);
    }
}
