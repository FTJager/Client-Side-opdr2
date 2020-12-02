package com.example.clientsideopdracht2;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Makes an instance of the HUE_Lamp
 */
public class HUE_Lamp {
    private final static String log = HUE_Lamp.class.getSimpleName();

    private int ModelId;

    private Boolean on;
    private Integer bri;
    private Integer hue;
    private Integer sat;
    private String effect;
    private List<Double> xy = null;
    private Integer ct;
    private String alert;
    private String colormode;
    private String mode;
    private Boolean reachable;

    public HUE_Lamp(JSONObject jsonObject) {
        try {
            this.ModelId = jsonObject.getInt("modelid");

            this.on = jsonObject.getBoolean("on");
            this.bri = jsonObject.getInt("bri");
            this.hue = jsonObject.getInt("hue");
            this.sat = jsonObject.getInt("sat");
            this.effect = jsonObject.getString("effect");
            this.xy = null;
            this.ct = jsonObject.getInt("ct");
            this.alert = jsonObject.getString("alert");
            this.colormode = jsonObject.getString("colormode");
            this.mode = jsonObject.getString("mode");
            this.reachable = jsonObject.getBoolean("reachable");
        } catch (JSONException exception) {
            Log.e(log, "Error with Json");
            exception.printStackTrace();
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

    public String getMode() {
        return mode;
    }

    public Boolean getReachable() {
        return reachable;
    }
}
