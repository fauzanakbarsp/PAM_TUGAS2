package com.example.pam_tugas2

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextNumber1 = findViewById<EditText>(R.id.editTextNumber1)
        val editTextNumber2 = findViewById<EditText>(R.id.editTextNumber2)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        buttonCalculate.setOnClickListener {
            val number1 = editTextNumber1.text.toString().toDoubleOrNull()
            val number2 = editTextNumber2.text.toString().toDoubleOrNull()

            if (number1 == null || number2 == null) {
                Toast.makeText(this, "Masukkan angka yang valid", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val selectedRadioButtonId = radioGroup.checkedRadioButtonId
            if (selectedRadioButtonId == -1) {
                Toast.makeText(this, "Pilih operator", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val result = when (selectedRadioButtonId) {
                R.id.radioAdd -> number1 + number2
                R.id.radioSubtract -> number1 - number2
                R.id.radioMultiply -> number1 * number2
                R.id.radioDivide -> {
                    if (number2 != 0.0) number1 / number2 else {
                        Toast.makeText(this, "Tidak bisa membagi dengan 0", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }
                }
                else -> 0.0
            }

            textViewResult.text = "Hasil: $result"
        }
    }
}