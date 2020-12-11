package com.example.clientsideopdracht2;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class StateTest {
    JSONObject stateJson = Mockito.mock(JSONObject.class);

    @BeforeEach
    void setUp() {
        try {
            stateJson.put("on", false);
            stateJson.put("bri", 1);
            stateJson.put("hue", 10000);
            stateJson.put("sat", 254);
            stateJson.put("effect", "none");
            stateJson.put("ct", 159);
            stateJson.put("alert", "none");
            stateJson.put("colormode", "xy");
            stateJson.put("reachable", true);
        } catch (JSONException exception) {
            exception.printStackTrace();
        }
    }

    @Test
    void getOn() {
        State state = new State(stateJson);
        assertEquals(false, state.getOn());
    }

    @Test
    void getBri() {
        State state = new State(stateJson);
        assertEquals(1, state.getBri());
    }

    @Test
    void getHue() {
        State state = new State(stateJson);
        assertEquals(10000, state.getHue());
    }

    @Test
    void getSat() {
        State state = new State(stateJson);
        assertEquals(254, state.getSat());
    }

    @Test
    void getEffect() {
        State state = new State(stateJson);
        assertEquals("none", state.getEffect());
    }

    @Test
    void getXy() {
        State state = new State(stateJson);
        assertEquals(null, state.getXy());
    }

    @Test
    void getCt() {
        State state = new State(stateJson);
        assertEquals(159, state.getCt());
    }

    @Test
    void getAlert() {
        State state = new State(stateJson);
        assertEquals("none", state.getAlert());
    }

    @Test
    void getColormode() {
        State state = new State(stateJson);
        assertEquals("xy", state.getColormode());
    }

    @Test
    void getReachable() {
        State state = new State(stateJson);
        assertEquals(true, state.getReachable());
    }
}