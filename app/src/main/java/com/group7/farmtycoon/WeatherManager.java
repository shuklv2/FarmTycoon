package com.group7.farmtycoon;
import android.util.Log;

import java.util.Random;

/**
 * Created by Sebas on 2017-04-02.
 */

public class WeatherManager {
    private static Tornado tornado;
    private static Rain rain;
    private static Drought drought;
    private static Sunny sunny;
    private static boolean override;


    private static Weather currWeather;

    public static enum list {
        Tornado, Rain, Drought, Sunny
    }

    private static list currentWeather;
    public static list getWeatherState(){ return currentWeather; }

    public static void init(){
        tornado = new Tornado();
        rain = new Rain();
        drought = new Drought();
        sunny = new Sunny();
        currentWeather = list.Sunny;
        override=false;
    }

    public static void setOverride(){
        override = true;
    }

    public static int getWeatherDuration(Weather weather){
        return weather.getDuration();
    }


    public static void setWeatherDuration(Weather weather, int duration){
        weather.setDuration(duration);
    }

    public static void setWeatherState(list weather){
        currentWeather = weather;
    }

    public static void update() {

        Log.d("WeatherManager","Updated");
        if (!override){
            Log.d("Weathermanager","random");
            double rdm = Math.random();
            if (rdm < 0.1) {
                currentWeather = list.Tornado;
            }
            else if (rdm < 0.2) {
                currentWeather = list.Drought;
            }
            else if (rdm < 0.5) {
                currentWeather = list.Rain;
            }
            else if (rdm < 1) {
                currentWeather = list.Sunny;
            }
        }
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

        Log.d("WeatherManager",currentWeather.toString());
        override = false;
        GameState.updateLog.add("The weather is " + currentWeather);
    }
}
