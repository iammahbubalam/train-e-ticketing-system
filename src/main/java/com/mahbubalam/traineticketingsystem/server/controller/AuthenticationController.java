package com.mahbubalam.traineticketingsystem.server.controller;

import com.mahbubalam.traineticketingsystem.server.provider.ConnectionProvider;
import com.mahbubalam.traineticketingsystem.singletron.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthenticationController {
    public static boolean userAuthenticateWithPhoneNo(String phone, String password) throws ClassNotFoundException, SQLException {

        int userId = 0;
        String passwordFromDb = null;
        String phoneNoFromDb = null;
        String emailFromDb = null;
        Connection connection = ConnectionProvider.createConnection();
        String addressQuarry = "select user.user_id, user.email, user.phone_no, user.password from user where user.phone_no = " + phone + ";";
        PreparedStatement preparedStatement = connection.prepareStatement(addressQuarry);
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            userId = resultSet.getInt("user_id");
            phoneNoFromDb = resultSet.getString("phone_no");
            emailFromDb = resultSet.getString("email");
            passwordFromDb = resultSet.getString("password");
        }

        if (password.equals(passwordFromDb) && phone.equals(phoneNoFromDb)) {
            User.getInstance().setUserId(userId);
            User.getInstance().setUserPhoneNo(phoneNoFromDb);
            User.getInstance().setUserEmail(emailFromDb);
            return true;
        }
        return false;
    }

    public static boolean userAuthenticateWithEmail(String email, String password) throws ClassNotFoundException, SQLException {
        int userId = 0;
        String passwordFromDb = null;
        String phoneNoFromDb = null;
        String emailFromDb = null;
        Connection connection = ConnectionProvider.createConnection();
        String addressQuarry = "select user.user_id, user.email, user.phone_no, user.password from user where user.email = '" + email + "';";
        PreparedStatement preparedStatement = connection.prepareStatement(addressQuarry);
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            userId = resultSet.getInt("user_id");
            phoneNoFromDb = resultSet.getString("phone_no");
            emailFromDb = resultSet.getString("email");
            passwordFromDb = resultSet.getString("password");
        }


        if (password.equals(passwordFromDb) && email.equals(emailFromDb)) {

            User.getInstance().setUserId(userId);
            User.getInstance().setUserPhoneNo(phoneNoFromDb);
            User.getInstance().setUserEmail(emailFromDb);

            return true;
        }

        return false;
    }

    public static boolean adminAuthenticateWithEmail(String email, String password) throws ClassNotFoundException, SQLException {
        int userId = 0;
        String passwordFromDb = null;
        String phoneNoFromDb = null;
        String emailFromDb = null;
        Connection connection = ConnectionProvider.createConnection();
        String addressQuarry = "select user.user_id ,user.email, user.phone_no, user.password from user where email = '" + email + "';";
        PreparedStatement preparedStatement = connection.prepareStatement(addressQuarry);
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            userId = resultSet.getInt("user_id");
            phoneNoFromDb = resultSet.getString("phone_no");
            emailFromDb = resultSet.getString("email");
            passwordFromDb = resultSet.getString("password");
        }

        if (password.equals(passwordFromDb) && email.equals(emailFromDb)) {

            User.getInstance().setUserId(userId);
            User.getInstance().setUserPhoneNo(phoneNoFromDb);
            User.getInstance().setUserEmail(emailFromDb);

            return true;
        }

        return false;
    }




    public static boolean isAuthentic(String phone, String password) throws ClassNotFoundException, SQLException {
        String pas = null;
        String phoneNO = null;
        Connection connection = ConnectionProvider.createConnection();
        String addressQuarry = "select user.phone_no user.email  from user where  phone_no =" + phone + ";";
        PreparedStatement preparedStatement = connection.prepareStatement(addressQuarry);
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            phoneNO = resultSet.getString("phone_no");
            pas = resultSet.getString("password");
        }
        System.out.println(pas);
        System.out.println(phoneNO);


        return password.equals(pas) && phone.equals(phoneNO);
    }

    public static boolean changePassword(String phone, String password) throws ClassNotFoundException, SQLException {
        if (isExistPhone(phone)) {
            return PasswordController.updatePassword(phone, password);
        }
        return false;
    }

    public static boolean isExistPhone(String phone) throws ClassNotFoundException, SQLException {
        Connection connection = ConnectionProvider.createConnection();
        String personQuarry = "select user.phone_no from  user where phone_no = " + phone + ";";
        PreparedStatement preparedStatement = connection.prepareStatement(personQuarry);
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet.next();
    }

    public static boolean isExistEmail(String email) throws ClassNotFoundException, SQLException {
        Connection connection = ConnectionProvider.createConnection();
        String personQuarry = "select user.email from  user where email = '" + email + "';";
        PreparedStatement preparedStatement = connection.prepareStatement(personQuarry);
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet.next();
    }
}
