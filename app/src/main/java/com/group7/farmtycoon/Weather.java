package com.group7.farmtycoon;

/**
 * Created by Sebas on 2017-04-02.
 */

public abstract class Weather {
    private boolean state;
    private int duration;

    public Weather(){
        this.state = true;
        this.duration = 0;
    }

    public boolean getState() {
        return state;
    }
    public void setState(boolean state) {
        this.state = state;
    }

    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }

}
