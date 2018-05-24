package com.pablolopez.myapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val usuario:EditText = findViewById(R.id.Correo)
        val contra:EditText = findViewById(R.id.Contraseña)
        val listUsuarios = arrayListOf<String>(
                "pj9lopez@hotmail.com","lop14509@uvg.edu.gt"
        )

        val listContra = arrayListOf<String>(
                "123","456"
        )

        val registro : Button = findViewById(R.id.Registrarse)
        registro.setOnClickListener {
            val intent = Intent(this, Registro :: class.java)
            startActivity(intent)
        }
        val botonInicio = findViewById<Button>(R.id.Inicio_sesion)
        botonInicio.setOnClickListener(){
            if(usuario.getText().toString() in listUsuarios && contra.getText().toString() in listContra){
                if(listUsuarios.indexOf(usuario.getText().toString()) == listContra.indexOf(contra.getText().toString())){
                    val intent = Intent(this,Inicio::class.java)
                    startActivity(intent)
                }
                else{
                    val builder = AlertDialog.Builder(this@MainActivity)

                    // Set the alert dialog title
                    builder.setTitle("Inicio Sesion")

                    // Display a message on alert dialog
                    builder.setMessage("Usuario o contraseña incorrectos")

                    // Display a neutral button on alert dialog
                    builder.setNeutralButton("Ok"){_,_ ->

                    }

                    // Finally, make the alert dialog using builder
                    val dialog: AlertDialog = builder.create()

                    // Display the alert dialog on app interface
                    dialog.show()
                }
            }
            else{
                val builder = AlertDialog.Builder(this@MainActivity)

                // Set the alert dialog title
                builder.setTitle("Inicio Sesion")

                // Display a message on alert dialog
                builder.setMessage("Usuario o contraseña incorrectos")

                // Display a neutral button on alert dialog
                builder.setNeutralButton("Ok"){_,_ ->

                }

                // Finally, make the alert dialog using builder
                val dialog: AlertDialog = builder.create()

                // Display the alert dialog on app interface
                dialog.show()
            }


        }

    }

}
