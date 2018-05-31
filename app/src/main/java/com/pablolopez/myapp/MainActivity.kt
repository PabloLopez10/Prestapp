package com.pablolopez.myapp

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*
//import javax.print.attribute.standard.ReferenceUriSchemesSupported.HTTP




class MainActivity : AppCompatActivity() {

    lateinit var ref: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        ref = FirebaseDatabase.getInstance().getReference("Usuarios")

        val usuario:EditText = findViewById(R.id.Correo)
        val contra:EditText = findViewById(R.id.Contraseña)

        val usuarios = arrayListOf<String>(

        )

        val contras = arrayListOf<String>(

        )

        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot?) {
                if(p0!! .exists()){

                    for(h in p0.children){
                        val usuario = h.getValue(User :: class.java)!!.correo
                        val contra = h.getValue(User :: class.java)!!.contrasena
                        usuarios.add(usuario)
                        contras.add(contra)

                    }

                }
            }

        })


        val registro : Button = findViewById(R.id.Registrarse)
        registro.setOnClickListener {
            val intent = Intent(this, Registro :: class.java)
            intent.putExtra("Correos",usuarios)
            intent.putExtra("Claves",contras)
            startActivity(intent)
        }

        val botonAyuda = findViewById<ImageButton>(R.id.buttonAyuda)
        botonAyuda.setOnClickListener(){
            val intent = Intent(this,Ayuda::class.java)
            startActivity(intent)
        }

        val textAyuda = findViewById<TextView>(R.id.textViewAyuda)
        textAyuda.setOnClickListener(){
            val intent = Intent(this,Ayuda::class.java)
            startActivity(intent)
        }

        val botonInicio = findViewById<Button>(R.id.Inicio_sesion)
        botonInicio.setOnClickListener(){

            if(usuario.getText().toString() in usuarios && contra.getText().toString() in contras){
                if(usuarios.indexOf(usuario.getText().toString()) == contras.indexOf(contra.getText().toString())){
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
