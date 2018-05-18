package com.pablolopez.myapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val registro : Button = findViewById(R.id.Registrarse)
        registro.setOnClickListener {
            val intent = Intent(this, Registro :: class.java)
            startActivity(intent)
        }
    }
}
