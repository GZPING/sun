package com.algorithm.patterns.observer;

/**
 * Created by GD on 2018/5/9.
 * Blog: https://blog.csdn.net/SaketGD
 * GitHub: https://github.com/GZPING
 */

import sun.misc.FormattedFloatingDecimal;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Description TODO
 * @Author GD
 * @Date 2018/5/9 21:02
 * @Since 1.0V
 */

public class Subject {

    private List<Observer> observers = new ArrayList();

    private Integer number ;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
        updateNumber(number);
    }

    private void updateNumber(Integer number) {
        for (Observer observer : observers){
            observer.update(number);
        }
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }

    public void attach(Observer observer){
        observers.add(observer);
    }
}
