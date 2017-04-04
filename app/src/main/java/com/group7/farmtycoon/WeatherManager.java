package com.group7.farmtycoon;

/**
 * Created by Sebas on 2017-04-02.
 */

public class WeatherManager {
    private Tornado tornado;
    private Rain rain;
    private Drought drought;

    public WeatherManager(){
        this.tornado = new Tornado();
        this.rain = new Rain();
        this.drought = new Drought();
    }

    public int getWeatherDuration(Weather weather){
        return weather.getDuration();
    }

    public boolean getWeatherState(Weather weather){
        return weather.getState();
    }

    public void setWeatherDuration(Weather weather, int duration){
        weather.setDuration(duration);
    }

    public void setWeatherState(Weather weather, boolean state){
        weather.setState(state);
    }

}