package com.example.clientsideopdracht2;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class State {
    private final static String tag = State.class.getSimpleName();

    private Boolean on;
    private Integer bri;
    private Integer hue;
    private Integer sat;
    private String effect;
    private List<Double> xy = null;
    private Integer ct;
    private String alert;
    private String colormode;
    private Boolean reachable;

    public State(JSONObject state) {

        try {
            this.xy = null;
            this.ct = state.getInt("ct");
            this.alert = state.getString("alert");
            this.sat = state.getInt("sat");
            this.effect = state.getString("effect");
            this.bri = state.getInt("bri");
            this.hue = state.getInt("hue");
            this.colormode = state.getString("colormode");
            this.reachable = state.getBoolean("reachable");
            this.on = state.getBoolean("on");
        }catch (JSONException exception){
            Log.e(tag, exception.getMessage());
        }
    }

    public Boolean getOn() {
        return on;
    }

    public Integer getBri() {
        return bri;
    }

    public Integer getHue() {
        return hue;
    }

    public Integer getSat() {
        return sat;
    }

    public String getEffect() {
        return effect;
    }

    public List<Double> getXy() {
        return xy;
    }

    public Integer getCt() {
        return ct;
    }

    public String getAlert() {
        return alert;
    }

    public String getColormode() {
        return colormode;
    }

    public Boolean getReachable() {
        return reachable;
    }
}
