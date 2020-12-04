package com.example.clientsideopdracht2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class HUE_LampTest {
    JSONObject lampJSON = Mockito.mock(JSONObject.class);
    JSONObject state = Mockito.mock(JSONObject.class);

    @BeforeEach
    void setUp() {
        try {
            state.put("on", false);
            state.put("bri", 1);
            state.put("hue", 10000);
            state.put("sat", 254);
            state.put("effect", "none");
            state.put("ct", 159);
            state.put("alert", "none");
            state.put("colormode", "xy");
            state.put("reachable", true);
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