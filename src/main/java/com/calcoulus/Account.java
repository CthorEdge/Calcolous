package com.calcoulus;

public class Account {
    private String username;
    private String password;
    private int weight;
    private double calorieRequired;
    private double calorieGot;

    public Account (String username, String password, int weight, double calorieGot){
        this.username = username;
        this.password = password;
        this.weight = weight;
        this.calorieRequired = weight*2.2*14;
        this.calorieGot = calorieGot;
    }

    public void addCalorieGot (double calorieGot){
        this.calorieGot += calorieGot;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return password;
    }
    public int getWeight() {
        return weight;
    }
    public double getCalorieRequired() {
        return calorieRequired;
    }
    public double getCalorieGot() {
        return calorieGot;
    }
}
