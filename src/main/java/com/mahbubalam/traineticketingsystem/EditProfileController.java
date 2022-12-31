package com.mahbubalam.traineticketingsystem;

import com.jfoenix.controls.JFXButton;
import com.mahbubalam.traineticketingsystem.server.controller.AddressController;
import com.mahbubalam.traineticketingsystem.server.entity.Address;
import com.mahbubalam.traineticketingsystem.singletron.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EditProfileController implements Initializable {

    public TextField thanaTextField;
    public JFXButton saveButton;
    @FXML
    private ComboBox<String> divisionComboBox = new ComboBox<>();
    @FXML
    private ComboBox<String> districtComboBox = new ComboBox<>();
    private final String[] divisionList = {"Dhaka", "Chattogram", "Rajshahi", "Sylhet", "Barisal", "Khulna", "Rangpur",
            "Mymensingh"};
    private final String[] districtList = {"Dhaka","Faridpur","Gazipur","Gopalganj","Jamalpur","Kishoreganj","Madaripur",
            "Manikganj","Munshiganj","Mymensingh","Narayanganj","Narsingdi","Netrokona","Rajbari","Shariatpur","Sherpur","Tangail","Bogra","Joypurhat","Naogaon","Natore","Nawabganj","Pabna","Rajshahi","Sirajgonj","Dinajpur","Gaibandha","Kurigram","Lalmonirhat","Nilphamari","Panchagarh","Rangpur","Thakurgaon","Barguna","Barisal","Bhola","Jhalokati","Patuakhali","Pirojpur","Bandarban","Brahmanbaria","Chandpur","Chittagong","Comilla","Cox''s Bazar","Feni","Khagrachari","Lakshmipur","Noakhali","Rangamati","Habiganj","Maulvibazar","Sunamganj","Sylhet","Bagerhat","Chuadanga","Jessore","Jhenaidah","Khulna","Kushtia","Magura","Meherpur","Narail","Satkhira"};


    public void initialize(URL arg0, ResourceBundle arg1) {
        divisionComboBox.getItems().addAll(divisionList);
        districtComboBox.getItems().addAll(districtList);

    }

    public void onClickSaveButton(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        AddressController.saveAddress(new Address(User.getInstance().getUserId(), divisionComboBox.getItems().toString(),districtComboBox.getItems().toString(),thanaTextField.getText()));
    }
}
