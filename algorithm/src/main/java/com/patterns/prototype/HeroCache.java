package com.patterns.prototype;

/**
 * Created by GD on 2018/4/21.
 */

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @Description TODO
 * @Author GD
 * @Date 2018/4/21 21:04
 * @Version 1.0V
 */

public class HeroCache {

    private static Map<Integer,Hero> heros = new HashMap<Integer,Hero>();

    public static void loadHere(){
        Hero yasso = new Yasso(1);
        Hero raven = new Raven(2);
        Hero lee = new Lee(3);
        heros.put(yasso.getId(),yasso);
        heros.put(raven.getId(),raven);
        heros.put(lee.getId(),lee);
    }

    public static Hero getHero(Integer id) throws CloneNotSupportedException {
        if(id == null){
            return null;
        }
        Hero hero = heros.get(id);
        return (Hero) hero.clone();
    }

    public static void main(String[] args) {
        try {
            HeroCache.loadHere();
            Hero yasso = HeroCache.getHero(1);
            yasso.kill();
            Hero raven = HeroCache.getHero(2);
            raven.kill();
            Hero lee = HeroCache.getHero(3);
            lee.kill();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

}
