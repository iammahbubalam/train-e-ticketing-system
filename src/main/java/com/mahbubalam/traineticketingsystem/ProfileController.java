package com.mahbubalam.traineticketingsystem;


import com.mahbubalam.traineticketingsystem.server.controller.UserController;
import com.mahbubalam.traineticketingsystem.server.entity.Address;
import com.mahbubalam.traineticketingsystem.singletron.User;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Date;
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
    Address personAddress;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            user = UserController.getUserById(user1.getUserId());

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        name.setText(user.getFirstName() + " " + user.getLastName());
        nid.setText(user.getNid());
        email.setText(user.getEmail());
        mobileNum.setText(user.getPhoneNo());


    }

    public void onAddressClick(ActionEvent event) {
        try {
            personAddress = AddressController.getAddressById(person.getAddressId());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        address.setText(personAddress.getCountry() + ", " + personAddress.getDivision() + ", " + personAddress.getDistrict() + ", " + personAddress.getSubDistrict() + ".");

    }

    public void donationData(ActionEvent event) throws SQLException, ClassNotFoundException {
        hospitalColumn.setCellValueFactory(new PropertyValueFactory<>("hospitalName"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("donationDate"));
        donationObservableList=DonationController.getDonatedDonationById(User.getInstance().getUserId());
        table.setItems(donationObservableList);
    }

    public void receivedData(ActionEvent event) throws SQLException, ClassNotFoundException {
        hospitalColumn.setCellValueFactory(new PropertyValueFactory<>("hospitalName"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("donationDate"));
        donationObservableList=DonationController.getReceivedDonationById(User.getInstance().getUserId());
        table.setItems(donationObservableList);

    }
}
