package com.group7.farmtycoon;

/**
 * Created by vatsalshukla on 2017-03-29.
 */
public abstract class Livestock {

    private boolean state;
    private int quantity;
    private int hunger;
    private int resources;

    public Livestock(){
        this.state = true;
        this.quantity = 0;
        this.hunger = 100;
        this.resources = 0;
    }

    public boolean getState() {
        return state;
    }

    public int getHunger() {
        return hunger;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getResources() {
        return resources;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setResources(int resources) {
        this.resources = resources;
    }

    public void setState(boolean state) {
        this.state = state;
    }

}
