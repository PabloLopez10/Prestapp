package com.pablolopez.myapp

import android.content.Intent
import android.graphics.Color.WHITE
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_registro.*

class Registro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        setSupportActionBar(findViewById(R.id.my_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        my_toolbar.setTitle("PRESTAPP")
        my_toolbar.setTitleMargin(250,0,0,0)
        my_toolbar.setTitleTextColor(WHITE)

        val botonCrear = findViewById<Button>(R.id.button)
        botonCrear.setOnClickListener(){
            val intent = Intent(this,Inicio::class.java)
            startActivity(intent)
        }

        val txtRes : TextView = findViewById(R.id.textView2)
        txtRes.setText("Crear Cuenta")
    }

}
