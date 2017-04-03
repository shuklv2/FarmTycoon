package com.group7.farmtycoon;

import android.graphics.Bitmap;

/**
 * Created by Michael on 2017-03-30.
 */

public abstract class Crop {

    //Life vars
    private int life=0;
    protected int HP=0;


    //expiry vars
    protected int expiryPeriod;   //how long it takes before its dead
    private int expiryTimer=0;    //current time of expiry
    private boolean startExpiring=false;  //start expiring now
    private boolean expired=false;        //if its starts to decline


    //no water period
    protected int noWaterPeriod;
    private int noWaterTimer=0;
    private boolean startNoWater=false;
    private boolean noWater=false;
    private int starveDMG =1;
    //how many of this crop is there
    private int quantity=0;

    //the image that represents the crops
    protected Bitmap image;

    //if the crop was just watered (should refresh expiryPeriod)
    private boolean watered;

    //if crop can be harvested
    private boolean harvestable;


    private boolean fertilized=false;

    protected boolean tornadoSafe=false;
    protected boolean droughtSafe= false;

    public Crop(){

    }
    //basic update model of crops
    public void update(){
        //check if plant was water
        if(watered){
            //turn off water
            watered=false;
            //reset no water
            noWater=false;
            noWaterTimer=0;
        }
        else{
            noWaterTimer++;
            if(noWaterTimer >= noWaterPeriod){
                noWater= true;
            }
        }

        if(noWater){
            takeDamage(starveDMG);
        }
        else{
            life +=1;
            //cant go over HP amount
            if(life > HP){
                life = HP;
            }
        }
        //check if crop is harvestable
        //with fertilizer, grows twice as fast
        if(life == HP || (fertilized && life == HP/2)){
            harvestable=true;
        }

        //checking if harvested crops should start expiring
        if(harvestable){
            startExpiring=true;
        }


        //expiring countdown
        if(startExpiring){
            expiryTimer++;
            if(expiryTimer >= expiryPeriod){
                expired= true;
                expiryTimer=0;
            }
        }
    }

    //watering crops
    public void water(){
        watered=true;
    }

    //plant  new crops
    public void plant(int amount){
        quantity += amount;
        life=HP;
    }

    //harvest the crops
    public void harvest(){
        quantity = 0;
        watered=false;
        harvestable=false;
        fertilized=false;
    }

    public void fertilize(){ fertilized =true;}

    //kill # of crops
    public void destroy(int amount){
        quantity-= amount;
        //if all crops are killed die
        if(quantity <= 0){
            harvestable=false;
            watered=false;
            quantity =0;
            fertilized =false;
        }
        life = 0;

    }

    public void killAll(){
        destroy(quantity);
    }

    //crops take damage to life
    public void takeDamage(int amount){
        life -= amount;
        //kill all crops if life goes under 0
        if (life < 0){
            killAll();
        }
    }


    public Bitmap getImg(){ return image;}

    public int getLife(){return life;}

    public int getQuantity(){ return quantity; }
    public void setQuantity(int q){ this.quantity = q; }

    public boolean isWatered(){ return watered;}

    public boolean isHarvestabled(){ return harvestable;}

    public boolean expired(){return expired; }

    public boolean tornadoSafe(){ return tornadoSafe;}

    public boolean droughtSafe(){ return droughtSafe;}
}
