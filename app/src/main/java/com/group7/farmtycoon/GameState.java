package com.group7.farmtycoon;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joseph on 3/30/2017.
 */
public class GameState {

    //**************************
    //FIELDS
    //**************************

    public enum state{OVERVIEW, CROP, LIVESTOCK, WEATHER} //May be unneeded
    private int currDay;
    private double currTime;
    private state currState;
    private LivestockManager livestockManager;
    private WeatherManager weatherManager;
    public static List updateLog;

    //**************************
    //CONSTRUCTORS
    //**************************

    public GameState(){
        currDay = 1;
        currTime = 0;

        livestockManager = new LivestockManager();
        weatherManager = new WeatherManager();
        CropManager.init();

        updateLog = new ArrayList();
    }

    //**************************
    //FUNCTIONS
    //**************************

    public void updateAll(){
        //livestockManager.update(weatherManager.getWeatherState());
        //CropManager.update(weatherManager.getWeatherState());
        //weatherManager.update();
    }

    public List getLogs(){
        return updateLog;
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
