package com.pablolopez.myapp

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ayuda_cerrar.*
import kotlinx.android.synthetic.main.activity_ayuda_confirmar.*

class AyudaCerrar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayuda_cerrar)
        setSupportActionBar(findViewById(R.id.toolbarAyudaCerrar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbarAyudaCerrar.setTitle("PRESTAPP")
        toolbarAyudaCerrar.setTitleMargin(250,0,0,0)
        toolbarAyudaCerrar.setTitleTextColor(Color.WHITE)
    }
}
