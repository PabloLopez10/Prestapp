package com.pablolopez.myapp

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ayuda_cerrar.*
import kotlinx.android.synthetic.main.activity_ayuda_confirmar.*
import kotlinx.android.synthetic.main.activity_ayuda_ver.*

class AyudaConfirmar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayuda_confirmar)
        setSupportActionBar(findViewById(R.id.toolbarAyudaConfirmar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbarAyudaConfirmar.setTitle("PRESTAPP")
        toolbarAyudaConfirmar.setTitleMargin(250,0,0,0)
        toolbarAyudaConfirmar.setTitleTextColor(Color.WHITE)
    }
}
