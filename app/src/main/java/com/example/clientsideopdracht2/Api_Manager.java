package com.example.clientsideopdracht2;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Api_Manager {

    private Context context;
    private RequestQueue queue;
    private HUE_Listener listener;

    public Api_Manager(Context context, HUE_Listener listener) {
        this.context = context;
        this.listener = listener;
        this.queue = Volley.newRequestQueue(this.context);
    }

    public void getHUE_Data() {
        final String url = "http://localhost:8000/api/newdeveloper/lights";

        final JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("Response", "Volley Response: " + response.toString());
                        try {
                            listener.onHUEAvailable(lamp);
                        } catch (JSONException exception) {
                            exception.getMessage();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error", error.getLocalizedMessage());
                        listener.onHUEError(new Error(error.getLocalizedMessage()));
                    }
                }
        );
        this.queue.add(request);
    }
}
