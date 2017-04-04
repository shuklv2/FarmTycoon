package com.group7.farmtycoon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LivestockMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livestock_menu);
    }

    public void feedChickenPress(View v){
        LivestockManager.feed(LivestockManager.getChicken());
    }

    public void feedCowPress(View v){
        LivestockManager.feed(LivestockManager.getCow());
    }

    public void feedPigPress(View v){
        LivestockManager.feed(LivestockManager.getPig());
    }

    public void butcherChickenPress(View v){
        LivestockManager.butcher(LivestockManager.getChicken());
    }

    public void butcherCowPress(View v){
        LivestockManager.butcher(LivestockManager.getCow());
    }

    public void butcherPigPress(View v){
        LivestockManager.butcher(LivestockManager.getPig());
    }

    public void breedChicken(View v){
        LivestockManager.breed(LivestockManager.getChicken());
    }

    public void breedCow(View v){
        LivestockManager.breed(LivestockManager.getCow());
    }

    public void breedPig(View v){
        LivestockManager.breed(LivestockManager.getPig());
    }

    public void buyChicken(View v){
        LivestockManager.buy(LivestockManager.getChicken());
    }

    public void buyCow(View v){
        LivestockManager.buy(LivestockManager.getCow());
    }

    public void buyPig(View v){
        LivestockManager.buy(LivestockManager.getPig());
    }

    public void eggsPress(View v){
        LivestockManager.collectResources(LivestockManager.getChicken());
    }

    public void milkPress(View v){
        LivestockManager.collectResources(LivestockManager.getCow());
    }


}
