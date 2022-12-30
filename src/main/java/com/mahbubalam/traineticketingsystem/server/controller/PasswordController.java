package com.mahbubalam.traineticketingsystem.server.controller;

import com.mahbubalam.traineticketingsystem.server.provider.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PasswordController {
    public static boolean updatePassword(String mail, String password)  {
        Connection connection = null;
        try {
            connection = ConnectionProvider.createConnection();
            String addressQuarry = "update user set user.password = "+ password+" where email = '"+ mail+"'";
            PreparedStatement preparedStatement = connection.prepareStatement(addressQuarry);
            preparedStatement.execute();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
