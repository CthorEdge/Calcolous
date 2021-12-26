package com.calcoulus;

import java.util.ArrayList;

public class Account {
    private String username;
    private String password;
    private int weight;
    private int calorieRequired;
    private int calorieGot;

    public Account (String username, String password, int weight, int calorieGot){
        this.username = username;
        this.password = password;
        this.weight = weight;
        this.calorieRequired = (int) (weight*2.2*14);
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
    public int getCalorieRequired() {
        return calorieRequired;
    }
    public int getCalorieGot() {
        return calorieGot;
    }

    public void setWeight (int weight){
        this.weight = weight;
    }
    public void setNewCalorieRequired (){
        this.calorieRequired = (int) (weight*2.2*14);
    }
    public void setNewCalorieGot (String foodName, int grams, ArrayList<Food> foodDB){
        if (thereIsFood(foodName, foodDB)){
            this.calorieGot = this.calorieGot + (getCaloriePerGr(foodName, foodDB))*grams;
        }
    }
    public void setCalorieGot (int calorieGot){
        this.calorieGot = calorieGot;
    }

    public boolean thereIsFood (String foodName, ArrayList<Food> foodDB){
        for (Food food : foodDB){
            if (food.getFoodName().equals(foodName)){
                return true;
            }
        }
        return false;
    }
    public int getCaloriePerGr (String foodName, ArrayList<Food> foodDB){
        for (Food food : foodDB){
            if (food.getFoodName().equals(foodName)){
                return (int) (food.getCaloriePerHundredGr())/100;
            }
        }
        return 0;
    }

}
