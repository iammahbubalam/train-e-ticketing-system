package com.mahbubalam.traineticketingsystem.server.controller;

import com.mahbubalam.traineticketingsystem.server.provider.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StationController {
    public static ArrayList<String> getStations(String routeName) throws SQLException, ClassNotFoundException {
        ArrayList<String> stations = new ArrayList<>();

        String quarry = "SELECT station_name FROM stations JOIN route ON stations.route_id=route.route_id WHERE route.route_name='"+routeName+"';";
        Connection connection = ConnectionProvider.createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(quarry);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            String a=resultSet.getString("station_name");
            stations.add(a);
        }

        return stations;
    }
    public static String[] getStationArray(String routeName) throws SQLException, ClassNotFoundException {
        ArrayList<String> stations = getStations(routeName);

        String[] s = new String[stations.size()];
        for (int i = 0; i < stations.size(); i++) {
            s[i]=stations.get(i);
        }
        return s;
    }
    public static int getStationId(String stationName) throws SQLException, ClassNotFoundException {

        int a = 0;

        String quarry = "SELECT station_id   FROM stations where  station_name='"+stationName+"';";
        Connection connection = ConnectionProvider.createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(quarry);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            a=resultSet.getInt("station_id");

        }
        return   a;

    }
    public static float getDistanceFromStart(int stationId) throws SQLException, ClassNotFoundException {

        float a = 0;

        String quarry = "SELECT distance_from_start   FROM stations where  station_id='"+stationId+"';";
        Connection connection = ConnectionProvider.createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(quarry);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            a=resultSet.getInt("distance_from_start");

        }
        return   a;

    }
}
