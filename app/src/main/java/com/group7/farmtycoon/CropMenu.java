package com.group7.farmtycoon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CropMenu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_menu);
        update();
    }

    public void viewBtnPress(View v){
        //CropManager.update();
        update();
    }
    public void waterBtnPress(View v){
        CropManager.waterCrops();
    }

    public void harvestBtnPress(View v){ CropManager.harvestCrops(); update();}

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
    public void backBtnPress(View v){
        Intent intent = new Intent(getApplicationContext(), GameView.class );
        startActivity(intent);
    }

    public void update(){
        TextView cornQty = (TextView) findViewById(R.id.cornQty);
        TextView strawQty = (TextView) findViewById(R.id.strawberryQty);
        TextView pumpkinQty = (TextView) findViewById(R.id.pumpkinQty);
        TextView potatoQty = (TextView) findViewById(R.id.potatoQty);
        cornQty.setText("Qty:"+Integer.toString(CropManager.getCrop("corn").getQuantity()));
        strawQty.setText("Qty:"+Integer.toString(CropManager.getCrop("strawberry").getQuantity()));
        pumpkinQty.setText("Qty:"+Integer.toString(CropManager.getCrop("pumpkin").getQuantity()));
        potatoQty.setText("Qty:"+Integer.toString(CropManager.getCrop("potato").getQuantity()));

        TextView cornHP = (TextView) findViewById(R.id.cornHP);
        TextView strawHP = (TextView) findViewById(R.id.strawberryHP);
        TextView pumpkinHP = (TextView) findViewById(R.id.pumpkinHP);
        TextView potatoHP = (TextView) findViewById(R.id.potatoHP);
        cornHP.setText("HP:"+CropManager.getCrop("corn").getLife()+ "/" +CropManager.getCrop("corn").getHP());
        strawHP.setText("HP:"+CropManager.getCrop("strawberry").getLife()+ "/" +CropManager.getCrop("strawberry").getHP());
        pumpkinHP.setText("HP:"+CropManager.getCrop("pumpkin").getLife()+ "/" +CropManager.getCrop("pumpkin").getHP());
        potatoHP.setText("HP:"+CropManager.getCrop("potato").getLife()+ "/" +CropManager.getCrop("potato").getHP());

    }
}
