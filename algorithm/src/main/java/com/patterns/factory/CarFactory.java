package com.patterns.factory;
/**
 * Created by GD on 2018/4/20.
 *
 */

/**
 * @Description TODO
 * @Author GD
 * @Date 2018/4/20 23:27
 * @Version 1.0V
 */


public class CarFactory {

    public static Car getCar(String carBrand){
        if(carBrand == null){
            return null;
        }
        if ("BMW".equals(carBrand)){
            return new BMW();
        }
        if ("BENZ".equals(carBrand)){
            return new Benz();
        }
        if ("ROYCE".equals(carBrand)){
            return new Royce();
        }
        return null;
    }
}
