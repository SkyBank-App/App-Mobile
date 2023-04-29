package com.example.skybank

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

lateinit var edtDUIL: EditText
lateinit var edtPINL:EditText
lateinit var btnLogL: Button
lateinit var btnRegisL: Button

class LogIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        edtDUIL = findViewById(R.id.edtDuiL)
        edtPINL = findViewById(R.id.edtPinL)
        btnLogL = findViewById(R.id.btnloginL)
        btnRegisL = findViewById(R.id.btnRegistrarseL)
        btnLogL.setOnClickListener {
            if (edtDUIL.text.isEmpty()) {
                edtDUIL.error = "Ingrese su numero de DUI"
            }
            else if (edtPINL.text.isEmpty()){
                edtPINL.error = "Ingrese su PIN"
            } else {
                val open: Intent = Intent(this, MenuCajero::class.java)
                startActivity(open)
            }
        }
        btnRegisL.setOnClickListener {
            val open: Intent = Intent(this, Registrarse::class.java)
            startActivity(open)
        }
    }
}