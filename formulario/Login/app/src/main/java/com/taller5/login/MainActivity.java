package com.taller5.login;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity implements  View.OnClickListener {
    Button  enviar;
    TextView forgot;
    EditText user;
    EditText password;

    RequestQueue requestQueue;
    private static final String BASE_URL = "http://localhost:8080/guardar";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        /*forgot = (TextView) findViewById(R.id.forgot);
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, LostAccount.class);
                startActivity(i);
            }
        });*/
        requestQueue = Volley.newRequestQueue(this);
        initUi();

        enviar.setOnClickListener(this);
        forgot.setOnClickListener(this);

        /*enviar = (Button) findViewById(R.id.submit);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Menu.class);
                startActivity(i);
            }
        });*/

    }

    private void initUi() {
        //entry
        user = findViewById(R.id.editTextTextPersonName);
        password = findViewById(R.id.editTextTextPersonName2);

        //buttons
        enviar = findViewById(R.id.submit);
        forgot = findViewById(R.id.forgot);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.submit){
            String email = user.getText().toString().trim();
            String pass = password.getText().toString().trim();

            createUser(email, pass);
        }else if(id == R.id.forgot){
            Intent i = new Intent(MainActivity.this, LostAccount.class);
            startActivity(i);
        }
    }

    private void createUser(String email, String pass) {
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST, BASE_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(MainActivity.this,"correct", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("email", email);
                params.put("password", pass);
                return super.getParams();
            }
        };

        requestQueue.add(stringRequest);
    }


}