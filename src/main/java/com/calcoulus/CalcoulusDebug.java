// source of calorie reference https://www.uncledavesenterprise.com/file/health/Food%20Calories%20List.pdf
// source of daily calorie calculator https://wholelifestylenutrition.com/health/determine-daily-calorie-requirement-weight-loss/

package com.calcoulus;

import java.util.ArrayList;

public class CalcoulusDebug {
    public static void main(String[] args) {
        // Database Connection Initialization
        Postgres database = new Postgres();

        // Reloading food database into the ArrayList
        ArrayList<Food> foodDB = new ArrayList<>();
        database.reloadFoodDB(foodDB);

        //Account Authentication
        Authenticate auth = new Authenticate();
//        Account acc;
//        acc = auth.setLogin("ida", "aji", database);
//        acc = auth.setRegister("thoriq", "musyaffa", 52, database);
//        if (acc == null){
//            System.out.println("Register Failed!");
//        }
//        System.out.println(acc.getUsername());

        for (Food i : foodDB) {
            System.out.println(i.getFoodName() + "   " + i.getCaloriePerHundredGr());
        }
    }
}
