package com.group7.farmtycoon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LivestockMenu extends AppCompatActivity {


   // private TextView cow = (TextView) findViewById(R.id.cowText);
    //private TextView pig = (TextView) findViewById(R.id.pigText);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livestock_menu);
        chickenText();
        cowText();
        pigText();
    }

    public void feedChickenPress(View v){
        LivestockManager.feed(LivestockManager.getChicken());
        chickenText();
    }

    public void feedCowPress(View v){
        LivestockManager.feed(LivestockManager.getCow());
        cowText();
    }

    public void feedPigPress(View v){
        LivestockManager.feed(LivestockManager.getPig());
        pigText();
    }

    public void butcherChickenPress(View v){
        LivestockManager.butcher(LivestockManager.getChicken());
        chickenText();
    }

    public void butcherCowPress(View v){
        LivestockManager.butcher(LivestockManager.getCow());
        cowText();
    }

    public void butcherPigPress(View v){
        LivestockManager.butcher(LivestockManager.getPig());
        pigText();
    }

    public void breedChicken(View v){
        LivestockManager.breed(LivestockManager.getChicken());
        chickenText();
    }

    public void breedCow(View v){
        LivestockManager.breed(LivestockManager.getCow());
        cowText();
    }

    public void breedPig(View v){
        LivestockManager.breed(LivestockManager.getPig());
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
        LivestockManager.collectResources(LivestockManager.getChicken());
        chickenText();
    }

    public void milkPress(View v){
        LivestockManager.collectResources(LivestockManager.getCow());
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
