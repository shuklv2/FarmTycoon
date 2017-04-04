package com.group7.farmtycoon;
import java.util.Random;

/**
 * Created by Sebas on 2017-04-02.
 */

public class WeatherManager {
    private Tornado tornado;
    private Rain rain;
    private Drought drought;
    private Sunny sunny;

    private Weather currWeather;

    public enum list {
        Tornado, Rain, Drought, Sunny
    }

    private list currentWeather;
    public list getWeatherState(){ return currentWeather; }

    public WeatherManager(){
        this.tornado = new Tornado();
        this.rain = new Rain();
        this.drought = new Drought();
        this.sunny = new Sunny();
    }

    public int getWeatherDuration(Weather weather){
        return weather.getDuration();
    }


    public void setWeatherDuration(Weather weather, int duration){
        weather.setDuration(duration);
    }

    public void setWeatherState(list weather){
        currentWeather = weather;
    }

    public void update() {
        switch (currentWeather) {
            case Tornado:
                currWeather =tornado;
                break;
            case Rain:
                currWeather =rain;
                break;
            case Drought:
                currWeather =drought;
                break;
            case Sunny:
                currWeather =sunny;
                break;

        }


        double rdm = Math.random();
        if(rdm <0.25){
            currentWeather = list.Tornado;
        }
        else if (rdm <0.5){
            currentWeather = list.Rain;
        }
        else if(rdm<0.75){
            currentWeather = list.Drought;
        }
        else  if(rdm <1){
            currentWeather = list.Sunny;
        }


//        currWeather.update();
//        if(!currWeather.getState()){
//            currentWeather = list.Sunny;
//        }
    }
}
