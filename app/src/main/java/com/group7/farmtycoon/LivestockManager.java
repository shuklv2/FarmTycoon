package com.group7.farmtycoon;

/**
 * Created by vatsalshukla on 2017-03-30.
 */
public class LivestockManager {

    private Cow cow;
    private Chicken chicken;
    private Pig pig;

    public LivestockManager(){
        this.cow = new Cow();
        this.chicken = new Chicken();
        this.pig = new Pig();
    }


    public int getLivestockHunger(Livestock livestock){
        return livestock.getHunger();
    }

    public int getLivestockQuantity(Livestock livestock){
        return livestock.getQuantity();
    }

    public boolean getLivestockState(Livestock livestock){
        return livestock.getState();
    }

    public void setLivestockHunger(Livestock livestock, int hunger){
        livestock.setHunger(hunger);
    }

    public void setLivestockQuantity(Livestock livestock, int quantity){
        livestock.setQuantity(quantity);
    }

    public void setLivestockState(Livestock livestock, boolean state){
        livestock.setState(state);
    }

    public void buy(Livestock livestock){
        livestock.setQuantity(livestock.getQuantity()+1);
    }

    public void butcher(Livestock livestock){
        if (livestock.getQuantity() > 1){
            livestock.setQuantity(livestock.getQuantity()-1);
        }else if(livestock.getQuantity() == 1){
            livestock.setQuantity(0);
            livestock.setState(false);
        }else {
            //No living livestock
        }
    }

    public void collectResources(Livestock livestock){
        if (livestock.getResources() > 0) {
            livestock.setResources(0);
        }
    }

    public void feed(Livestock livestock){
        livestock.setHunger(100);
    }

    public void breed(Livestock livestock){
        livestock.setQuantity(livestock.getQuantity()+1);
    }



}
