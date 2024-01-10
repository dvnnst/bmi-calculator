package com.smktelkommlg.www.bmi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculateBtn = findViewById<Button>(R.id.calculateBtn)
        val resetBtn = findViewById<Button>(R.id.resetBtn)

        calculateBtn.setOnClickListener { calculate() }
        resetBtn.setOnClickListener { resetInputs() }
    }

    private fun resetInputs() {
        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextAge = findViewById<EditText>(R.id.editTextAge)
        val editTextHeight = findViewById<EditText>(R.id.editTextHeight)
        val editTextWeight = findViewById<EditText>(R.id.editTextWeight)

        editTextName.setText("")
        editTextAge.setText("")
        editTextWeight.setText("")
        editTextHeight.setText("")
    }

    private fun calculate() {
        var gender = "Male"
        val editTextHeight = findViewById<EditText>(R.id.editTextHeight)
        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextAge = findViewById<EditText>(R.id.editTextAge)
        val editTextWeight = findViewById<EditText>(R.id.editTextWeight)
        val genders = findViewById<RadioGroup>(R.id.radioGroupGender)
        val resultText = findViewById<TextView>(R.id.result)

        val name = editTextName.text.toString()
        val age = editTextAge.text.toString().toDouble()
        val height = editTextHeight.text.toString().toDouble()
        val weight = editTextWeight.text.toString().toDouble()

        val selectedGender = genders.checkedRadioButtonId

        gender = when (selectedGender) {
            R.id.radioButtonMale -> "Male"
            R.id.radioButtonFemale -> "Female"
            else -> "Male"
        }

        val bmi = when (gender) {
            "Male" -> weight / ((height / 100) * (height / 100))
            "Female" -> weight / ((height / 100) * (height / 100)) * 0.9
            else -> 0.0
        }


        val result = "Result: " + when {
            bmi < 18.5 -> "Underweight"
            bmi >= 18.5 && bmi < 24.9 -> "Normal"
            bmi >= 25 && bmi < 29.9 -> "Overweight"
            else -> "Obese"
        } + "\nName: $name"
            "\nAge: $age"
        resultText.text = result
    }
}