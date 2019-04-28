package com.patterns.builder;

/**
 * Created by GD on 2018/4/22.
 * Blog: https://blog.csdn.net/SaketGD
 */

import java.util.LinkedList;
import java.util.List;

/**
 * @Description TODO
 * @Author GD
 * @Date 2018/4/22 17:36
 * @Since 1.0V
 */

public class Meal {

    private List<Item> items = new LinkedList<Item>();

    public void addItem(Item item) {
        items.add(item);
    }

    public float getCost(){
        float cost = 0.0f;
        for(Item item : items){
            cost += item.price();
        }
        return cost;
    }

    public void showItem() {
        for (Item item : items) {
            System.out.println("item:" + item.name() + "   " + item.price());
        }
    }

}
