package com.pablolopez.myapp

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.database.FirebaseDatabase
import com.pablolopez.myapp.R.id.toolbarNotificacion
import kotlinx.android.synthetic.main.activity_inicio.*
import kotlinx.android.synthetic.main.activity_notificacion.*

class Notificacion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notificacion)
        setSupportActionBar(findViewById(R.id.toolbarNotificacion))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val dbPrestamos = FirebaseDatabase.getInstance().getReference("Prestamo")
        val id = intent.getStringExtra("Id")
        val nombre = intent.getStringExtra("Nombre2")
        val estado = intent.getStringExtra("Estado")
        val tipo = intent.getStringExtra("Tipo")
        val short = intent.getStringExtra("Short")
        val botonTerminar = findViewById<Button>(R.id.Terminar)
        val txtEstado = findViewById<TextView>(R.id.Estado)



        if(estado.equals("Activo")){
            txtEstado.setText(estado)
            txtEstado.setTextColor(Color.RED)
            botonTerminar.visibility = Button.VISIBLE
        }
        if(estado.equals("Terminado")){
            txtEstado.setText(estado)
            txtEstado.setTextColor(Color.BLACK)

            botonTerminar.visibility = Button.INVISIBLE
        }

        toolbarNotificacion.setTitle("PRESTAPP")
        toolbarNotificacion.setTitleMargin(250,0,0,0)
        toolbarNotificacion.setTitleTextColor(Color.WHITE)
        val prestamo = Prestamo(id,nombre,tipo,short,estado)
        botonTerminar.setOnClickListener(){
            val prestamo = Prestamo(id,nombre,tipo,short,"Terminado")
            dbPrestamos.child(id).setValue(prestamo)
            txtEstado.setText("Terminado")
            txtEstado.setTextColor(Color.BLACK)
            botonTerminar.visibility = Button.INVISIBLE

        }

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
