package com.group7.farmtycoon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class WeatherMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_menu);
    }

    public void droughtPress(View v){
        w.setWeatherState(WeatherManager.Drought);
    }
    public void rainPress(View v){
        w.setWeatherState(WeatherManager.Rain);
    }
    public void tornadoPress(View v){
        w.setWeatherState(WeatherManager.Tornado);
    }
    public void sunnyPress(View v){
        w.setWeatherState(WeatherManager.Sunny);
    }

    WeatherManager w = new WeatherManager();
}


