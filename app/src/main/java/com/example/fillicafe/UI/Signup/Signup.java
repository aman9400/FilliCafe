package com.example.fillicafe.UI.Signup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.fillicafe.Api.ApiBaseClass;
import com.example.fillicafe.R;
import com.example.fillicafe.UI.Login.Login;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Signup extends AppCompatActivity {

    TextView sign_login;
    Button btn_create_account;
    EditText dign_pass, sign_mobile, sign_email, sign_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        findIds();

        btn_create_account.setOnClickListener(v -> {
            if(dign_pass.getText().toString().isEmpty() && sign_mobile.getText().toString().isEmpty()
            && sign_email.getText().toString().isEmpty() && sign_name.getText().toString().isEmpty()){
                Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show();
            }else {

                
                signupApi();
            }
        });

        sign_login.setOnClickListener(v -> {
            startActivity(new Intent(Signup.this, Login.class));
        });

    }

    private void signupApi() {

        String url = ApiBaseClass.signup;

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, response -> {
            try {
                JSONObject jsonObject = new JSONObject(response);
                String string = jsonObject.getString("success");

                if(string.equalsIgnoreCase("0")){
                    Toast.makeText(this, ""+jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                }else {
                    startActivity(new Intent(Signup.this, Login.class));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, error -> {
            Toast.makeText(this, ""+error, Toast.LENGTH_SHORT).show();
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("registration","1");
                map.put("first_name",sign_name.getText().toString());
                map.put("mobile",sign_mobile.getText().toString());
                map.put("email",sign_email.getText().toString());
                map.put("password",dign_pass.getText().toString());
                map.put("device_token","1122334");
                map.put("device_type","1");
                return map;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("Content-Type","application/x-www-form-urlencoded");
                map.put("Content-Length","<calculated when request is sent>");
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void findIds() {
        sign_login = findViewById(R.id.sign_login);
        btn_create_account = findViewById(R.id.btn_create_account);
        sign_mobile = findViewById(R.id.sign_mobile);
        dign_pass = findViewById(R.id.dign_pass);
        sign_email = findViewById(R.id.sign_email);
        sign_name = findViewById(R.id.sign_name);

    }
}

/*private void signupApi() {

        String url = ApiBaseClass.signup;

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, response -> {
            try {
                JSONObject jsonObject = new JSONObject(response);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, error -> {
            Toast.makeText(this, ""+error, Toast.LENGTH_SHORT).show();
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("","");
                return map;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("","");
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }*/