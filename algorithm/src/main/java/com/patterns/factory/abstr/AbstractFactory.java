package com.patterns.factory.abstr;

/**
 * Created by GD on 2018/4/20.
 */

import com.patterns.factory.Car;

/**
 *
 * @Description TODO
 * @Author GD
 * @Date 2018/4/20 23:47
 * @Version 1.0V
 */

public abstract class AbstractFactory {

    public abstract Driver getDriver(String driverEmp);
    protected abstract Car getCar(String carBrand);

}
