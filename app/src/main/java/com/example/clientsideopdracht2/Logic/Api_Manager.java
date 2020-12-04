package com.example.clientsideopdracht2.Logic;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.clientsideopdracht2.HUE_Lamp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Api_Manager {
    private static final String tag = Api_Manager.class.getSimpleName();

    private Context context;
    private RequestQueue queue;
    private HUE_Listener listener;

    public Api_Manager(Context context, HUE_Listener listener) {
        this.context = context;
        this.listener = listener;
        this.queue = Volley.newRequestQueue(this.context);
    }

    /**
     * Gets the Json data and makes it into a Lamp object
     */
    public void getHUE_Data() {
        final String url = "http://10.0.2.2:8000/api/newdeveloper/lights";

        final JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(tag, "Volley Response: " + response.toString());

                        try {
                            JSONObject JsonLamp1 = response.getJSONObject("1");
                            HUE_Lamp lamp = new HUE_Lamp(JsonLamp1, 1);
                            listener.onHUEAvailable(lamp);

                            JSONObject JsonLamp2 = response.getJSONObject("2");
                            HUE_Lamp lamp2 = new HUE_Lamp(JsonLamp2, 2);
                            listener.onHUEAvailable(lamp2);

                            JSONObject JsonLamp3 = response.getJSONObject("3");
                            HUE_Lamp lamp3 = new HUE_Lamp(JsonLamp3, 3);
                            listener.onHUEAvailable(lamp3);

                        } catch (JSONException exception) {
                            exception.getMessage();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(tag, error.toString());
                        listener.onHUEError(new Error(error.toString()));
                    }
                }
        );
        this.queue.add(request);
    }

    public void changeOnOff(String id, Boolean status) {
        final String url = "http://10.0.2.2:8000/api/newdeveloper/lights/" + id + "/state";
        JSONObject body = new JSONObject();
        try {
            body.put("on", status);
        } catch (JSONException exception) {
            exception.printStackTrace();
        }

        final JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.PUT,
                url,
                body,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(tag, response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(tag, error.toString());
                    }
                }
        ) {
        };
        queue.add(request);
    }

    public void changeColor (String id, int hue) {
        final String url = "http://10.0.2.2:8000/api/newdeveloper/lights/" + id + "/state";
        JSONObject body = new JSONObject();
        try {
            body.put("hue", hue);
        } catch (JSONException exception) {
            exception.printStackTrace();
        }

        final JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.PUT,
                url,
                body,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(tag, response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(tag, error.toString());
                    }
                }
        ) {
        };
        queue.add(request);
    }
}
