package com.mateusz.wycieczka

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.datepicker.DateValidatorPointBackward.now
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.time.*
import java.time.Instant.now
import java.time.LocalDate.now
import java.time.LocalDateTime.now
import java.time.MonthDay.now
import java.time.Year.now
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)

        return true


    }
    override fun onOptionsItemSelected(items: MenuItem): Boolean {

        return when (items.itemId) {
            R.id.exit -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(items)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.button)
        val textView3 = findViewById<TextView>(R.id.textView3)

        val sdf = SimpleDateFormat("dd/MM/yyyy")
        val todata = sdf.format(Date())

        textView3.text = "Dzisiaj est "+todata.toString()

        var startDate = ""
        var endDate = ""


        //val Intent = Intent(this,MainActivity2::class.java)
        //startActivity(Intent)


        btn.setOnClickListener {
            val datePicker = MaterialDatePicker.Builder.dateRangePicker().build()
            datePicker.show(supportFragmentManager, "DatePicker")
            datePicker.addOnPositiveButtonClickListener {
                Toast.makeText(this, "${datePicker.headerText} is selected", Toast.LENGTH_LONG).show()
                startDate = sdf.format(Date(it.first))
                endDate = sdf.format(Date(it.second))
                val mDate11 = Date(it.first)
                val mDate22 = Date(it.second)

                textView3.text = "Dni: " +datePicker.headerText
                val sprprze = sprDATA(data = todata, dzienend = endDate,dzienstart = startDate)
                if(sprprze.sprprzeszlosc()==false){
                    findViewById<TextView>(R.id.textView8).text = "TERMIN JEST AKTUALNY"
                    if(sprprze.sprpprzyszlosc()==true){
                        findViewById<TextView>(R.id.textView9).text = "ZAKRES JEST DOSTEPNY"
                        val mDifference = kotlin.math.abs(mDate11.time - mDate22.time)
                        val mDifferenceDates = mDifference / (24 * 60 * 60 * 1000)
                        val mDayDifference = mDifferenceDates.toString()
                        findViewById<TextView>(R.id.textView7).text = "Wycieczka trwa $mDayDifference dni"
                        findViewById<TextView>(R.id.textView5).text = startDate
                        findViewById<TextView>(R.id.textView2).text = endDate
                    }
                    else{findViewById<TextView>(R.id.textView9).text ="DATA MOZE BYC TYLKO DO 2 LAT W PRZOD"}
                    datePicker.addOnNegativeButtonClickListener {
                        Toast.makeText(this, "${datePicker.headerText} is cancelled", Toast.LENGTH_LONG).show()
                    }
                    datePicker.addOnCancelListener {
                        Toast.makeText(this, "Date Picker Cancelled", Toast.LENGTH_LONG).show()
                    }
                }
                else{findViewById<TextView>(R.id.textView8).text ="DATA NIE MOZE BYC Z PRZESZLOSCI"}


            }

        }




    }
}