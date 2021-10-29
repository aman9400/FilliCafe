package com.example.fillicafe.UI.Login

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.*
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.fillicafe.Api.ApiBaseClass
import com.example.fillicafe.R
import com.example.fillicafe.UI.Dashboard.Dashboard
import com.example.fillicafe.UI.Signup.Signup
import org.json.JSONException
import org.json.JSONObject
import java.util.*

class Login : AppCompatActivity() {

    lateinit var login_forgtPass : TextView
    lateinit var login_loginBtn : TextView
    lateinit var loginPassword : EditText
    lateinit var login_email : EditText
    lateinit var login_signup : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        findIds()

        login_loginBtn.setOnClickListener {
            if(login_email.text.toString().isEmpty() && loginPassword.text.toString().isEmpty()){
                Toast.makeText(this, "Please fill all details", Toast.LENGTH_SHORT).show()
            }else{
//                startActivity(Intent(this, Dashboard::class.java))

                signin()
            }
        }

        login_signup.setOnClickListener {
            startActivity(Intent(this, Signup::class.java))


        }

        login_forgtPass.setOnClickListener {
            Toast.makeText(this, "Coming Soon...", Toast.LENGTH_SHORT).show()

//            startActivity(Intent(this, ForgotPassword::class.java))

        }

    }

    private fun findIds() {

        loginPassword = findViewById(R.id.loginPassword)
        login_forgtPass = findViewById(R.id.login_forgtPass)
        login_loginBtn = findViewById(R.id.login_loginBtn)
        login_email = findViewById(R.id.login_email)
        login_signup = findViewById(R.id.login_signup)

    }

    private fun signin() {
        val url = ApiBaseClass.login

        val stringRequest: StringRequest = object : StringRequest(
            Method.POST, url,
            Response.Listener { response: String? ->
                try {
                    val jsonObject = JSONObject(response)
                    val string = jsonObject.getString("success")
                    if (string.equals("0", ignoreCase = true)) {
                        Toast.makeText(
                            this,
                            "" + jsonObject.getString("message"),
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        startActivity(Intent(this, Dashboard::class.java))
                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            },
            Response.ErrorListener { error: VolleyError ->
                Toast.makeText(
                    this,
                    "" + error,
                    Toast.LENGTH_SHORT
                ).show()
            }) {
            @Throws(AuthFailureError::class)
            override fun getParams(): Map<String, String>? {
                val map: MutableMap<String, String> = HashMap()
                map["login"] = "1"
                map["email"] = login_email.getText().toString()
                map["phone"] = login_email.getText().toString()
                map["password"] = loginPassword.getText().toString()

                map["device_token"] = "1122334"
                map["device_type"] = "1"
                return map
            }

            @Throws(AuthFailureError::class)
            override fun getHeaders(): Map<String, String> {
                val map: MutableMap<String, String> = HashMap()
                map["Content-Type"] = "application/x-www-form-urlencoded"
                map["Content-Length"] = "<calculated when request is sent>"
                return map
            }
        }

        val requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(stringRequest)
    }
}