package com.mahbubalam.traineticketingsystem;

import com.jfoenix.controls.JFXButton;
import com.mahbubalam.traineticketingsystem.server.controller.BalanceController;
import com.mahbubalam.traineticketingsystem.server.controller.StationController;
import com.mahbubalam.traineticketingsystem.server.controller.UserController;
import com.mahbubalam.traineticketingsystem.server.provider.SendEmail;
import com.mahbubalam.traineticketingsystem.singletron.User;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.net.URL;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.ResourceBundle;

public class BuyTicketView  implements Initializable {
    public Text warning;
    public JFXButton saveButton1;
    public JFXButton saveButton;
    public TextField count;
    public TextField route;
    public ComboBox<String> stationComboBoxFrom;
    public ComboBox<String> stationComboBoxTo;
    public TextArea Details;

    int fromStationId;
    int toStationId;
    float fr, t,distance;
    String[] stations;
    String massage;
    float price,balance;
    com.mahbubalam.traineticketingsystem.server.entity.User user;

    public void onClick(MouseEvent mouseEvent) {
    }

    public void confirm(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (balance>=price){
            BalanceController.updateBalance(User.getInstance().getUserId(), balance-price);
                SendEmail.sendEmail(massage,User.getInstance().getUserEmail());
                warning.setText("Ticket Sent to your mail");
                count.setText("");
                route.setText("");


        }else {
            warning.setText("Not Enough Balance !");
        }
    }

    public void buy(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        user = UserController.getUserById(User.getInstance().getUserId());
        fr=StationController.getDistanceFromStart(fromStationId);
        t=StationController.getDistanceFromStart(toStationId);
        distance=Math.abs(fr-t);
         massage = "Name : "+ user.getFirstName()+ " "+user.getLastName()+"\n"
                +"Phone : "+ user.getPhoneNo()+"\n"
                +"NID : "+user.getNid()+"\n"
                +"Route : "+route.getText()+"\n"
                +"From : "+stationComboBoxFrom.getValue()+"\n"
                +"To : "+stationComboBoxTo.getValue()+"\n"
                +"Count : "+count.getText()+"\n"
                +"Distance : "+distance+"\n"
                +"Price : " + (distance*10)*Integer.parseInt(count.getText());
        Details.setText(massage);
        price=(distance*10)*Integer.parseInt(count.getText());
        balance= BalanceController.getBalance(User.getInstance().getUserId());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            System.out.println(User.getInstance().getRouteName());
            stations = StationController.getStationArray(User.getInstance().getRouteName());
            System.out.println(Arrays.toString(stations));
            stationComboBoxFrom.getItems().addAll(stations);
            stationComboBoxTo.getItems().addAll(stations);
            route.setText(User.getInstance().getRouteName());
            route.setEditable(false);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void onClickFrom(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        fromStationId=StationController.getStationId(stationComboBoxFrom.getValue());
        System.out.println(fromStationId);

    }

    public void onClickTo(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        toStationId=StationController.getStationId(stationComboBoxTo.getValue());
        System.out.println(toStationId);
    }
}

