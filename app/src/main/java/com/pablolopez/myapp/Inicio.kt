package com.pablolopez.myapp

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_inicio.*

class Inicio : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val lista_notificaciones = findViewById<ListView>(R.id.notificaciones)
        lista_notificaciones.adapter = Inicio.CustomAdapter()
    }
    private class CustomAdapter(): BaseAdapter(){
        private val names = arrayListOf<String>(
                "Deuda","Prestamo","Terminado"
        )

        override fun getCount(): Int {
            return names.size
        }

        override fun getItemId(position:Int): Long {
            return position.toLong()
        }

        override fun getItem(position:Int): Any{
            return "Test String"
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
            viewHolder.nameTextView.text = names.get(position)
            viewHolder.positionText.text = "Descripicion"

            return rowMain
        }

        private class ViewHolder(val nameTextView: TextView, val positionText: TextView)
    }

}
