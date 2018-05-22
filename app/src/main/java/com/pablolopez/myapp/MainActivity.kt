package com.pablolopez.myapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val registro : Button = findViewById(R.id.Registrarse)
        registro.setOnClickListener {
            val intent = Intent(this, Registro :: class.java)
            startActivity(intent)
        }
        val botonInicio = findViewById<Button>(R.id.Inicio_sesion)
        botonInicio.setOnClickListener(){
            val intent = Intent(this,Inicio::class.java)
            startActivity(intent)
        }


    }

}
