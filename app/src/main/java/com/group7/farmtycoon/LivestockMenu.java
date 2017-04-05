package com.group7.farmtycoon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class LivestockMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livestock_menu);
        chickenText();
        cowText();
        pigText();
    }

    public void feedChickenPress(View v){
        if (LivestockManager.getChicken().getHunger() == 100){
            Toast.makeText(this, "Chickens are already full!", Toast.LENGTH_LONG).show();
        }else{
            LivestockManager.feed(LivestockManager.getChicken());
        }
        chickenText();
    }

    public void feedCowPress(View v){
        if (LivestockManager.getCow().getHunger() == 100){
            Toast.makeText(this, "Cows are already full!", Toast.LENGTH_LONG).show();
        }else {
            LivestockManager.feed(LivestockManager.getCow());
        }
        cowText();
    }

    public void feedPigPress(View v){
        if (LivestockManager.getPig().getHunger() == 100){
            Toast.makeText(this, "Pigs are already full!", Toast.LENGTH_LONG).show();
        }else {
            LivestockManager.feed(LivestockManager.getPig());
        }
        pigText();
    }

    public void butcherChickenPress(View v){
        if (LivestockManager.getChicken().getQuantity() == 0){
            Toast.makeText(this, "You can't butcher imaginary chickens!", Toast.LENGTH_LONG).show();
        }else {
            LivestockManager.butcher(LivestockManager.getChicken());
        }
        chickenText();
    }

    public void butcherCowPress(View v){
        if (LivestockManager.getCow().getQuantity() == 0){
            Toast.makeText(this, "You can't butcher imaginary cows!", Toast.LENGTH_LONG).show();
        }else {
            LivestockManager.butcher(LivestockManager.getCow());
        }
        cowText();
    }

    public void butcherPigPress(View v){
        if (LivestockManager.getPig().getQuantity() == 0){
            Toast.makeText(this, "You can't butcher imaginary pigs!", Toast.LENGTH_LONG).show();
        }else {
            LivestockManager.butcher(LivestockManager.getPig());
        }
        pigText();
    }

    public void breedChicken(View v){
        if (LivestockManager.getChicken().getQuantity() == 1){
            Toast.makeText(this, "You can't breed a lone chicken!", Toast.LENGTH_LONG).show();
        }else {
            LivestockManager.breed(LivestockManager.getChicken());
        }
        chickenText();
    }

    public void breedCow(View v){
        if (LivestockManager.getCow().getQuantity() == 1){
            Toast.makeText(this, "You can't breed a lone cow!", Toast.LENGTH_LONG).show();
        }else {
            LivestockManager.breed(LivestockManager.getCow());
        }
        cowText();
    }

    public void breedPig(View v){
        if (LivestockManager.getPig().getQuantity() == 1){
            Toast.makeText(this, "You can't breed a lone pig!", Toast.LENGTH_LONG).show();
        }else {
            LivestockManager.breed(LivestockManager.getPig());
        }
        pigText();
    }

    public void buyChicken(View v){
        LivestockManager.buy(LivestockManager.getChicken());
        chickenText();
    }

    public void buyCow(View v){
        LivestockManager.buy(LivestockManager.getCow());
        cowText();
    }

    public void buyPig(View v){
        LivestockManager.buy(LivestockManager.getPig());
        pigText();
    }

    public void eggsPress(View v){
        if (LivestockManager.getChicken().getEggs() == 0){
            Toast.makeText(this, "There are no eggs to collect!", Toast.LENGTH_LONG).show();
        }else {
            LivestockManager.collectResources(LivestockManager.getChicken());
        }
        chickenText();
    }

    public void milkPress(View v){
        if (LivestockManager.getCow().getMilk() == 0){
            Toast.makeText(this, "There is no milk to collect!", Toast.LENGTH_LONG).show();
        }else {
            LivestockManager.collectResources(LivestockManager.getCow());
        }
        cowText();
    }

    public void chickenText(){
        TextView chicken = (TextView) findViewById(R.id.chickenText);
        String qty =  Integer.toString(LivestockManager.getChicken().getQuantity());
        String hunger = Integer.toString(LivestockManager.getChicken().getHunger());
        String eggs = Integer.toString(LivestockManager.getChicken().getEggs());
        String state = Boolean.toString(LivestockManager.getChicken().getState());
        String chickenInfo = "Qty: "+qty+"\n Hunger: "+hunger+"\n Eggs: "+eggs+"\n State: "+state;
        chicken.setText(chickenInfo);
    }

    public void cowText(){
        TextView cow = (TextView) findViewById(R.id.cowText);
        String qty =  Integer.toString(LivestockManager.getCow().getQuantity());
        String hunger = Integer.toString(LivestockManager.getCow().getHunger());
        String milk = Integer.toString(LivestockManager.getCow().getMilk());
        String state = Boolean.toString(LivestockManager.getCow().getState());
        String cowInfo = "Qty: "+qty+"\n Hunger: "+hunger+"\n Milk: "+milk+"\n State: "+state;
        cow.setText(cowInfo);
    }

    public void pigText(){
        TextView pig = (TextView) findViewById(R.id.pigText);
        String qty =  Integer.toString(LivestockManager.getPig().getQuantity());
        String hunger = Integer.toString(LivestockManager.getPig().getHunger());
        String state = Boolean.toString(LivestockManager.getPig().getState());
        String pigInfo = "Qty: "+qty+"\n Hunger: "+hunger+"\n State: "+state;
        pig.setText(pigInfo);
    }


}
