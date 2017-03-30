package com.group7.farmtycoon;

/**
 * Created by vatsalshukla on 2017-03-29.
 */
public class Cow extends Livestock {


    public Cow(){
        this.setResources(0);
        this.setHunger(100);
        this.setState(true);
        this.setQuantity(1);
    }

    public int getMilk(){
        return this.getResources();
    }

    public void collectMilk(){
        this.setResources(0);
    }

    public void setMilk(int milk){
        this.setResources(milk);
    }




}
