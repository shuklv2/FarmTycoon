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


    public static void buy(Livestock livestock){
        livestock.setQuantity(livestock.getQuantity()+1);
        if (livestock.getQuantity() > 0){
            livestock.setState(true);
        }
    }

    public static void butcher(Livestock livestock){
        if (livestock.getQuantity() > 1){
            livestock.setQuantity(livestock.getQuantity()-1);
        }else if(livestock.getQuantity() == 1){
            livestock.setQuantity(0);
            livestock.setState(false);
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

    public void tornadoEffect(){
        int cowQ = cow.getQuantity();
        int pigQ = pig.getQuantity();
        int chickenQ = chicken.getQuantity();
        Random rand = new Random();

        if (cowQ > 1){
            int num = rand.nextInt(cowQ);
            cow.setQuantity(cow.getQuantity()-num);
            GameState.updateLog.add(num+" cow(s) were killed due to the Tornado.");
            if (cow.getQuantity()<1){
                cow.setState(false);
            }
        }
        if(pigQ > 1){
            int num = rand.nextInt(pigQ);
            pig.setQuantity(pig.getQuantity()-num);
            GameState.updateLog.add(num+" pig(s) were killed due to the Tornado.");
            if (pig.getQuantity()<1){
                pig.setState(false);
            }
        }
        if(chickenQ > 1){
            int num = rand.nextInt(chickenQ);
            chicken.setQuantity(chicken.getQuantity()-num);
            GameState.updateLog.add(num + " chicken(s) were killed due to the Tornado.");
            if (chicken.getQuantity()<1){
                chicken.setState(false);
            }
        }

    }

    public void update(WeatherManager.list weather) {
        if (chicken.getQuantity() > 0){
            chicken.setState(true);
        }
        if (cow.getQuantity() > 0){
            cow.setState(true);
        }
        if (pig.getQuantity() > 0){
            pig.setState(true);
        }
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


        if (weather.equals(WeatherManager.list.Tornado)){
            tornadoEffect();

        }

        if (CropManager.getCrop("corn").getQuantity()<=5 || CropManager.getCrop("pumpkin").getQuantity()<=5){
            GameState.updateLog.add("There is not enough crop to feed the livestock. Plant more.");
            if (cow.getHunger() >= 20){
                cow.setHunger(cow.getHunger()-20);
            }
            if (pig.getHunger() >= 20){
                pig.setHunger(pig.getHunger()-20);
            }
            if (chicken.getHunger() >= 20){
                chicken.setHunger(chicken.getHunger()-20);
            }
        }

    }
}
