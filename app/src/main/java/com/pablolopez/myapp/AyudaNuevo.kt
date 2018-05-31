package com.pablolopez.myapp

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ayuda_sesion.*
import kotlinx.android.synthetic.main.activity_ayunda_nuevo.*

class AyudaNuevo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayunda_nuevo)
        setSupportActionBar(findViewById(R.id.toolbarAyudaNuevo))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbarAyudaNuevo.setTitle("PRESTAPP")
        toolbarAyudaNuevo.setTitleMargin(250,0,0,0)
        toolbarAyudaNuevo.setTitleTextColor(Color.WHITE)
    }
}
