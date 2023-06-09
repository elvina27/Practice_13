package com.example.practice_13

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ThirdActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedID")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        RightTxt = findViewById(R.id.txtRight)
        WrongTxt = findViewById(R.id.txtWrong)
        BackBtn = findViewById(R.id.btnBack)
        ExitBtn = findViewById(R.id.btnExit)

        RightTxt.text = intent.getStringExtra("right")
        WrongTxt.text = intent.getStringExtra("wrong")
        ExitBtn.setOnClickListener{
            finishAffinity()
        }
    }
    lateinit var RightTxt: TextView
    lateinit var WrongTxt: TextView
    lateinit var BackBtn: Button
    lateinit var ExitBtn: Button

    fun btnBackClick(){
        System.exit(0)
    }

    fun btnExitClick(){
        finishAffinity()
    }
}
