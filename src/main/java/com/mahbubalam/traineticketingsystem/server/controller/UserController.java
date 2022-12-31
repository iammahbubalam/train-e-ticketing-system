package com.mahbubalam.traineticketingsystem.server.controller;


import com.mahbubalam.traineticketingsystem.server.entity.User;
import com.mahbubalam.traineticketingsystem.server.provider.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class UserController {

    public static void saveUser(User user) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionProvider.createConnection();
        String insert = "insert  into  user(first_name, last_name, email, phone_no ,nid,password)   values('" + user.getFirstName() + "','" + user.getLastName() + "','" + user.getEmail() + "','" + user.getPhoneNo() + "','" + user.getNid() + "','" + user.getPassword() + "');";
        PreparedStatement preparedStatement = connection.prepareStatement(insert);
        preparedStatement.execute();
    }



    public static String getEmailByPhoneNo(String phoneNo) throws SQLException, ClassNotFoundException {
        String quarry = "SELECT  email FROM user WHERE phone_no='" + phoneNo + "';";
        String email = "";
        Connection connection = ConnectionProvider.createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(quarry);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            email = resultSet.getString("email");
        }
        return email;

    }

    public static String random() {

        int number = new Random().nextInt(900000) + 100000;

        // this will convert any number sequence into 6 character.
        return String.format("%06d", number);

    }

    public static User getUserById(int id) throws SQLException, ClassNotFoundException {

        String quarry = "SELECT  * FROM user WHERE user_id="+id+";";
        return getUser(quarry);
    }

    private static User getUser(String quarry) throws SQLException, ClassNotFoundException {
        int id;
        String firstName;
        String lastName;
        String phoneNumber;
        String email;
        String nid;
        User user = null;
        Connection connection = ConnectionProvider.createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(quarry);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            id=resultSet.getInt("user_id");
            email = resultSet.getString("email");
            firstName=resultSet.getString("first_name");
            lastName=resultSet.getString("last_name");
            phoneNumber=resultSet.getString("phone_no");
            nid=resultSet.getString("nid");
            user= new User(firstName,lastName,email,phoneNumber,nid);


        }
        return user ;

    }
    public static float getBalance(int userId) throws SQLException, ClassNotFoundException {
        float balance = 0;
        String query ="select balance FROM deposite  WHERE user_id = "+ userId+";";
        Connection connection = ConnectionProvider.createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            balance=resultSet.getInt("balance");
        }
        return balance;
    }

    public static int getTotalDistanceTraveled(int id) throws SQLException, ClassNotFoundException {
        int distance = 0;
        String query ="SELECT  SUM(ABS((st1.distance_from_start - st2.distance_from_start))) AS total_distance FROM stations st1 JOIN transaction tr ON st1.station_id=tr.from_station_id JOIN stations st2 on tr.to_station_id=st2.station_id WHERE tr.user_id="+id+";";
        Connection connection = ConnectionProvider.createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            distance=resultSet.getInt("total_distance");
        }
        return distance;
    }

    public static int getUserId(String email) throws SQLException, ClassNotFoundException {
        int id=0;
        String quarry = "SELECT  user_id FROM user WHERE user.email='" + email + "';";

        Connection connection = ConnectionProvider.createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(quarry);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            id = resultSet.getInt("user_id");
        }
        return id;

    }
}

