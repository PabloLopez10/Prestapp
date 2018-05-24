package com.pablolopez.myapp

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_inicio.*
import kotlinx.android.synthetic.main.activity_nuevo_prestamo.*

class NuevoPrestamo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo_prestamo)
        setSupportActionBar(findViewById(R.id.toolbarNuevo))

        toolbarNuevo.setTitle("PRESTAPP")
        toolbarNuevo.setTitleMargin(415,0,0,0)
        toolbarNuevo.setTitleTextColor(Color.WHITE)

        val botonNPrestamo = findViewById<Button>(R.id.button2)
        botonNPrestamo.setOnClickListener(){
            val intent = Intent(this,Verificar::class.java)
            startActivity(intent)
        }
    }
}
