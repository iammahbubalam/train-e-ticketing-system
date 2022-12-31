package com.mahbubalam.traineticketingsystem.server.controller;

import com.mahbubalam.traineticketingsystem.server.provider.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BalanceController {
    public static float getBalance(int userId) throws SQLException, ClassNotFoundException {

        float a = 0;
        String quarry = "SELECT  deposite.balance FROM deposite where user_id ='"+userId+"';";
        Connection connection = ConnectionProvider.createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(quarry);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            a=resultSet.getInt("balance");

        }
        return a;

    }
    public static boolean updateBalance(int userId ,float newBalance) throws SQLException, ClassNotFoundException {


        String quarry = "update deposite set balance = "+newBalance+" where user_id="+userId+";";
        Connection connection = ConnectionProvider.createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(quarry);
        return preparedStatement.execute();
    }
    public static boolean setBalance(int userId ) throws SQLException, ClassNotFoundException {
        float a = 0;
        String quarry = "insert into deposite(user_id, balance) values("+userId+","+a+");";
        Connection connection = ConnectionProvider.createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(quarry);
        return preparedStatement.execute();
    }
}
