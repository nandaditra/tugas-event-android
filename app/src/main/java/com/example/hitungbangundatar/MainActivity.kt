package com.example.hitungbangundatar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.lingkaran).setOnClickListener() {
            intent = Intent(this, Lingkaran::class.java)
            startActivity(intent)
        }


        findViewById<Button>(R.id.belahketupat).setOnClickListener() {
            intent = Intent(this, BelahKetupat::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.segitiga).setOnClickListener() {
            intent = Intent(this, Segitiga::class.java)
            startActivity(intent)
        }


    }
}