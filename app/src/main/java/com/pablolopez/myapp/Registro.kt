package com.pablolopez.myapp

import android.content.Intent
import android.graphics.Color.WHITE
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_registro.*
import java.util.regex.Pattern

class Registro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        setSupportActionBar(findViewById(R.id.my_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        my_toolbar.setTitle("PRESTAPP")
        my_toolbar.setTitleMargin(250,0,0,0)
        my_toolbar.setTitleTextColor(WHITE)

        val usuarios = intent.getStringArrayListExtra("Correos")


        val VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE)!!
        val VALID_PHONE_NUMBER_ADDRESS_REGEX = Pattern.compile("\\d{8}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}", Pattern.CASE_INSENSITIVE)!!

        fun validMail(input: String): Boolean {
            val matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(input)
            return matcher.find()
        }

        fun validNumber(input: String): Boolean {
            val matcher = VALID_PHONE_NUMBER_ADDRESS_REGEX.matcher(input)
            return matcher.find()
        }

        val botonCrear = findViewById<Button>(R.id.button)
        botonCrear.setOnClickListener(){
            if(editText3.getText().toString() != ""  && editText4.getText().toString() != "" && editText5.getText().toString() != "" && editText6.getText().toString() != "" && editText7.getText().toString() != ""){

                if(validMail(editText4.getText().toString()) == false){
                    val builder = AlertDialog.Builder(this@Registro)

                    builder.setCancelable(false)

                    // Set the alert dialog title
                    builder.setTitle("Registro")

                    // Display a message on alert dialog
                    builder.setMessage("Correo Invalido")

                    // Display a neutral button on alert dialog
                    builder.setNeutralButton("Ok"){_,_ ->

                    }

                    // Finally, make the alert dialog using builder
                    val dialog: AlertDialog = builder.create()

                    // Display the alert dialog on app interface
                    dialog.show()
                }
                else {
                    if(editText4.getText().toString() in usuarios){
                        val builder = AlertDialog.Builder(this@Registro)

                        builder.setCancelable(false)

                        // Set the alert dialog title
                        builder.setTitle("Registro")

                        // Display a message on alert dialog
                        builder.setMessage("Correo ya esta en uso")

                        // Display a neutral button on alert dialog
                        builder.setNeutralButton("Ok"){_,_ ->

                        }

                        // Finally, make the alert dialog using builder
                        val dialog: AlertDialog = builder.create()

                        // Display the alert dialog on app interface
                        dialog.show()
                    }
                    else{
                        if(validNumber(editText5.getText().toString()) ==  false && editText5.text.toString().length == 8){
                            val builder = AlertDialog.Builder(this@Registro)

                            builder.setCancelable(false)

                            // Set the alert dialog title
                            builder.setTitle("Registro")

                            // Display a message on alert dialog
                            builder.setMessage("Telefono incorrecto")

                            // Display a neutral button on alert dialog
                            builder.setNeutralButton("Ok"){_,_ ->

                            }

                            // Finally, make the alert dialog using builder
                            val dialog: AlertDialog = builder.create()

                            // Display the alert dialog on app interface
                            dialog.show()
                        }
                        else {
                            if(editText6.getText().toString().length < 8){
                                val builder = AlertDialog.Builder(this@Registro)

                                builder.setCancelable(false)

                                // Set the alert dialog title
                                builder.setTitle("Registro")

                                // Display a message on alert dialog
                                builder.setMessage("Contraseña debe ser mayor o igual a 8 caracteres")

                                // Display a neutral button on alert dialog
                                builder.setNeutralButton("Ok"){_,_ ->

                                }

                                // Finally, make the alert dialog using builder
                                val dialog: AlertDialog = builder.create()

                                // Display the alert dialog on app interface
                                dialog.show()
                            }
                            else {
                                if(editText7.getText().toString() != editText6.getText().toString()){
                                    val builder = AlertDialog.Builder(this@Registro)

                                    builder.setCancelable(false)

                                    // Set the alert dialog title
                                    builder.setTitle("Registro")

                                    // Display a message on alert dialog
                                    builder.setMessage("Contraseñas distintas")

                                    // Display a neutral button on alert dialog
                                    builder.setNeutralButton("Ok"){_,_ ->

                                    }

                                    // Finally, make the alert dialog using builder
                                    val dialog: AlertDialog = builder.create()

                                    // Display the alert dialog on app interface
                                    dialog.show()
                                }
                                else {
                                    guardarUsuario()
                                    val intent = Intent(this, Inicio::class.java)
                                    startActivity(intent)
                                }
                            }
                        }
                    }
                }
            }
            else{
                val builder = AlertDialog.Builder(this@Registro)

                builder.setCancelable(false)

                // Set the alert dialog title
                builder.setTitle("Registro")

                // Display a message on alert dialog
                builder.setMessage("No puede dejar ningun campo vacío")

                // Display a neutral button on alert dialog
                builder.setNeutralButton("Ok"){_,_ ->

                }

                // Finally, make the alert dialog using builder
                val dialog: AlertDialog = builder.create()

                // Display the alert dialog on app interface
                dialog.show()
            }
        }

        val txtRes : TextView = findViewById(R.id.textView2)
        txtRes.setText("Crear Cuenta")
    }

    private fun guardarUsuario() {
        val ref = FirebaseDatabase.getInstance().getReference("Usuarios")
        val usuarioId = ref.push().key
        val usuario = User(usuarioId, editText3.getText().toString() , editText4.getText().toString(), editText5.getText().toString(), editText6.getText().toString())
        ref.child(editText3.getText().toString()).setValue(usuario).addOnCompleteListener {
        Toast.makeText(applicationContext, "Usuario creado con exito", Toast.LENGTH_LONG).show()
        }
    }

}
