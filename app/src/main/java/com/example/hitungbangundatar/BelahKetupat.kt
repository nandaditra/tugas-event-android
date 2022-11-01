package com.example.hitungbangundatar

import android.content.Context
import android.content.SharedPreferences
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class BelahKetupat : AppCompatActivity() {
    private lateinit var diagonal1: EditText
    private lateinit var diagonal2: EditText
    private lateinit var result: TextView
    private lateinit var container: SharedPreferences
    private var nilai = 0.0f
    private val SHARED = "KeyShared"
    private val RESULT = "Result"
    private val DIAGONALONE = "DiagonalOne"
    private val DIAGONALTWO = "DiagonalTwo"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_belah_ketupat)
        diagonal1 = findViewById(R.id.edit_diagonal1)
        diagonal2 = findViewById(R.id.edit_diagonal2)
        result = findViewById(R.id.textResult)
        container = getSharedPreferences(SHARED, Context.MODE_PRIVATE)
        val btnResult = findViewById<Button>(R.id.buttonHitung)

        btnResult.setOnClickListener{
            nilai = (diagonal1.text.toString().toFloat() * diagonal2.text.toString().toFloat())/2
            result.text = nilai.toString()
            val editor = container.edit()
            editor.putFloat(RESULT, nilai)
            editor.putString(DIAGONALONE, diagonal1.text.toString())
            editor.putString(DIAGONALTWO, diagonal2.text.toString())
            editor.apply()
        }

        val getResultCalc = container.getFloat(RESULT, 0.0f)
        val getResultDiagonalOne = container.getString(DIAGONALONE, "")
        val getResultDiagonalTwo = container.getString(DIAGONALTWO, "")
        result.text = getResultCalc.toString()
        diagonal1.setText(getResultDiagonalOne)
        diagonal2.setText(getResultDiagonalTwo)

        findViewById<Button>(R.id.backbutton).setOnClickListener(){
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}