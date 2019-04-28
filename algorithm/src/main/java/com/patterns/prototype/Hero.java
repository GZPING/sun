package com.patterns.prototype;

/**
 * Created by GD on 2018/4/21.
 */

/**
 *
 * @Description TODO
 * @Author GD
 * @Date 2018/4/21 20:54
 * @Version 1.0V
 */

public abstract class Hero implements Cloneable {

    private Integer id;

    private String model;

    private String skin;

    private String ability;

    abstract void kill();

    public Hero() {
    }

    public Hero(Integer id){
        this.id=id;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }
}
