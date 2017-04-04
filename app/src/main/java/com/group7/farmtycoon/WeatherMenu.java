package com.group7.farmtycoon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
/**
 * Created by Sebas on 2017-04-03.
 */

public class WeatherMenu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_menu);
    }

    public void droughtPress(View v){
        WeatherManager.currentWeather(WeatherManager.Drought);
    }

    public void rainPress(View v){
        WeatherManager.currentWeather(WeatherManager.Rain);
    }
    public void tornadoPress(View v){
        WeatherManager.currentWeather(WeatherManager.Tornado);
    }
    public void sunnyPress(View v){
        WeatherManager.currentWeather(WeatherManager.Sunny);
    }


}
