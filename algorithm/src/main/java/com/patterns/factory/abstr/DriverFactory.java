package com.patterns.factory.abstr;
/*
 * Created by GD on 2018/4/20.
 *
 *
 *
 */

import com.patterns.factory.Car;

/**
 *
 * @Description TODO
 * @Author GD
 * @Date 2018/4/20 23:52
 * @Version 1.0V
 */

public class DriverFactory extends AbstractFactory {

    @Override
    public Driver getDriver(String driverEmp) {
        if(driverEmp == null){
            return null;
        }
        if ("TEXT".equals(driverEmp)){
            return new TextDriver();
        }
        if ("DIDI".equals(driverEmp)){
            return new DidiDriver();
        }
        return null;
    }

    @Override
    public Car getCar(String carBrand) {
        return null;
    }
}
