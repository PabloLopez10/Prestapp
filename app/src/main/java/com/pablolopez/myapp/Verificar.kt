package com.pablolopez.myapp

import SaveArrayListToSD
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_nuevo_prestamo.*
import kotlinx.android.synthetic.main.activity_verificar.*

class Verificar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verificar)
        setSupportActionBar(findViewById(R.id.toolbarVerificar))

        val contrato = findViewById<TextView>(R.id.VerifyText)

        val contractText = intent.getStringExtra("STRING_PASS")
        val prestamoType = intent.getStringExtra("STRING_TYPE")
        val notiShowtoPass = intent.getStringExtra("STRING_NOTI")

        contrato.setText(contractText)
        toolbarVerificar.setTitle("PRESTAPP")
        toolbarVerificar.setTitleMargin(410,0,0,0)
        toolbarVerificar.setTitleTextColor(Color.WHITE)

        val botonRechazar = findViewById<Button>(R.id.buttonRechazar)
        botonRechazar.setOnClickListener(){
            val intent = Intent(this,NuevoPrestamo::class.java)
            startActivity(intent)
        }

        val botonAceptar = findViewById<Button>(R.id.buttonAceptar)
        botonAceptar.setOnClickListener(){


            val intent = Intent(this,Inicio::class.java)
            guardarPrestamo(prestamoType,contractText,notiShowtoPass)
            startActivity(intent)

        }
    }

    private fun guardarPrestamo(pt:String,ct:String, noti:String) {
        val ref = FirebaseDatabase.getInstance().getReference("Prestamo")
        val prestamoId = ref.push().key
        val prestamo = Prestamo(prestamoId, pt , ct, noti,"Activo")
        ref.child(prestamoId).setValue(prestamo).addOnCompleteListener {
            Toast.makeText(applicationContext, "Prestamo creado con exito", Toast.LENGTH_LONG).show()
        }
    }
}