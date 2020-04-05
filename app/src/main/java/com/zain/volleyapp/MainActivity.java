package com.zain.volleyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity{
    private RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      // requestQueue = Volley.newRequestQueue(this.getApplicationContext());
        requestQueue = Volley.newRequestQueue(this.getApplicationContext());
        String url = "https://jsonplaceholder.typicode.com/users/1";

//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            Toast.makeText(MainActivity.this, "" + response, Toast.LENGTH_SHORT).show();
//                            Log.d("JSON OBJECT", "onResponse: " + "JSON OBJECT" + response.getString("name"));
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                       //     Toast.makeText(MainActivity.this, "" + e, Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.d("JSON OBJECT ERROR", "onResponse: " + "JSON OBJECT" + error);
//                Toast.makeText(MainActivity.this, "onErrorResponse " + error.getMessage(), Toast.LENGTH_LONG).show();
//            }
//        });
//        requestQueue.add(jsonObjectRequest);

//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
//                url , null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try {
//                    Log.d("jsonObject", "onResponse: " + "Name:" + response.getString("name") + " Website: " + response.getString("website"));
//                    Toast.makeText(MainActivity.this, "Name:" + response.getString("name") + " Website: " + response.getString("website"), Toast.LENGTH_SHORT).show();
//                    Toast.makeText(MainActivity.this, "Name: " + response.get("name") + "\n Website: " + response.getString("website"), Toast.LENGTH_LONG).show();
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                    Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(MainActivity.this, "" + error.getMessage(), Toast.LENGTH_SHORT).show();
//                Log.d("VolleyError", "onErrorResponse: " + error.getMessage());
//
//            }
//        });
//        requestQueue.add(jsonObjectRequest);

        JsonArrayRequest  jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, "https://jsonplaceholder.typicode.com/todos", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++){
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                Toast.makeText(MainActivity.this, "" + jsonObject.getString("date") , Toast.LENGTH_SHORT).show();
                                Log.d("Json Array", "onResponse: " + jsonObject.getString("date"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error Array", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonArrayRequest);
    }
}
