package com.calcoulus;

public class Food {
    private String foodName;
    private float caloriePerHundredGr;
    private float calorie;
    private int grams;

    // constructor for database table
    public Food (String foodName, float caloriePerHundredGr){
        this.foodName = foodName;
        this.caloriePerHundredGr = caloriePerHundredGr;
    }

    // constructor for food list in diet
    public Food (String foodName, int grams){
        this.foodName = foodName;
        this.grams = grams;
    }

    public String getFoodName() {
        return foodName;
    }
    public float getGrams(){
        return grams;
    }

    public float getCaloriePerHundredGr() {
        return caloriePerHundredGr;
    }
}