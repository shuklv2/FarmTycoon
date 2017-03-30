package com.group7.farmtycoon;

/**
 * Created by vatsalshukla on 2017-03-29.
 */
public class Cow extends Livestock {

    private int milk;

    public Cow(){
        this.milk = 0;
        this.setHunger(100);
        this.setState(true);
        this.setQuantity(1);
    }

    public int getMilk(){
        return this.milk;
    }

    public void collectMilk(){
        this.setMilk(0);
    }

    public void setMilk(int milk){
        this.milk = milk;
    }




}
