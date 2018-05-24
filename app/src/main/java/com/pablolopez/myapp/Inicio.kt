package com.pablolopez.myapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

import kotlinx.android.synthetic.main.activity_inicio.*
import kotlinx.android.synthetic.main.activity_registro.*
import kotlinx.android.synthetic.main.content_inicio.*

class Inicio : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        setSupportActionBar(toolbarInicio)

        toolbarInicio.setTitle("PRESTAPP")
        toolbarInicio.setTitleMargin(410,0,0,0)
        toolbarInicio.setTitleTextColor(Color.WHITE)

        fab.setOnClickListener { view ->
            val intent = Intent(this,NuevoPrestamo::class.java)
            startActivity(intent)
        }

        val lista_notificaciones = findViewById<ListView>(R.id.notificaciones)
        lista_notificaciones.adapter = Inicio.CustomAdapter()

        lista_notificaciones.setOnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(this, Notificacion::class.java)
            intent.putExtra("Nombre",lista_notificaciones.getItemAtPosition(i).toString())
            intent.putExtra("Tipo",lista_notificaciones.getItemAtPosition(i).toString())
            startActivity(intent)
        }
    }
    private class CustomAdapter(): BaseAdapter(){
        private val names = arrayListOf<String>(
                "Prestamo 1","Prestamo 2","Prestamo 3","Prestamo 4","Prestamo 5","Prestamo 6","Prestamo 7",
                "Prestamo 8","Prestamo 9","Prestamo 10","Prestamo 11","Prestamo 12"
        )

        private val tipos = arrayListOf<String>(
                "Deuda","Prestamo","Deuda","Prestamo","Deuda","Prestamo","Deuda","Prestamo","Deuda","Prestamo",
                "Deuda","Prestamo"
        )

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
