package com.example.volleytools;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

//import ir.programmershouse.digikala.Activity.Main_home.Pack_sand_count.Datamodel_sandcount;

public abstract class Server {
    private Object ResultType;

    Server(Object resultType) {
        ResultType = resultType;
    }

    void JasonObjectConnect(final Context context, int method, String Url, final GetJsonObjectResult result) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(method, Url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                result.GetResult(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
            }
        });
        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(10000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        Volley.newRequestQueue(context).add(jsonObjectRequest);
    }


    void JasonArrayConnect(final Context context, int method, String Url, final GetJsonArrayResult result) {
        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(method, Url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                result.GetResult(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
            }
        });
        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(10000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        Volley.newRequestQueue(context).add(jsonObjectRequest);
    }

    public interface GetJsonObjectResult {
        void GetResult(JSONObject result);
    }

    public interface GetJsonArrayResult {
        void GetResult(JSONArray result);
    }

}
