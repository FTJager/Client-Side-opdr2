package com.example.clientsideopdracht2.Logic;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.clientsideopdracht2.HUE_Lamp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
        final String url = "http://localhost:8000/api/newdeveloper/lights";

        final JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(tag, "Volley Response: " + response.toString());

                        try {
                            JSONArray JsonLamps = response.getJSONArray(""); // looking for which name to get.

                            for (int i = 0; i < JsonLamps.length(); i++) {
                                HUE_Lamp lamp = new HUE_Lamp(JsonLamps.getJSONObject(i));
                                listener.onHUEAvailable(lamp);
                            }

                        } catch (JSONException exception) {
                            exception.getMessage();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(tag, error.getLocalizedMessage());
                        listener.onHUEError(new Error(error.getLocalizedMessage()));
                    }
                }
        );
        this.queue.add(request);
    }
}
