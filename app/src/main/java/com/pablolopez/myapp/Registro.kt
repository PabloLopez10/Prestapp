package com.pablolopez.myapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Registro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val txtRes : TextView = findViewById(R.id.titulo)
        txtRes.setText("PRESTAPP")
    }
}
