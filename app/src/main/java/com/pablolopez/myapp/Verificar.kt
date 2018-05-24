package com.pablolopez.myapp

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_nuevo_prestamo.*
import kotlinx.android.synthetic.main.activity_verificar.*

class Verificar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verificar)
        setSupportActionBar(findViewById(R.id.toolbarVerificar))

        toolbarVerificar.setTitle("PRESTAPP")
        toolbarVerificar.setTitleMargin(415,0,0,0)
        toolbarVerificar.setTitleTextColor(Color.WHITE)

        val botonRechazar = findViewById<Button>(R.id.buttonRechazar)
        botonRechazar.setOnClickListener(){
            val intent = Intent(this,NuevoPrestamo::class.java)
            startActivity(intent)
        }

        val botonAceptar = findViewById<Button>(R.id.buttonAceptar)
        botonAceptar.setOnClickListener(){
            val intent = Intent(this,Inicio::class.java)
            startActivity(intent)
        }
    }
}
