package com.calcoulus;

import java.util.ArrayList;

public class Diet {
    ArrayList<Food> foodDiet = new ArrayList<>();

    public boolean thereIsFood (String foodName, ArrayList<Food> foodDB){
        for (Food food : foodDB){
            if (food.getFoodName().equals(foodName)){
                return true;
            }
        }
        return false;
    }
    public double getCaloriePerGr (String foodName, ArrayList<Food> foodDB){
        for (Food food : foodDB){
            if (food.getFoodName().equals(foodName)){
                return food.getCaloriePerHundredGr()/100;
            }
        }
        return 0.0;
    }
    public void addFood (String foodName, int grams, ArrayList<Food> foodDB){
        if (thereIsFood(foodName, foodDB)){
            foodDiet.add(new Food(foodName, grams));
        }
    }
    public double countTotalCalorie (ArrayList<Food> foodDB){
        double totalCalorie = 0;
        for (Food food : foodDiet){
            if (thereIsFood(food.getFoodName(), foodDB)){
                totalCalorie += getCaloriePerGr(food.getFoodName(), foodDB)*food.getGrams();
            }
        }
        return totalCalorie;
    }
}
