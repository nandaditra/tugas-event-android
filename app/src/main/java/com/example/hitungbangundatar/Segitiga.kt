package com.example.hitungbangundatar

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Segitiga : AppCompatActivity() {
    private lateinit var alas: EditText
    private lateinit var tinggi: EditText
    private lateinit var result: TextView
    private lateinit var container: SharedPreferences
    private var nilai = 0.0f
    private val SHARED = "KeyShared"
    private val RESULT = "Result"
    private val ALAS = "Alas"
    private val TINGGI = "Tinggi"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segitiga)
        alas = findViewById(R.id.editAlas)
        tinggi = findViewById(R.id.editTinggi)
        result = findViewById(R.id.textResultSegitiga)
        container = getSharedPreferences(SHARED, Context.MODE_PRIVATE)
        val btnResult = findViewById<Button>(R.id.buttonHitungSegitiga)

        btnResult.setOnClickListener{
            nilai = (alas.text.toString().toFloat()*tinggi.text.toString().toFloat())/2
            result.text = nilai.toString()
            val editor = container.edit()
            editor.putFloat(RESULT, nilai)
            editor.putString(ALAS, alas.text.toString())
            editor.putString(TINGGI, tinggi.text.toString())
            editor.apply()
        }

        val getResultCalc = container.getFloat(RESULT, 0.0f)
        val getResultAlas = container.getString(ALAS, "")
        val getResultTinggi = container.getString(TINGGI, "")
        result.text = getResultCalc.toString()
        alas.setText(getResultAlas)
        tinggi.setText(getResultTinggi)

        findViewById<Button>(R.id.backbutton).setOnClickListener(){
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}