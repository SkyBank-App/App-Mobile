package com.example.skybank

import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.FillEventHistory
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.skybank.ui.home.HomeFragment

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

            val cajitaDui = edtDUIL.text.toString()
            val cajitaPin = edtPINL.text.toString()
            val fragment = HomeFragment()

            if (cajitaDui == "1234" && cajitaPin == "191919"){
                supportFragmentManager.beginTransaction()
                    .replace(R.id.idFragUser, Fragment())
                    .addToBackStack(null)
                    .commit()

                //val open: Intent= Intent(this,MenuCajero::class.java )
                //startActivity(open)
            }
            else{
                Toast.makeText(applicationContext, "Datos incorrectos", Toast.LENGTH_SHORT).show()
            }

        }
        btnRegisL.setOnClickListener {

            val open: Intent = Intent(this, Registrarse::class.java)
            startActivity(open)
        }


    }


}