package com.group7.farmtycoon;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Michael on 2017-03-31.
 */

public class CropManager {

    private static Pumpkin pumpkin;
    private static Corn corn;
    private static Potato potato;
    private static Strawberry strawberry;

    private static Random rdm = new Random();
    //private ArrayList<Crop> crops;

    private static Map<String,Crop> crops;

    private static boolean plantOrKill=true;   //if choosingplant is true, this determines if a crop is being chosen to be destroyed or planted


    //private CropView view;

    public static void init(){
        pumpkin = new Pumpkin();
        corn = new Corn();
        potato = new Potato();
        strawberry  = new Strawberry();
        crops = new HashMap<String,Crop>();      //0 - pumpkin, 1-corn, 2-potato, 3-strawberry
        crops.put("pumpkin", pumpkin);
        crops.put("corn", corn);
        crops.put("potato", potato);
        crops.put("strawberry",strawberry);
    }


    public static void update(WeatherManager.list weather){
        Log.d("CropManager:Update","Updated!");
        if(weather == WeatherManager.list.Tornado){
            for (HashMap.Entry<String, Crop> e : crops.entrySet()){
                if(!e.getValue().tornadoSafe()){      //All crops except safe ones get killed randomly
                    int dmg  = rdm.nextInt(e.getValue().getQuantity()+1);   //random amount of crops dying if choosen to die
                    sendLogMessage("The Tornado caused " + dmg +" " +e.getKey() + " to die");
                    e.getValue().destroy(dmg);
                }
            }
        }
        else if (weather == WeatherManager.list.Rain){
             for (HashMap.Entry<String, Crop> e : crops.entrySet()){
                e.getValue().water();
                sendLogMessage("The Rain watered all the Crops");
             }
        }
        else if( weather ==WeatherManager.list.Drought){
             for (HashMap.Entry<String, Crop> e : crops.entrySet()){
                if(!e.getValue().droughtSafe()){
                    int dmg = rdm.nextInt(e.getValue().getLife()+1);
                    sendLogMessage("The Drought caused "+ e.getKey() + " to take damage.");
                    e.getValue().takeDamage(dmg);
                }
             }
        }

        for (HashMap.Entry<String, Crop> e : crops.entrySet()){
            e.getValue().update();
            if(e.getValue().expired()){
                e.getValue().killAll();
                Log.d("CropManager",e.getKey() + " is expired and has died.");
                sendLogMessage(e.getKey() + " is expired and has died.");
            }
            if(e.getValue().getQuantity() <= 0){
                Log.d("CropManager",e.getKey() + " has died.");
                sendLogMessage(e.getKey() + " has died.");
            }
        }
        //on update send view updates
        //view.update(crops);
    }
    //water all crops
    public static void waterCrops(){
        for (HashMap.Entry<String, Crop> e : crops.entrySet()){
            if(e.getValue().getQuantity() >0){
                e.getValue().water();
            }
            //view.update(crops);
            Log.d("CropManager",e.getKey() + " has been watered.");
            sendLogMessage(e.getKey()  + " has been watered.");

        }
    }

    //harvest all avalaible crops
    public static void harvestCrops(){
        for (HashMap.Entry<String, Crop> e : crops.entrySet()){
            if(e.getValue().isHarvestabled()){

                //view.update(crops);
                Log.d("CropManager",e.getValue().getQuantity() + " " + e.getKey()  + " has just been harvested.");
                sendLogMessage(e.getValue().getQuantity() + " " + e.getKey()  + " has just been harvested.");
                e.getValue().harvest();
            }
        }
    }

    //clear all crops
    public static void clearAll(){
        for (HashMap.Entry<String, Crop> e : crops.entrySet()){
            e.getValue().killAll();
            //view.update(crops);
            sendLogMessage("All Crops cleared.");
        }
    }

    //clear only certain type of crop
    public void clearCrop(String type){
        crops.get(type).killAll();
        //view.update(crops);
        Log.d("CropManager",type + " has been cleared");
        sendLogMessage(type + " has been cleared");

    }

    //plant certain type of crop amount many times
    public static void plantCrops(String type, int amount){
        crops.get(type).plant(amount);
        //view.update(crops);
        Log.d("CropManager",amount + " " + type + " has been planted");
        sendLogMessage(amount + " " + type + " has been planted");
    }

    public static void fertilizeCrop(String type){

        crops.get(type).fertilize();
        Log.d("CropManager", type+" has been fertilized");
    }

    //destroy certain amount of crops
    public static void destroyCrops(String type, int amount){
        crops.get(type).destroy(amount);
        //view.update(crops);
        Log.d("CropManager",amount + " " + type + " has been killed");
        sendLogMessage(amount + " " + type + " has been killed");
    }

    //used to send log messages
    private static void sendLogMessage(String msg){
        //gamestate.addMessage(msg)
    }

    //called when plant or clear is called
    public static void updateView(){
        //view.updateInterface();
    }

    public static Crop getCrop(String type){
        return crops.get(type);
    }

    //used by view to change
    public static void setPlantOrKill(boolean status){ plantOrKill =status;}

    public static boolean plantOrKill(){ return plantOrKill; }
}
