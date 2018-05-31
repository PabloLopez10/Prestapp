package com.pablolopez.myapp

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ayuda_registrarse.*
import kotlinx.android.synthetic.main.activity_notificacion.*

class AyudaRegistrarse : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayuda_registrarse)
        setSupportActionBar(findViewById(R.id.toolbarAyudaRegistrarse))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbarAyudaRegistrarse.setTitle("PRESTAPP")
        toolbarAyudaRegistrarse.setTitleMargin(250,0,0,0)
        toolbarAyudaRegistrarse.setTitleTextColor(Color.WHITE)
    }
}
