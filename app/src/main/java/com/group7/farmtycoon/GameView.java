package com.group7.farmtycoon;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class GameView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_view);

        GameUpdater gameUpdater = new GameUpdater(GameView.this);
        gameUpdater.start();
    }

    public void updateTime(double time){
        TextView timeText = (TextView) findViewById(R.id.timeTxt);
        timeText.setText("Time: " + String.format("%1$.0f", time) + ":00");
    }

    public void updateDay(int day){
        TextView timeText = (TextView) findViewById(R.id.dayTxt);
        timeText.setText("Day: " + day);
    }

    public void livestockButtonPress(View v){
        Intent intent = new Intent(getApplicationContext(), LivestockMenu.class );
        startActivity(intent);
    }
    public void cropButtonPress(View v){
        Intent intent = new Intent(getApplicationContext(), CropMenu.class );
        startActivity(intent);
    }
    public void weatherButtonPress(View v){
        Intent intent = new Intent(getApplicationContext(), WeatherMenu.class );
        startActivity(intent);
    }

    public void updateLog(String newLog){
        TextView logText = (TextView) findViewById(R.id.logTxt);
        logText.setText(newLog);
    }

}
