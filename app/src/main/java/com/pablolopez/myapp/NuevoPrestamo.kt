package com.pablolopez.myapp

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_inicio.*
import kotlinx.android.synthetic.main.activity_nuevo_prestamo.*
import android.app.DatePickerDialog
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.DatePicker
import android.widget.RadioGroup
import java.io.IOException
import java.io.OutputStreamWriter
import java.text.SimpleDateFormat
import java.util.*
import android.widget.Toast
import com.pablolopez.myapp.R.id.radioButton
import android.widget.RadioButton
import com.pablolopez.myapp.R.id.radioButton






class NuevoPrestamo : AppCompatActivity() {

    val myCalendar = Calendar.getInstance()
    val myCalendar2 = Calendar.getInstance()

    public var stringtoPass = String();
    public var notiShowtoPass = String();


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo_prestamo)
        setSupportActionBar(findViewById(R.id.toolbarNuevo))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        var groupDoP = findViewById<RadioGroup>(R.id.radiosPrestamooDeuda)
        var textOwner = findViewById<EditText>(R.id.textDeudor)
        var textQuant = findViewById<EditText>(R.id.textDinero)
        var textInter = findViewById<EditText>(R.id.textInteres)
        var groupInter = findViewById<RadioGroup>(R.id.radiosInteres)
        var textDateE = findViewById<EditText>(R.id.textDateEntrega)
        var textDateR = findViewById<EditText>(R.id.textDateRecordatorio)
        var groupRec = findViewById<RadioGroup>(R.id.radiosRecordatorio)
        val edittext = findViewById<EditText>(R.id.textDateEntrega)


        val date = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, monthOfYear)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLabel()
        }


        edittext.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View) {
                DatePickerDialog(this@NuevoPrestamo, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show()
            }
        })

        val edittext2 = findViewById<EditText>(R.id.textDateRecordatorio)
        val date2 = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            // TODO Auto-generated method stub
            myCalendar2.set(Calendar.YEAR, year)
            myCalendar2.set(Calendar.MONTH, monthOfYear)
            myCalendar2.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLabelRecordatorio()
        }


        edittext2.setOnClickListener(object : View.OnClickListener {
             override fun onClick(v: View) {
            // TODO Auto-generated method stub
            DatePickerDialog(this@NuevoPrestamo, date2, myCalendar2
                    .get(Calendar.YEAR), myCalendar2.get(Calendar.MONTH),
                    myCalendar2.get(Calendar.DAY_OF_MONTH)).show()
            }
        })

        toolbarNuevo.setTitle("PRESTAPP")
        toolbarNuevo.setTitleMargin(250,0,0,0)
        toolbarNuevo.setTitleTextColor(Color.WHITE)

        val botonNPrestamo = findViewById<Button>(R.id.button2)
        botonNPrestamo.setOnClickListener(){

            //Prestamo o Deuda
            val selectedId = groupDoP.getCheckedRadioButtonId()

            val buttonDoP = (findViewById<View>(selectedId) as RadioButton)

            var stringTipo = ""
            if (buttonDoP.text == "Debo"){
                stringTipo = "Deuda"
            }
            else{
                stringTipo = "Prestamo"
            }


            val owner = textOwner.text

            //Cuanto

            val quant = textQuant.text
            val inter = textInter.text
            val interT = (findViewById<View>(groupInter.checkedRadioButtonId) as RadioButton).text
            val dateE = textDateE.text
            val dateR = textDateR.text
            val rInter = (findViewById<View>(groupRec.checkedRadioButtonId) as RadioButton).text


            stringtoPass = "$stringTipo a $owner: \nCantidad:  Q $quant\nCon interes $interT de % $inter. \nEste pago se debe realizar a mas tardar el $dateE. \nLos recordatorios se haran $rInter, empezando desde el $dateR"
            notiShowtoPass = "$stringTipo de: Q$quant. a $owner"


            val intent = Intent(this,Verificar::class.java)
            intent.putExtra("STRING_PASS", stringtoPass)
            intent.putExtra("STRING_TYPE", stringTipo)
            intent.putExtra("STRING_NOTI", notiShowtoPass)
            startActivity(intent)

        }


    }




    private fun updateLabel() {
        val myFormat = "MM/dd/yy" //In which you need put here
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        textDateEntrega.setText(sdf.format(myCalendar.getTime()))    }


    private fun updateLabelRecordatorio() {
        val myFormat = "MM/dd/yy" //In which you need put here
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        textDateRecordatorio.setText(sdf.format(myCalendar2.getTime()))    }
}




