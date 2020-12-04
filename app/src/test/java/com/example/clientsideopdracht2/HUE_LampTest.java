package com.example.clientsideopdracht2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HUE_LampTest {
    JSONObject lampJSON = new JSONObject();
    JSONObject state = new JSONObject();

    @BeforeEach
    void setUp() {
        try {
            state.put("on", false);
            state.put("bri", false);
            state.put("hue", false);
            state.put("sat", false);
            state.put("effect", false);
            state.put("ct", false);
            state.put("alert", false);
            state.put("colormode", false);
            state.put("reachable", false);
            lampJSON.put("state", state);
            lampJSON.put("modelid", "LCT007");
            lampJSON.put("name", "Hue color lamp 1");
        }catch (JSONException exception){
            exception.printStackTrace();
        }
    }

    @Test
    void getId() {
        final HUE_Lamp lamp = new HUE_Lamp(lampJSON, 2);
        assertEquals(2, 2);
    }

    @Test
    void getName() {
        final HUE_Lamp lamp = new HUE_Lamp(lampJSON, 2);
        assertEquals("Hue color lamp 1", lamp.getName());
    }

    @Test
    void getState() {
        final HUE_Lamp lamp = new HUE_Lamp(lampJSON, 2);
        assertEquals(state, lamp.getState());
    }
}