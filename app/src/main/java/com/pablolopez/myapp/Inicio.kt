package com.pablolopez.myapp

import SaveArrayListToSD
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.firebase.database.*

import kotlinx.android.synthetic.main.activity_inicio.*
import kotlinx.android.synthetic.main.activity_registro.*
import kotlinx.android.synthetic.main.content_inicio.*


class Inicio() : AppCompatActivity() {

    lateinit var ref: DatabaseReference

    var listPrestamo = arrayListOf<String>()
    var listDescripcion = arrayListOf<String>()
    var listShort = arrayListOf<String>()
    var listEstados = arrayListOf<String>()
    var listIds = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        setSupportActionBar(toolbarInicio)

        ref = FirebaseDatabase.getInstance().getReference("Prestamo")
        val lista_notificaciones = findViewById<ListView>(R.id.notificaciones)

        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot?) {
                if(p0!! .exists()){
                    for(h in p0.children){
                        val nom = h.getValue(Prestamo :: class.java)!!.nombre
                        val descr = h.getValue(Prestamo :: class.java)!!.descripcion
                        val notishow = h.getValue(Prestamo :: class.java)!!.short
                        val estado = h.getValue(Prestamo :: class.java)!!.estado
                        val id = h.getValue(Prestamo :: class.java)!!.id
                        listPrestamo.add(nom)
                        listDescripcion.add(descr)
                        listShort.add(notishow)
                        listEstados.add(estado)
                        listIds.add(id)
                        lista_notificaciones.adapter = Inicio.CustomAdapter(listShort,listPrestamo)

                    }

                }
            }

        })



        toolbarInicio.setTitle("PRESTAPP")
        toolbarInicio.setTitleMargin(410,0,0,0)
        toolbarInicio.setTitleTextColor(Color.WHITE)

        fab.setOnClickListener { view ->
            val intent = Intent(this,NuevoPrestamo::class.java)
            startActivity(intent)
        }

        fab2.setOnClickListener { view ->
            val builder = AlertDialog.Builder(this@Inicio)

            builder.setCancelable(false)

            // Set the alert dialog title
            builder.setTitle("Cerrar Sesion")


            // Display a message on alert dialog
            builder.setMessage("¿Está seguro de cerrar sesión?")

            // Set a positive button and its click listener on alert dialog
            builder.setPositiveButton("SI"){dialog, which ->
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }

            // Display a negative button on alert dialog
            builder.setNegativeButton("No"){dialog,which ->

            }

            // Finally, make the alert dialog using builder
            val dialog: AlertDialog = builder.create()

            // Display the alert dialog on app interface
            dialog.show()

        }


        lista_notificaciones.setOnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(this, Notificacion::class.java)
            intent.putExtra("Nombre","DESCRIPCION")
            intent.putExtra("Tipo", listDescripcion[i])
            intent.putExtra("Estado",listEstados[i])
            intent.putExtra("Id",listIds[i])
            intent.putExtra("Nombre2",listPrestamo[i])
            intent.putExtra("Short",listShort[i])
            startActivity(intent)
        }
    }
    private class CustomAdapter(nList: ArrayList<String>, tList : ArrayList<String>): BaseAdapter(){

        private val names = nList
        private var tipos = tList


        override fun getCount(): Int {
            return names.size
        }

        override fun getItemId(position:Int): Long {
            return position.toLong()
        }

        override fun getItem(position:Int): Any{
            return names.get(position)
        }


        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val rowMain: View

            if(convertView == null){
                val layoutInflater = LayoutInflater.from(parent!!.context)
                rowMain = layoutInflater.inflate(R.layout.lista_not, parent, false)

                val tipo_notificacion = rowMain.findViewById<TextView>(R.id.tipo_not)
                val desc_notificacion = rowMain.findViewById<TextView>(R.id.desc_notif)
                val viewHolder = ViewHolder(tipo_notificacion,desc_notificacion)
                rowMain.tag = viewHolder
            }
            else{
                rowMain = convertView
            }

            val viewHolder = rowMain.tag as ViewHolder
            viewHolder.nameTextView.text = tipos.get(position)
            viewHolder.positionText.text = names.get(position)

            return rowMain
        }

        private class ViewHolder(val nameTextView: TextView, val positionText: TextView)
    }

}
