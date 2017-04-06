package com.group7.farmtycoon;

import android.graphics.Bitmap;
import android.util.Log;

/**
 * Created by Michael on 2017-03-30.
 */

public abstract class Crop {

    //Life vars
    protected int life=0;
    protected int HP=0;


    //expiry vars
    protected int expiryPeriod;   //how long it takes before its dead
    private int expiryTimer=0;    //current time of expiry
    private boolean startExpiring=false;  //start expiring now
    private boolean expired=false;        //if its starts to decline


    //no water period
    protected int noWaterPeriod=3;
    private int noWaterTimer=0;
    private boolean startNoWater=false;
    private boolean noWater=false;
    private int starveDMG =1;
    //how many of this crop is there
    private int quantity=10;

    //if the crop was just watered (should refresh expiryPeriod)
    private boolean watered=true;

    //if crop can be harvested
    private boolean harvestable;

    private boolean alreadydead=false;

    private boolean fertilized=false;

    protected boolean tornadoSafe=false;
    protected boolean droughtSafe= false;

    private boolean alive=true;

    //basic update model of crops
    public void update(){
        //check if plant was water
        if(quantity>0 && alive && !expired) {
            if (watered) {
                noWaterTimer++;
                if (noWaterTimer > noWaterPeriod) {
                    watered = false;
                    noWaterTimer = 0;
                }
            }
            if(!harvestable) {
                if (!watered) {
                    takeDamage(starveDMG);
                } else {
                    if(fertilized){
                        life +=2;
                    }
                    else{
                        life += 1;
                    }

                    //cant go over HP amount
                    if (life > HP) {
                        life = HP;
                    }
                }
            }
            //check if crop is harvestable
            //with fertilizer, grows twice as fast
            if (life == HP && !harvestable & !expired) {
                harvestable = true;
                expiryTimer=0;
            }

            //expiring countdown
            if (harvestable) {
                expiryTimer++;
                if (expiryTimer > expiryPeriod) {
                    expired = true;
                    harvestable=false;
                    expiryTimer = 0;
                }
            }
        }
    }

    //watering crops
    public void water(){
        if(quantity >0){
            watered=true;
            noWaterTimer=0;
        }

    }

    //plant  new crops
    public void plant(int amount){
        if(amount >0){ alive=true;}
        quantity += amount;
        expired =false;
        watered=true;
        alreadydead=false;

    }

    //harvest the crops
    public void harvest(){
        quantity = 0;
        life=0;
        watered=false;
        harvestable=false;
        fertilized=false;
        alreadydead=false;
    }

    public void fertilize(){ fertilized =true;}

    //kill # of crops
    public void destroy(int amount){
        quantity-= amount;
        //if all crops are killed die
        if(quantity <=0){
            expired=false;
            harvestable=false;
            watered=false;
            quantity =0;
            fertilized =false;
            alive=false;
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


    public int getLife(){return life;}

    public int getHP() {return HP;}
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int q){ this.quantity = q; }

    public boolean isWatered(){ return watered;}

    public boolean isHarvestabled(){ return harvestable;}

    public boolean isAlive(){ return alive;}

    public boolean expired(){return expired; }

    public boolean tornadoSafe(){ return tornadoSafe;}

    public boolean droughtSafe(){ return droughtSafe;}

    public boolean alreadyDead(){ return alreadydead;}
    public void setAlreadyDead(boolean newState){alreadydead=newState;}
}
