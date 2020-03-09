package com.algorithm.patterns.factory.abstr;

/**
 * Created by GD on 2018/4/20.
 */

import com.algorithm.patterns.factory.BMW;
import com.algorithm.patterns.factory.Benz;
import com.algorithm.patterns.factory.Car;
import com.algorithm.patterns.factory.Royce;

/**
 * @Description TODO
 * @Author GD
 * @Date 2018/4/20 23:49
 * @Version 1.0V
 */

public class CarFactory extends AbstractFactory {

    public Driver getDriver(String driverEmp) {
        return null;
    }

    public Car getCar(String carBrand) {

        if (carBrand == null) {
            return null;
        }
        if ("BMW".equals(carBrand)) {
            return new BMW();
        }
        if ("BENZ".equals(carBrand)) {
            return new Benz();
        }
        if ("ROYCE".equals(carBrand)) {
            return new Royce();
        }
        return null;
    }
}
