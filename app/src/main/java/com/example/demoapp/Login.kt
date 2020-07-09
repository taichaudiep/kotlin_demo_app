package com.example.demoapp

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley


class Login : AppCompatActivity(), View.OnClickListener {

    private lateinit var edit_user: EditText
    private lateinit var edit_pass: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_login)

        edit_user = findViewById(R.id.edit_user)
        edit_pass = findViewById(R.id.edit_pass)
    }

    override fun onClick(v: View?) {

        val queue = Volley.newRequestQueue(this)
        val url = "https://postman-echo.com/basic-auth";

        if (edit_user.text.toString() != "" && edit_user.text.toString() != "") {

            val mStringRequest =
                object : JsonObjectRequest(Request.Method.GET, url, null,
                    Response.Listener { response ->
                        if (response["authenticated"] == true) {
                            val intent = Intent(this, List()::class.java).apply { }
                            startActivity(intent)
                        }
                        Toast.makeText(
                            applicationContext,
                            "Logged In Successfully",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }, Response.ErrorListener { error ->
                        Toast.makeText(
                            applicationContext,
                            "Please make sure you enter correct password and username",
                            Toast.LENGTH_SHORT
                        ).show()
                    }) {
                    override fun getHeaders(): MutableMap<String, String> {
                        val params = HashMap<String, String>()
                        params["Authorization"] = "Basic cG9zdG1hbjpwYXNzd29yZA=="
                        return params
                    }
                }

            queue.add(mStringRequest!!)
        }
    }
}
