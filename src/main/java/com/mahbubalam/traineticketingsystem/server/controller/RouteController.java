package com.mahbubalam.traineticketingsystem.server.controller;

import com.mahbubalam.traineticketingsystem.server.provider.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RouteController {
    public static ArrayList<String> getRoute() throws SQLException, ClassNotFoundException {
        ArrayList<String> routs = new ArrayList<>();
        
        String quarry = "SELECT  route.route_name FROM route ;";
        Connection connection = ConnectionProvider.createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(quarry);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            String a=resultSet.getString("route_name");
            routs.add(a);
        }
        
        return routs;
    }
    public static String[] getRouteArray() throws SQLException, ClassNotFoundException {
        ArrayList<String> routs = new ArrayList<>();

        String quarry = "SELECT  route.route_name FROM route ;";
        Connection connection = ConnectionProvider.createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(quarry);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            String a=resultSet.getString("route_name");
            routs.add(a);
        }

        
        String[] s = new String[routs.size()];
        for (int i = 0; i < routs.size(); i++) {
            s[i]=routs.get(i);
        }
        return s;
    }
    public static int getRouteId(String routeName) throws SQLException, ClassNotFoundException {

        int a = 0;
        String quarry = "SELECT  route.route_id FROM route where route_name ='"+routeName+"';";
        Connection connection = ConnectionProvider.createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(quarry);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
             a=resultSet.getInt("route_id");

        }
        return a;
        
    }
}

