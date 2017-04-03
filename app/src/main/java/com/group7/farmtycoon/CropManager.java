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

    private Random rdm = new Random();
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


    public static void update(){
       /* if(weather == tornado){
            for (HashMap.Entry<String, Crop> e : crops.entrySet()){
                if(!e.tornadeSafe()){      //All crops except safe ones get killed randomly
                    int dmg  = rdm.nextInt(e.getValue().getQuantity()+1);   //random amount of crops dying if choosen to die
                    sendLogMessage("The Tornado caused " + dmg +" " +e.getKey() + " to die");
                    e.getValue().destroy(dmg);
                }
            }
        }
        else if (Weather == Rain){
             for (HashMap.Entry<String, Crop> e : crops.entrySet()){
                e.getValue().water();
                sendLogMessage("The Rain watered all the Crops");
             }
        }
        else if( Weather ==Drought){
             for (HashMap.Entry<String, Crop> e : crops.entrySet()){
                if(!e.droughtSafe()){
                    int dmg = rdm.nextInt(e.getValue().getLife()+1);
                    endLogMessage("The Drought caused "+ e.getKey() + " to take damage.");
                    e.getValue().takeDamage(dmg);
                }
             }
        }*/

        for (HashMap.Entry<String, Crop> e : crops.entrySet()){
            e.getValue().update();
            if(e.getValue().expired()){
                e.getValue().killAll();
                sendLogMessage(e.getKey() + " is expired and has died.");
            }
            if(e.getValue().getQuantity() <= 0){
                sendLogMessage(e.getKey() + " has died.");
            }
        }
        //on update send view updates
        //view.update(crops);
    }
    //water all crops
    public static void waterCrops(){
        for (HashMap.Entry<String, Crop> e : crops.entrySet()){
            e.getValue().water();
            //view.update(crops);
            sendLogMessage(e.getKey()  + " has been watered.");

        }
    }

    //harvest all avalaible crops
    public static void harvestCrops(){
        for (HashMap.Entry<String, Crop> e : crops.entrySet()){
            Crop crop = e.getValue();
            if(crop.isHarvestabled()){
                crop.harvest();
                //view.update(crops);
                sendLogMessage(crop.getQuantity() + " " + e.getKey()  + " has just been harvested.");
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
        sendLogMessage(type + " has been cleared");

    }

    //plant certain type of crop amount many times
    public static void plantCrops(String type, int amount){
        crops.get(type).plant(amount);
        //view.update(crops);
        sendLogMessage(amount + " " + type + " has been planted");
        Log.d("plantCrop", type+" has been planted");
    }

    public static void fertilizeCrop(String type){
        crops.get(type).fertilize();
    }

    //destroy certain amount of crops
    public static void destroyCrops(String type, int amount){
        crops.get(type).destroy(amount);
        //view.update(crops);
        sendLogMessage(amount + " " + type + " has been killed");
        Log.d("clearCrop", type+" has been cleared");
    }

    //used to send log messages
    private static void sendLogMessage(String msg){
        //gamestate.addMessage(msg)
    }

    //called when plant or clear is called
    public static void updateView(){
        //view.updateInterface();
    }

    //used by view to change
    public static void setPlantOrKill(boolean status){ plantOrKill =status;}

    public static boolean plantOrKill(){ return plantOrKill; }
}
