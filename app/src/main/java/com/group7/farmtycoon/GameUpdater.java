package com.group7.farmtycoon;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
    private int ticksPerDay;
    private boolean isRunning;
    private static String log; //Holds the update log text
    private GameState gameState;
    GameView currContext;


    //**************************
    //CONSTRUCTORS
    //**************************

    //Default constructor
    public GameUpdater(GameView context){
        this.tickCount = 0;
        this.tickRate = 16;
        this.isRunning = false;
        this.minsPerDay = 3;
        this.ticksPerDay = tickRate*60*minsPerDay;
        this.dayCount = 0;
        log = "";
        this.gameState = new GameState();
        this.currContext = context;
    }

    //Custom tickrate...in case default is too much lol
    public GameUpdater(GameView context, int tickRate, int minsPerDay){
        this.tickCount = 0;
        this.tickRate = tickRate;
        this.isRunning = false;
        this.minsPerDay = minsPerDay;
        this.ticksPerDay = tickRate*60*minsPerDay;
        this.dayCount = 0;
        log = "";
        this.gameState = new GameState();
        this.currContext = context;
    }


    //**************************
    //FUNCTIONS
    //**************************

    @Override
    public void run(){
        isRunning = true;
        GameState.updateLog.add("New farm simulation started.");
        while(isRunning){

            //when the next day is reached
            if (((tickCount % ticksPerDay) == 0) && tickCount != 0){
                nextDay();
            }

            tickCount++;
            updateTime();

            //Update log every second
            if ((tickCount%tickRate == 0)){
                updateLog(currContext);
            }

            try{
                sleep(1000/tickRate); //(milliseconds)
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private void update(){
        //this is where we tell gameState to update crop, weather, and livestock managers
        gameState.updateAll();
    }

    public void nextDay(){
        //play whatever animation for ending day (fade screen to black)
        //or change any graphics indicating time of day, etc
        gameState.setDay(gameState.getDay() + 1);
        gameState.setTime(0.0);
        tickCount = 0;
        update();
        GameState.updateLog.add("A new day has started");
        //fade back, indicate that the new day has started
    }

    public void resumeSim(){
        isRunning = true;
    }

    public void pauseSim(){
        isRunning = false;
    }

    //Calculates time of the day, returns in hours
    public void updateTime(){
        gameState.setTime(((double)tickCount/ticksPerDay)*24);

        currContext.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                currContext.updateTime(gameState.getTime());
                currContext.updateDay(gameState.getDay());
            }
        });
    }

    public void updateLog(final GameView context){
        context.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                log = ""; //Empty log

                //Populate log with gameState.getLogs()
                for(Iterator<String> i = gameState.getLogs().iterator(); i.hasNext();){
                    log = i.next() + "\n" + log;
                }

                currContext.updateLog(log);
            }
        });
    }

}
