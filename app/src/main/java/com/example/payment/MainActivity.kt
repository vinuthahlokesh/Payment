package com.example.payment

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity: AppCompatActivity() {
    lateinit var editcardNumber: EditText;lateinit var editcardholder:EditText;lateinit var editexpdate:EditText;lateinit var editcvv:EditText
    lateinit var cardno: TextView;lateinit var cardhold:TextView; lateinit var expirydate:TextView
    lateinit var reset: Button;lateinit var update:Button
    var count = 0

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cardno = findViewById(R.id.textView4)
        cardhold = findViewById(R.id.textView6)
        expirydate = findViewById(R.id.textView7)
        editcardNumber = findViewById(R.id.plain_text_input)
        editcardholder = findViewById(R.id.plain_text_input1)
        editexpdate = findViewById(R.id.plain_text_input2)
        editcvv = findViewById(R.id.cvv)
        reset = findViewById(R.id.button3)
        update = findViewById(R.id.button2)
    }
        fun onClick(view: View) {
            when (view.id) {
                R.id.button3 -> {
                    editcardNumber.setText("")
                    editcardholder.setText("")
                    editexpdate.setText("")
                    editcvv.setText("")
                }
                R.id.button2 -> {

                    val cardnu = editcardNumber.text.toString()
                    val cardh: String = editcardholder.getText().toString()
                    cardno.text = cardnu
                    cardhold.setText(cardh)
                    expirydate.setText(editexpdate.getText().toString())
                }
            }
        }

    fun OnClick(view: View?) {
        val expdate = Calendar.getInstance()
        val day = expdate[Calendar.DAY_OF_MONTH]
        val month = expdate[Calendar.MONTH]
        val year = expdate[Calendar.YEAR]
        val datePickerDialog = DatePickerDialog(this,
                OnDateSetListener { view, year, monthOfYear, dayOfMonth -> editexpdate.setText((monthOfYear + 1).toString() + "/" + year % 100) }, year, month, day)
        datePickerDialog.show()
    }


}