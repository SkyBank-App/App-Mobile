package com.example.skybank

import android.app.DatePickerDialog
import android.content.Intent
import android.content.pm.ActivityInfo
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.*
import kotlin.properties.Delegates

lateinit var txDUIR:EditText
lateinit var txNacimientoR:EditText
lateinit var txNombreR:EditText
lateinit var txMailR:EditText
lateinit var txTelefonoR:EditText
lateinit var txPINR:EditText
lateinit var btnregsR:Button

var dia by Delegates.notNull<Int>()
var mes by Delegates.notNull<Int>()
var ano by Delegates.notNull<Int>()

class Registrarse : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrarse)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        txDUIR = findViewById(R.id.edtDUIR)
        txMailR = findViewById(R.id.edtMailR)
        txPINR = findViewById(R.id.edtPINR)
        txNombreR = findViewById(R.id.edtNombreR)
        txNacimientoR = findViewById(R.id.edtFechaNacimientoR)
        txNacimientoR.setOnClickListener(this)
        txTelefonoR = findViewById(R.id.edtTelefonoR)
        txTelefonoR.setText("+503 ")
        btnregsR = findViewById(R.id.btnRegistrarseR)
        btnregsR.setOnClickListener {
            if (txNombreR.text.isEmpty()){
                txNombreR.error = "Ingrese su nombre completo"
            } else if (txNacimientoR.text.isEmpty()){
                txNacimientoR.error = "Ingrese su fecha de nacimiento"
            }else if (txDUIR.text.isEmpty()){
                txDUIR.error = "Ingrese su DUI"
            }else if (txMailR.text.isEmpty()){
                txMailR.error = "Ingrese su correo electronico"
            }else if (txTelefonoR.text.isEmpty()){
                txTelefonoR.error = "Ingrese su numero de telefono"
            }else if (txPINR.text.isEmpty()){
                txPINR.error = "Ingrese su PIN de Seguridad"
            }else{
                Toast.makeText(this, "Usuario registrado con Exito", Toast.LENGTH_SHORT)
                val open: Intent = Intent(this, LogIn::class.java)
                startActivity(open)
            }
        }
    }
    override fun onClick(v: View) {
        if (v == txNacimientoR) {
            val c = Calendar.getInstance()
            dia = c.get(Calendar.DAY_OF_MONTH)
            mes = c.get(Calendar.MONTH)
            ano = c.get(Calendar.YEAR)
            val datePickerDialog = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                    txNacimientoR.setText("$dayOfMonth/${month + 1}/$year")
                },
                dia,
                mes,
                ano
            )
            datePickerDialog.show()
        }
    }
}


