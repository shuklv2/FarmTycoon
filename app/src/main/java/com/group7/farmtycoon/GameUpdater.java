package com.group7.farmtycoon;

/**
 * Created by Joseph on 3/30/2017.
 */
public class GameUpdater extends Thread{

    //**************************
    //FIELDS
    //**************************

    private int tickCount;
    private int tickRate; //ticks per second
    private int minsPerDay; //how many minutes to wait before proceeding to next day
    private int dayCount;
    private int time; //in hours
    private int ticksPerDay;
    private boolean isRunning;


    //**************************
    //CONSTRUCTORS
    //**************************

    //Default constructor
    public GameUpdater(){
        tickCount = 0;
        tickRate = 16;
        isRunning = false;
        minsPerDay = 3;
        ticksPerDay = tickRate*60*minsPerDay;
        dayCount = 0;
    }

    //Custom tickrate...in case default is too much lol
    public GameUpdater(int tickRate, int minsPerDay){
        this.tickCount = 0;
        this.tickRate = tickRate;
        this.isRunning = false;
        this.minsPerDay = minsPerDay;
        this.ticksPerDay = tickRate*60*minsPerDay;
        this.dayCount = 0;
    }


    //**************************
    //FUNCTIONS
    //**************************

    //Main thread
    public void run(){
        while(isRunning){

            //when the next day is reached
            if ((tickCount % ticksPerDay) == 0){
                nextDay();
            }

            tickCount++;

            try{
                sleep(1000/tickRate); //(milliseconds)
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private void update(){
        //this is where we'd update crop, livestock, weather attributes using the managers.
        //for example, reduce crop and livestock hp, change weather of the day, etc
    }

    private void nextDay(){
        //play whatever animation for ending day (fade screen to black)
        //or change any graphics indicating time of day, etc
        update();
        //fade back, indicate that the new day has started
    }

    public void resumeSim(){
        isRunning = true;
    }

    public void pauseSim(){
        isRunning = false;
    }

    public int getDay(){
        return dayCount;
    }

    //Calculates time of the day, returns in hours
    public int getTime(){
        int ticksToday = tickCount - dayCount*ticksPerDay;
        return ticksToday/ticksPerDay*24;
    }

}
