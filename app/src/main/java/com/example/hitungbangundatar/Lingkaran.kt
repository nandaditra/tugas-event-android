package com.example.hitungbangundatar

import android.content.Context
import android.content.SharedPreferences
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Lingkaran : AppCompatActivity() {
    private lateinit var jariJari: EditText
    private lateinit var diameter: EditText
    private lateinit var result: TextView
    private lateinit var container: SharedPreferences
    private var nilai = 0.0f
    private val SHARED = "KeyShared"
    private val RESULT = "ResultCalc"
    private val Jari = "Jari"
    private val Diameter = "Diameter"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lingkaran)
        jariJari = findViewById(R.id.edit_jarijari)
        diameter = findViewById(R.id.edit_diameter)
        result = findViewById(R.id.result)
        container = getSharedPreferences(SHARED, Context.MODE_PRIVATE)
        val btnJariResult = findViewById<Button>(R.id.hitung_jarijari)
        val btnDiameterResult = findViewById<Button>(R.id.hitung_diameter)

        btnJariResult.setOnClickListener {
            nilai = jariJari.text.toString().toFloat()*jariJari.text.toString().toFloat()*(22/7)
            result.text = nilai.toString()
            val editor = container.edit()
            editor.putFloat(RESULT, nilai)
            editor.putString(Jari, jariJari.text.toString())
            editor.apply()
        }

        btnDiameterResult.setOnClickListener {
            nilai = (diameter.text.toString().toFloat()*diameter.text.toString().toFloat()*(22/7))/4
            result.text = nilai.toString()
            val editor = container.edit()
            editor.putFloat(RESULT, nilai)
            editor.putString(Diameter, diameter.text.toString())
            editor.apply()
        }

        findViewById<Button>(R.id.backbutton).setOnClickListener(){
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val getResultCalc = container.getFloat(RESULT, 0.0f)
        val getResultJari = container.getString(Jari, "")
        val getResultDiameter = container.getString(Diameter, "")
        result.text = getResultCalc.toString()
        jariJari.setText(getResultJari)
        diameter.setText(getResultDiameter)
    }
}