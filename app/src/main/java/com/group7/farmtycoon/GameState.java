package com.group7.farmtycoon;

import android.content.Context;

/**
 * Created by Joseph on 3/30/2017.
 */
public class GameState {

    //**************************
    //FIELDS
    //**************************

    public enum state{OVERVIEW, CROP, LIVESTOCK, WEATHER}
    private int currDay;
    private double currTime;
    private state currState;
    private LivestockManager livestockManager;
    private WeatherManager weatherManager;
    //TODO: Include livestock, weather, crop managers here

    //**************************
    //CONSTRUCTORS
    //**************************

    public GameState(){
        currDay = 1;
        currTime = 0;

        livestockManager = new LivestockManager();
        weatherManager = new WeatherManager();
        CropManager.init();
        //TODO: Instantiate livestock, weather, crop managers here
    }

    //**************************
    //FUNCTIONS
    //**************************

    public void updateAll(){
        livestockManager.update();
        CropManager.update();
        //weatherManager.update();
    }
    public void endGame(){
        //end simulation, return to main menu
    }

    public int getDay(){
        return this.currDay;
    }

    public void setDay(int newDay){
        this.currDay = newDay;
    }

    public void setTime(double newTime){
        this.currTime = newTime;
    }

    public double getTime(){
        return currTime;
    }


}
