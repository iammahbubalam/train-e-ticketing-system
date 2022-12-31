package com.mahbubalam.traineticketingsystem.server.controller;

import com.mahbubalam.traineticketingsystem.server.model.UserTransaction;
import com.mahbubalam.traineticketingsystem.server.provider.ConnectionProvider;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionController {
    public static ObservableList<UserTransaction> getUserTransactionHistory(int userId) throws SQLException, ClassNotFoundException {
        String quarry = "SELECT st1.station_name as from_st ,st2.station_name as to_st , ABS((st1.distance_from_start - st2.distance_from_start)) AS distance ,tr.ticket_count as count_tr ,tr.price as price_tr FROM \n" +
                "stations st1 JOIN transaction tr ON st1.station_id=tr.from_station_id\n" +
                "JOIN stations st2 on tr.to_station_id=st2.station_id\n" +
                "WHERE user_id="+userId+";";
        return getPersonObservableList(quarry);


    }
    private static ObservableList<UserTransaction> getPersonObservableList(String quarry) throws ClassNotFoundException, SQLException {
        String from;
        String to;
        float distance;
        int count;
        float price;
        ObservableList<UserTransaction> list = FXCollections.observableArrayList();
        Connection connection = ConnectionProvider.createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(quarry);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            from=resultSet.getString("from_St");
            to= resultSet.getString("to_st");
            distance = resultSet.getFloat("distance");
            count=resultSet.getInt("count_tr") ;
            price=resultSet.getFloat("price_tr");
            list.add(new UserTransaction(from,to,distance,count,price));

        }
        return list;
    }
}
