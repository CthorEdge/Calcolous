package com.calcoulus;

import java.sql.*;
import java.util.ArrayList;

public class Postgres {
    private Connection connection;

    public Postgres(){
        try {
            final String jdbcURL = "jdbc:postgresql://localhost:5432/calcoulus";
            final String username = "postgres";
            final String password = "";
            this.connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Successfully Connected to 'calcoulus' Database\n");
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection Failed on Postgres!");
        }
    }

    public void reloadFoodDB (ArrayList<Food> foodDB){
        String sql = "SELECT * FROM food";
        String foodName;
        float caloriePerHundredGr;
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                foodName = rs.getString("food_name");
                caloriePerHundredGr = rs.getFloat("calorie_per_hundred_gr");
                foodDB.add(new Food(foodName, caloriePerHundredGr));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection Failed on reloadFoodDB!");
        }
    }

    // Account Interaction with Database
    public boolean thereRegisteredAccount (String username){
        String sql = "SELECT * FROM account WHERE username = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection Failed on thereRegisteredAccount!");
        }
        return false;
    }
    public boolean checkLoginCredentials (String username, String password){
        String sql = "SELECT * FROM account WHERE username = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                if (rs.getString("username").equals(username) && rs.getString("password").equals(password)){
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection Failed on checkLoginCredentials!");
        }
        return false;
    }
    public void insertRegisteredAccount (String username, String password, int weight){
        String sql = "INSERT INTO account VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            st.setInt(3, weight);
            st.setDouble(4, 0.0);
            int row = st.executeUpdate();
            if (row>0){
                System.out.println("Account Created!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection Failed on insertRegisteredAccount!");
        }
    }
    public Account reloadRegisteredAccount (String username){
        String sql = "SELECT * FROM account WHERE username = ?";
        String loggedUsername;
        String password;
        int weight;
        int calorieGot;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                loggedUsername = rs.getString("username");
                password = rs.getString("password");
                weight = rs.getInt("weight");
                calorieGot = rs.getInt("calorie_got");

                return new Account(loggedUsername, password, weight, calorieGot);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection Failed on reloadRegisteredAccount!");
        }
        return null;
    }
    public void updateAccountWeight (int weightInput, String username){
        String sql = "UPDATE account SET weight = ? WHERE username = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, weightInput);
            st.setString(2, username);
            int row = st.executeUpdate();
            if (row > 0){
                System.out.println("Account Update Successful!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection Failed on updateAccountWeight!");
        }
    }

}
