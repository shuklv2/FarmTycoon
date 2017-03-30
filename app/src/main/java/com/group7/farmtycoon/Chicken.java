package com.group7.farmtycoon;

/**
 * Created by vatsalshukla on 2017-03-30.
 */
public class Chicken extends Livestock {

    private int eggs;

    public Chicken(){
        this.eggs = 0;
        this.setHunger(100);
        this.setState(true);
        this.setQuantity(1);
    }

    public int getEggs(){
        return this.eggs;
    }

    public void setEggs(int eggs){
        this.eggs = eggs;
    }

    public void collectEggs(){
        this.setEggs(0);
    }
}
