package com.group7.farmtycoon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class CropChooseMenu extends AppCompatActivity {

    String type="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_choose_menu);
        if(!CropManager.plantOrKill()){
            ToggleButton fertTB = (ToggleButton) findViewById(R.id.fertilizeTB);
            fertTB.setVisibility(View.GONE);
        }
    }
    public void okBtnPress(View v){
        TextView qtyText = (TextView) findViewById(R.id.qtyTB);
        int qty=0;
        try {
            qty = Integer.parseInt(qtyText.getText().toString());
        } catch (NumberFormatException e) {
            qty=0;
        }
        if(qty >0 && type != ""){
            if(CropManager.plantOrKill()){
                CropManager.plantCrops(type,qty);
                ToggleButton fertTB = (ToggleButton) findViewById(R.id.fertilizeTB);
                if(fertTB.isChecked()){
                    CropManager.fertilizeCrop(type);
                }
            }
            else{
                CropManager.destroyCrops(type,qty);
            }
            Intent intent = new Intent(getApplicationContext(), CropMenu.class );
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }
        else{
            Toast.makeText(this, "Please Enter Valid Quantity/ Choose Crop", Toast.LENGTH_LONG).show();
        }

    }
    public void cornRbClicked(View v){

        type="corn";
    }

    public void potatoRbClicked(View v){
        type="potato";
    }

    public void pumpkinRbClicked(View v){
        type="pumpkin";
    }

    public void strawberryRbClicked(View v){
        type="strawberry";
    }
}
