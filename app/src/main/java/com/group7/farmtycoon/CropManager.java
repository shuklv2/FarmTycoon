package com.group7.farmtycoon;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Michael on 2017-03-31.
 */

public class CropManager {

    private Pumpkin pumpkin;
    private Corn corn;
    private Potato potato;
    private Strawberry strawberry;

    //private ArrayList<Crop> crops;

    private Map<String,Crop> crops;

    private boolean choosingPlant=false;
    private boolean plantOrKill=true;   //if choosingplant is true, this determines if a crop is being chosen to be destroyed or planted


    //private CropView view;

    public CropManager(){
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


    public void update(){
        for (HashMap.Entry<String, Crop> e : crops.entrySet()){
            e.getValue().update();
            if(e.getValue().expired()){
                e.getValue().killAll();
                sendLogMessage(e.getKey() + " is expired and has died.");
            }
        }
        //on update send view updates
        //view.update(crops);
    }
    //water all crops
    public void waterCrops(){
        for (HashMap.Entry<String, Crop> e : crops.entrySet()){
            e.getValue().water();
            //view.update(crops);
            sendLogMessage(e.getKey()  + " has been watered.");

        }
    }

    //harvest all avalaible crops
    public void harvestCrops(){
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
    public void clearAll(){
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
    public void plantCrops(String type, int amount){
        crops.get(type).plant(amount);
        //view.update(crops);
        sendLogMessage(amount + " " + type + " has been planted");
    }

    public void fertilizeCrop(String type){
        crops.get(type).fertilize();
    }

    //destroy certain amount of crops
    public void destroyCrops(String type, int amount){
        crops.get(type).destroy(amount);
        //view.update(crops);
        sendLogMessage(amount + " " + type + " has been killed");
    }

    //used to send log messages
    private void sendLogMessage(String msg){
        //gamestate.addMessage(msg)
    }

    //called when plant or clear is called
    public void updateView(){
        //view.updateInterface();
    }

    //used by view to change
    public void setChoosingPlant(boolean status){ choosingPlant =status;}
}
