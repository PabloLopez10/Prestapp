package com.pablolopez.myapp

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_ayuda.*
import kotlinx.android.synthetic.main.activity_notificacion.*

class Ayuda : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayuda)
        setSupportActionBar(findViewById(R.id.toolbarAyuda))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbarAyuda.setTitle("PRESTAPP")
        toolbarAyuda.setTitleMargin(250,0,0,0)
        toolbarAyuda.setTitleTextColor(Color.WHITE)

        val registrarse = findViewById<TextView>(R.id.textViewRegistrarse)
        registrarse.setOnClickListener(){
            val intent = Intent(this,AyudaRegistrarse::class.java)
            startActivity(intent)
        }

        val inicio = findViewById<TextView>(R.id.textViewIniciar)
        inicio.setOnClickListener(){
            val intent = Intent(this,AyudaSesion::class.java)
            startActivity(intent)
        }

        val nuevo = findViewById<TextView>(R.id.textViewNuevoP)
        nuevo.setOnClickListener(){
            val intent = Intent(this,AyudaNuevo::class.java)
            startActivity(intent)
        }

        val ver = findViewById<TextView>(R.id.textViewVerP)
        ver.setOnClickListener(){
            val intent = Intent(this,AyudaVer::class.java)
            startActivity(intent)
        }

        val confirmar = findViewById<TextView>(R.id.textViewConfirmar)
        confirmar.setOnClickListener(){
            val intent = Intent(this,AyudaConfirmar::class.java)
            startActivity(intent)
        }

        val cerrar = findViewById<TextView>(R.id.textViewCerrar)
        cerrar.setOnClickListener(){
            val intent = Intent(this,AyudaCerrar::class.java)
            startActivity(intent)
        }
    }
}
