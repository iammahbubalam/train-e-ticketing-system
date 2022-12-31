package com.mahbubalam.traineticketingsystem;


import com.mahbubalam.traineticketingsystem.server.controller.AddressController;
import com.mahbubalam.traineticketingsystem.server.controller.UserController;
import com.mahbubalam.traineticketingsystem.server.entity.Address;
import com.mahbubalam.traineticketingsystem.singletron.User;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {
    public Label address;
    public Label email;
    public Label mobileNum;
    public Label bloodGroup;
    public Label name;
    public Label gender;
    public Label dateOfBirth;
    public Label balance;
    public Label traveled;
    public Label nid;

    User user1 = User.getInstance();
    com.mahbubalam.traineticketingsystem.server.entity.User  user;
    Address personAddress=null;
    int distance;
    float totalBalance;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            user = UserController.getUserById(user1.getUserId());
            distance = UserController.getTotalDistanceTraveled(user1.getUserId());
            totalBalance = UserController.getBalance(user1.getUserId());
            if (AddressController.isExistAddress(user1.getUserId()))
                personAddress = AddressController.getAddressById(user1.getUserId());


        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        name.setText(user.getFirstName() + " " + user.getLastName());
        nid.setText(user.getNid());
        email.setText(user.getEmail());
        traveled.setText(distance+"");
        balance.setText(totalBalance+"");
        mobileNum.setText(user.getPhoneNo());
        if (personAddress!=null)
         address.setText( personAddress.getDivision() + ", " + personAddress.getDistrict() + ", " + personAddress.getThana() + ".");
        else address.setText("No address Found");


    }




}
