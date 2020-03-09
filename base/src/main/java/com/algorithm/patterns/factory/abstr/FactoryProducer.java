package com.algorithm.patterns.factory.abstr;

/**
 * Created by GD on 2018/4/20.
 */

/**
 *
 * @Description TODO
 * @Author GD
 * @Date 2018/4/20 23:57
 * @Version 1.0V
 */

public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("Driver")){
            return new DriverFactory();
        }else if(choice.equalsIgnoreCase("Car")){
            return new CarFactory();
        }
        return null;
    }
}

