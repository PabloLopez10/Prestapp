package com.pablolopez.myapp

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_inicio.*
import kotlinx.android.synthetic.main.activity_notificacion.*

class Notificacion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notificacion)
        setSupportActionBar(findViewById(R.id.toolbarNotificacion))

        toolbarNotificacion.setTitle("PRESTAPP")
        toolbarNotificacion.setTitleMargin(415,0,0,0)
        toolbarNotificacion.setTitleTextColor(Color.WHITE)

        val descripcionNot = findViewById<TextView>(R.id.DescripcionNotificacion)
        val texto:String = intent.getStringExtra("Descripcion")
        if(texto != null){
            descripcionNot.setText(texto)
        }
    }
}
