package com.group7.farmtycoon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void startBtnPress(View v){
        Log.d("startBtn", "Clicked");
        Intent intent = new Intent(getApplicationContext(), CropMenu.class );
        startActivity(intent);
    }

    public void exitBtnPress(View v){
        finish();
        System.exit(0);
    }
}
