package com.group7.farmtycoon;


/**
 * Created by Sebas on 2017-04-02.
 */

public class WeatherManager {
    private Tornado tornado;
    private Rain rain;
    private Drought drought;
    private Sunny sunny;

    private Weather currWeather;

    private enum list {
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
        currWeather.update();
        if(!currWeather.getState()){
            currentWeather = list.Sunny;
        }
    }
}
