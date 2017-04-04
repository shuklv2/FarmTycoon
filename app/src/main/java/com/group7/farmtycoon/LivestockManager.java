package com.group7.farmtycoon;

import java.util.Random;

/**
 * Created by vatsalshukla on 2017-03-30.
 */
public class LivestockManager {

    private static Cow cow;
    private static Chicken chicken;
    private static Pig pig;
    private int livestockTimer;

    public LivestockManager(){
        this.cow = new Cow();
        this.chicken = new Chicken();
        this.pig = new Pig();
        this.livestockTimer = 100;
    }


    public static Chicken getChicken(){
        return chicken;
    }

    public static Cow getCow(){
        return cow;
    }

    public static Pig getPig(){
        return pig;
    }

    public static int getLivestockHunger(Livestock livestock){
        return livestock.getHunger();
    }

    public static int getLivestockQuantity(Livestock livestock){
        return livestock.getQuantity();
    }

    public static boolean getLivestockState(Livestock livestock){
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

    public static void buy(Livestock livestock){
        livestock.setQuantity(livestock.getQuantity()+1);
    }

    public static void butcher(Livestock livestock){
        if (livestock.getQuantity() > 1){
            livestock.setQuantity(livestock.getQuantity()-1);
        }else if(livestock.getQuantity() == 1){
            livestock.setQuantity(0);
            livestock.setState(false);
        }else {
            //No living livestock
        }
    }

    public static void collectResources(Livestock livestock){
        if (livestock.getResources() > 0 && livestock.getState()) {
            livestock.setResources(0);
        }
    }

    public static void feed(Livestock livestock){
        if (livestock.getHunger() < 100 && livestock.getState()){
            livestock.setHunger(livestock.getHunger()+10);
        }else{
            //livestock is full
        }

    }

    public static void breed(Livestock livestock){
        if (livestock.getQuantity() >= 2){
            livestock.setQuantity(livestock.getQuantity()+1);
        }

    }

    public static void tornadoEffect(){
        int cowQ = cow.getQuantity();
        int pigQ = pig.getQuantity();
        int chickenQ = chicken.getQuantity();
        Random rand = new Random();

        if (cowQ > 1){
            cow.setQuantity(rand.nextInt(cowQ));
            if (cow.getQuantity()<1){
                cow.setState(false);
            }
        }
        if(pigQ > 1){
            pig.setQuantity(rand.nextInt(pigQ));
            if (pig.getQuantity()<1){
                pig.setState(false);
            }
        }
        if(chickenQ > 1){
            chicken.setQuantity(rand.nextInt(chickenQ));
            if (chicken.getQuantity()<1){
                chicken.setState(false);
            }
        }

    }

    public void update() {

        if (livestockTimer >= 10 && livestockTimer <= 100) {
            livestockTimer -= 10;
            if (chicken.getHunger() >= 10 && cow.getHunger() >= 10 && pig.getHunger() >=10){
                chicken.setHunger(chicken.getHunger() - 10);
                cow.setHunger(cow.getHunger() - 10);
                pig.setHunger(pig.getHunger() - 10);
            }
            if (chicken.getHunger() <= 10){
                if (chicken.getQuantity()>1){
                    chicken.setQuantity(chicken.getQuantity()-1);
                }else{
                    chicken.setState(false);
                }
            }
            if (cow.getHunger() <= 10){
                if (cow.getQuantity()>1){
                    cow.setQuantity(cow.getQuantity()-1);
                }else{
                    cow.setState(false);
                }
            }
            if (pig.getHunger() <= 10) {
                if (pig.getQuantity() > 1) {
                    pig.setQuantity(pig.getQuantity() - 1);
                } else {
                    pig.setState(false);
                }
            }
        }

        if (livestockTimer == 70 || livestockTimer == 50 || livestockTimer == 30 || livestockTimer == 20) {
            if (cow.getMilk() < 100 && chicken.getEggs() < 100) {
                cow.setMilk(cow.getMilk() + 10);
                chicken.setEggs(chicken.getEggs() + 10);
            }

        }

        if(livestockTimer < 10){
            livestockTimer = 100;
        }

    }
}
