package com.pablolopez.myapp

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ayuda_ver.*
import kotlinx.android.synthetic.main.activity_ayunda_nuevo.*

class AyudaVer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayuda_ver)
        setSupportActionBar(findViewById(R.id.toolbarAyudaVer))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbarAyudaVer.setTitle("PRESTAPP")
        toolbarAyudaVer.setTitleMargin(250,0,0,0)
        toolbarAyudaVer.setTitleTextColor(Color.WHITE)
    }
}
