package com.group7.farmtycoon;

/**
 * Created by vatsalshukla on 2017-03-30.
 */
public class Chicken extends Livestock {


    public Chicken(){
        this.setResources(0);
        this.setHunger(100);
        this.setState(true);
        this.setQuantity(1);
    }

    public int getEggs(){
        return this.getResources();
    }

    public void setEggs(int eggs){
        this.setResources(eggs);
    }

    public void collectEggs(){
        this.setResources(0);
    }
}
