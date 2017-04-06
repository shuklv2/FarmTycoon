package com.group7.farmtycoon;

import android.content.Intent;
import android.graphics.Color;
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
        update();
    }
    public void waterBtnPress(View v){
        Toast.makeText(this, "Crops Watered", Toast.LENGTH_LONG).show();
        CropManager.waterCrops();
        update();
    }

    public void harvestBtnPress(View v){
        if(CropManager.harvestableCrops()){
            Toast.makeText(this, "Crops Harvested", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "There are no crops to harvest", Toast.LENGTH_LONG).show();
        }

        CropManager.harvestCrops(); update();}

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

        TextView cornStatus = (TextView) findViewById(R.id.cornStatus);
        TextView strawStatus = (TextView) findViewById(R.id.strawStatus);
        TextView pumpkinStatus = (TextView) findViewById(R.id.pumpkinStatus);
        TextView potatoStatus = (TextView) findViewById(R.id.potatoStatus);

        boolean cornExpired = CropManager.getCrop("corn").expired();
        boolean strawExpired = CropManager.getCrop("strawberry").expired();
        boolean potatoExpired = CropManager.getCrop("potato").expired();
        boolean pumpkinExpired = CropManager.getCrop("pumpkin").expired();

        boolean cornHarvest = CropManager.getCrop("corn").isHarvestabled();
        boolean strawHarvest = CropManager.getCrop("strawberry").isHarvestabled();
        boolean potatoHarvest = CropManager.getCrop("potato").isHarvestabled();
        boolean pumpkinHarvest = CropManager.getCrop("pumpkin").isHarvestabled();

        boolean cornWatered = CropManager.getCrop("corn").isWatered();
        boolean strawWatered = CropManager.getCrop("strawberry").isWatered();
        boolean potatoWatered = CropManager.getCrop("potato").isWatered();
        boolean pumpkinWatered = CropManager.getCrop("pumpkin").isWatered();

        boolean cornAlive = CropManager.getCrop("corn").isAlive();
        boolean strawAlive = CropManager.getCrop("strawberry").isAlive();
        boolean potatoAlive = CropManager.getCrop("potato").isAlive();
        boolean pumpkinAlive = CropManager.getCrop("pumpkin").isAlive();

        if(!cornAlive){
            cornStatus.setText("DEAD");
            cornStatus.setTextColor(Color.RED);
        }
        else if(cornExpired){
            cornStatus.setText("EXPIRED");
            cornStatus.setTextColor(Color.GRAY);
        }
        else if(cornHarvest){
            cornStatus.setText("READY");
            cornStatus.setTextColor(Color.WHITE);
        }
        else if(cornWatered && !cornHarvest){
            cornStatus.setText("WATERED");
            cornStatus.setTextColor(Color.BLUE);
        }
        else{
            cornStatus.setText("");
        }


        if(!strawAlive){
            strawStatus.setText("DEAD");
            strawStatus.setTextColor(Color.RED);
        }
        else if(strawExpired){
            strawStatus.setText("EXPIRED");
            strawStatus.setTextColor(Color.GRAY);
        }
        else if(strawHarvest){
            strawStatus.setText("READY");
            strawStatus.setTextColor(Color.rgb(51,102,0));
        }
        else if(strawWatered){
            strawStatus.setText("WATERED");
            strawStatus.setTextColor(Color.BLUE);
        }
        else{
            strawStatus.setText("");
        }


        if(!potatoAlive){
            potatoStatus.setText("DEAD");
            potatoStatus.setTextColor(Color.RED);
        }
        else if(potatoExpired){
            potatoStatus.setText("EXPIRED");
            potatoStatus.setTextColor(Color.GRAY);
        }
        else if(potatoHarvest){
            potatoStatus.setText("READY");
            potatoStatus.setTextColor(Color.WHITE);
        }
        else if(potatoWatered){
            potatoStatus.setText("WATERED");
            potatoStatus.setTextColor(Color.BLUE);
        }
        else{
            potatoStatus.setText("");
        }


        if(!pumpkinAlive){
            pumpkinStatus.setText("DEAD");
            pumpkinStatus.setTextColor(Color.RED);
        }
        else if(pumpkinExpired){
            pumpkinStatus.setText("EXPIRED");
            pumpkinStatus.setTextColor(Color.GRAY);
        }
        else if(pumpkinHarvest){
            pumpkinStatus.setText("READY");
            pumpkinStatus.setTextColor(Color.WHITE);
        }
        else if(pumpkinWatered){
            pumpkinStatus.setText("WATERED");
            pumpkinStatus.setTextColor(Color.BLUE);
        }
        else{
            pumpkinStatus.setText("");
        }
    }
}
