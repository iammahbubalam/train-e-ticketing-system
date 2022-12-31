package com.mahbubalam.traineticketingsystem.server.controller;

import com.mahbubalam.traineticketingsystem.server.entity.Address;
import com.mahbubalam.traineticketingsystem.server.provider.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressController {

    public static Address getAddressById(int userID) throws SQLException, ClassNotFoundException {
        String quarry = "select * FROM address  WHERE user_id = '"+userID+"';";
        String district ;
        String division;
        String thana;
        Address address = null;
        Connection connection = ConnectionProvider.createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(quarry);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            district=resultSet.getString("district");
            division = resultSet.getString("division");
            thana = resultSet.getString("thana");
            address=new Address(division,district,thana);
        }
        return address;

    }
    public static void saveAddress(Address address) throws SQLException, ClassNotFoundException {
        String quarry = "insert  into  address(user_id, district, divison, thana )   values('" + address.getUserId() + "','" + address.getDistrict() + "','" + address.getDivision() + "','" + address.getThana() +"');";
        Connection connection = ConnectionProvider.createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(quarry);
        preparedStatement.executeQuery();
    }
    public static boolean isExistAddress(int userID) throws ClassNotFoundException, SQLException {
        Connection connection = ConnectionProvider.createConnection();
        String personQuarry = "select address.user_id from  address where user_id = '" + userID + "';";
        PreparedStatement preparedStatement = connection.prepareStatement(personQuarry);
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet.next();
    }
}
