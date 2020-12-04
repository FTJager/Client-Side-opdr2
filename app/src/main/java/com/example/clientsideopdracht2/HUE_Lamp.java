package com.example.clientsideopdracht2;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Makes an instance of the HUE_Lamp
 */
public class HUE_Lamp {
    private final static String tag = HUE_Lamp.class.getSimpleName();

    private String name = "lamp";
    private State state;

    public HUE_Lamp(JSONObject jsonObject) {
        try {
            this.name = jsonObject.getString("name");
            this.state = new State(jsonObject.getJSONObject("state"));
        } catch (JSONException exception) {
            Log.e(tag, "Error with Json");
            exception.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public State getState() {
        return state;
    }
}
