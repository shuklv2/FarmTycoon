package com.group7.farmtycoon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class CropMenu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        CropManager.init();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_menu);
    }

    public void viewBtnPress(View v){
    }
    public void waterBtnPress(View v){
        CropManager.waterCrops();
    }

    public void harvestBtnPress(View v){ CropManager.harvestCrops();}

    public void plantBtnPress(View v){
        CropManager.setPlantOrKill(true);
        Intent intent = new Intent(getApplicationContext(), CropChooseMenu.class );
        startActivity(intent);
    }
    public void clearBtnPress(View v){
        CropManager.setPlantOrKill(false);
        Intent intent = new Intent(getApplicationContext(), CropChooseMenu.class );
        startActivity(intent);
    }
}
