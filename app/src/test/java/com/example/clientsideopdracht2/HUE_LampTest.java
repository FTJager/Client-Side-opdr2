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
    JSONObject stateJSON = Mockito.mock(JSONObject.class);

    @BeforeEach
    void setUp() {
        try {
            stateJSON.put("on", false);
            stateJSON.put("bri", 1);
            stateJSON.put("hue", 10000);
            stateJSON.put("sat", 254);
            stateJSON.put("effect", "none");
            stateJSON.put("ct", 159);
            stateJSON.put("alert", "none");
            stateJSON.put("colormode", "xy");
            stateJSON.put("reachable", true);
            State state = new State(stateJSON);
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
        assertEquals(2, lamp.getId());
    }

    @Test
    void getName() {
        final HUE_Lamp lamp = new HUE_Lamp(lampJSON, 2);
        assertEquals("Hue color lamp 1", lamp.getName());
    }

    @Test
    void getState() {
        final HUE_Lamp lamp = new HUE_Lamp(lampJSON, 2);
        assertEquals(stateJSON, lamp.getState());
    }
}