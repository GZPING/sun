package com.patterns.builder;

/**
 * Created by GD on 2018/4/22.
 * Blog: https://blog.csdn.net/SaketGD
 */

/**
 * @Description TODO
 * @Author GD
 * @Date 2018/4/22 17:47
 * @Since 1.0V
 */

public class MealBuider {

    public Meal prepareVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}
