package com.taller5.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class Menu extends AppCompatActivity {
    TextView menu;
    RequestQueue requestQueue;
    private static final String BASE_URL = "http://localhost:8080/consultarAll";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        requestQueue = Volley.newRequestQueue(this);
        //UI
        initUi();
        //Rest
        stringRequest();
    }

    private void initUi(){
        menu = findViewById(R.id.menu);
    }

    private void stringRequest(){
        StringRequest request = new StringRequest(
                Request.Method.GET, BASE_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                    menu.setText(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        requestQueue.add(request);
    }
}