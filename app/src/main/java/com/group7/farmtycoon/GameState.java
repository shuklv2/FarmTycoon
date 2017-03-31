package com.group7.farmtycoon;

/**
 * Created by Joseph on 3/30/2017.
 */
public class GameState {

    public enum state{OVERVIEW, CROP, LIVESTOCK, WEATHER}
    private int currDay;
    private int currTime;
    private GameUpdater gameUp;

    public void startGame(){
        currDay = 0;
        currTime = 0;

        //Instantiate livestock, weather, crops here? or in GameUpdater?

        //Create updater, run it
        gameUp = new GameUpdater();
        gameUp.run();
    }

    public void pauseGame(){
        gameUp.pauseSim();
    }

    public void resumeGame(){
        gameUp.resumeSim();
    }

    public void endGame(){
        //end simulation, return to main menu
    }

    public void updateDay(){
        //get day from GameUpdater
        this.currDay = gameUp.getDay();
    }

    public void updateTime(){
        //get current time from GameUpdater (in hours)
        this.currDay = gameUp.getTime();

    }
}
