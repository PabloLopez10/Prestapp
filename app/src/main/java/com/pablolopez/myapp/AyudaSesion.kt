package com.pablolopez.myapp

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ayuda_registrarse.*
import kotlinx.android.synthetic.main.activity_ayuda_sesion.*

class AyudaSesion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayuda_sesion)
        setSupportActionBar(findViewById(R.id.toolbarAyudaSesion))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbarAyudaSesion.setTitle("PRESTAPP")
        toolbarAyudaSesion.setTitleMargin(250,0,0,0)
        toolbarAyudaSesion.setTitleTextColor(Color.WHITE)
    }
}
