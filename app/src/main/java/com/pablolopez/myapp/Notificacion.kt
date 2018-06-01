package com.pablolopez.myapp

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.pablolopez.myapp.R.id.toolbarNotificacion
import kotlinx.android.synthetic.main.activity_inicio.*
import kotlinx.android.synthetic.main.activity_notificacion.*

class Notificacion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notificacion)
        setSupportActionBar(findViewById(R.id.toolbarNotificacion))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val estado = intent.getStringExtra("Estado")
        val botonTerminar = findViewById<Button>(R.id.Terminar)
        val txtEstado = findViewById<TextView>(R.id.Estado)

        if(estado.equals("Activo")){
            txtEstado.setText(estado)
            txtEstado.setTextColor(Color.RED)
            botonTerminar.visibility = Button.VISIBLE
        }
        if(estado.equals("Terminado")){
            txtEstado.setText(estado)
            txtEstado.setTextColor(Color.WHITE)
            botonTerminar.visibility = Button.INVISIBLE
        }

        toolbarNotificacion.setTitle("PRESTAPP")
        toolbarNotificacion.setTitleMargin(250,0,0,0)
        toolbarNotificacion.setTitleTextColor(Color.WHITE)

        val descripcionNot = findViewById<TextView>(R.id.DescripcionNotificacion)
        val texto:String = intent.getStringExtra("Nombre")

        val mostrarTipo = findViewById<TextView>(R.id.mostrarPrestamo)
        val texto2:String = intent.getStringExtra("Tipo")

        if(texto != null){
            descripcionNot.setText(texto)
            mostrarTipo.setText(texto2)
        }
    }
}
