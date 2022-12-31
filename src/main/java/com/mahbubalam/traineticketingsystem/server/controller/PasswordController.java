package com.mahbubalam.traineticketingsystem.server.controller;

import com.mahbubalam.traineticketingsystem.server.provider.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PasswordController {
    public static boolean updatePassword(String mail, String password) throws SQLException, ClassNotFoundException {

        Connection connection = null;
        try {
            connection = ConnectionProvider.createConnection();
            String addressQuarry = "update user set user.password = '"+ password+"' where email = '"+ mail+"'";
            PreparedStatement preparedStatement = connection.prepareStatement(addressQuarry);
            preparedStatement.execute();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
    public static String getPassword(int id) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionProvider.createConnection();
            String addressQuarry = "select password from user where user_id="+id+"";
            PreparedStatement preparedStatement = connection.prepareStatement(addressQuarry);
            ResultSet resultSet = preparedStatement.executeQuery();
            String pass = null;
            while (resultSet.next()){
                pass=resultSet.getString("password");
            }
        return pass;
    }
    public static boolean updatePassword(int userID, String password)  {
        Connection connection = null;
        try {
            connection = ConnectionProvider.createConnection();
            String addressQuarry = "update user set user.password = '"+ password+"' where user_id = "+ userID+"";
            PreparedStatement preparedStatement = connection.prepareStatement(addressQuarry);
            preparedStatement.execute();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
