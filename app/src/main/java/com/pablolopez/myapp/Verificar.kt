package com.pablolopez.myapp

import SaveArrayListToSD
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_nuevo_prestamo.*
import kotlinx.android.synthetic.main.activity_verificar.*

class Verificar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verificar)
        setSupportActionBar(findViewById(R.id.toolbarVerificar))

        val contrato = findViewById<TextView>(R.id.VerifyText)

        val contractText = intent.getStringExtra("STRING_PASS")
        val prestamoType = intent.getStringExtra("STRING_TYPE")
        val notiShowtoPass = intent.getStringExtra("STRING_NOTI")

        contrato.setText(contractText)
        toolbarVerificar.setTitle("PRESTAPP")
        toolbarVerificar.setTitleMargin(410,0,0,0)
        toolbarVerificar.setTitleTextColor(Color.WHITE)

        val botonRechazar = findViewById<Button>(R.id.buttonRechazar)
        botonRechazar.setOnClickListener(){
            val intent = Intent(this,NuevoPrestamo::class.java)
            startActivity(intent)
        }

        val botonAceptar = findViewById<Button>(R.id.buttonAceptar)
        botonAceptar.setOnClickListener(){


            val intent = Intent(this,Inicio::class.java)
            intent.putExtra("PRESTAMO", prestamoType)
            intent.putExtra("DESCRIPCION", contractText)
            intent.putExtra("SHOW", notiShowtoPass)
            startActivity(intent)

        }
    }
}
