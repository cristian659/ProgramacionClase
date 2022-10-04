package com.taller5.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {
    Button  enviar;
    TextView forgot;
    TextView usuario;
    TextView password;
    RequestQueue requestQueue;

    private static final String BASE_URL = "http://localhost:8080/consultarAll";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        forgot = (TextView) findViewById(R.id.forgot);
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, LostAccount.class);
                startActivity(i);
            }
        });

        enviar = (Button) findViewById(R.id.submit);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 stringRequest();
            }
        });


    }
    private void stringRequest(){
        usuario = (EditText) findViewById(R.id.editTextTextPersonName);
        password = (EditText) findViewById(R.id.editTextTextPersonName2);

        JsonArrayRequest request= new JsonArrayRequest(Request.Method.GET, BASE_URL, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        int size = response.length();
                        for(int  i = 0; i< size; i++){
                            try {
                                JSONObject jsonObject = new JSONObject(response.get(i).toString());
                                String email = jsonObject.getString("email");

                                if(usuario.equals(email)){

                                enviar = (Button) findViewById(R.id.submit);
                                enviar.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent i = new Intent(MainActivity.this, Menu.class);
                                        startActivity(i);
                                    }
                                });
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
// Add the request to the RequestQueue.
        requestQueue.add(request);
    }
}