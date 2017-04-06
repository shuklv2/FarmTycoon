package com.group7.farmtycoon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;



public class WeatherMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_menu);
    }


    public void droughtPress(View v){
        WeatherManager.setWeatherState(WeatherManager.list.Drought);
        Toast.makeText(this, "Drought has been picked!", Toast.LENGTH_LONG).show();
        GameState.updateLog.add("The weather is drought!");
        WeatherManager.setOverride();
    }

    public void rainPress(View v){
        WeatherManager.setWeatherState(WeatherManager.list.Rain);
        Toast.makeText(this, "Rain has been picked!", Toast.LENGTH_LONG).show();
        GameState.updateLog.add("The weather is rain!");
        WeatherManager.setOverride();
    }

    public void tornadoPress(View v){
        WeatherManager.setWeatherState(WeatherManager.list.Tornado);
        Toast.makeText(this, "Tornado has been picked!", Toast.LENGTH_LONG).show();
        GameState.updateLog.add("The weather is tornado!");
        WeatherManager.setOverride();
    }

    public void sunnyPress(View v){
        WeatherManager.setWeatherState(WeatherManager.list.Sunny);
        Toast.makeText(this, "Sunny has been picked!", Toast.LENGTH_LONG).show();
        GameState.updateLog.add("The weather is sunny!");
        WeatherManager.setOverride();
    }

    public void backBtnPress(View v){
        Intent intent = new Intent(getApplicationContext(), GameView.class );
        startActivity(intent);
    }


}


