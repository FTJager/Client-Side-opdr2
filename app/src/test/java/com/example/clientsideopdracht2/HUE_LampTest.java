package com.example.clientsideopdracht2;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class HUE_LampTest {

    @Mock
    JSONObject lampJSON = Mockito.mock(JSONObject.class);
    JSONObject stateJSON = Mockito.mock(JSONObject.class);

    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    @BeforeEach
    void setUp() {
        try {
            Map<String, Object> stateMap = new HashMap<>();

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
        //final HUE_Lamp lamp = new HUE_Lamp(lampJSON, 2);
        HUE_Lamp lamp = Mockito.mock(HUE_Lamp.class);

        when(lamp.getId()).thenCallRealMethod();

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