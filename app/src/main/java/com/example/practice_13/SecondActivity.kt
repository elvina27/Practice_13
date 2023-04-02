package com.example.practice_13

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlin.random.Random

class SecondActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedID")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        RadGroup = findViewById(R.id.radGroup)
        rbt1 = findViewById(R.id.rbtn1)
        rbt2 = findViewById(R.id.rbtn2)
        rbt3 = findViewById(R.id.rbtn3)
        rbt4 = findViewById(R.id.rbtn4)
        rbt5 = findViewById(R.id.rbtn5)
        rbt6 = findViewById(R.id.rbtn6)
        rbt7 = findViewById(R.id.rbtn7)
        rbt8 = findViewById(R.id.rbtn8)
        rbt9 = findViewById(R.id.rbtn9)
        rbt10 = findViewById(R.id.rbtn10)
        rbt11 = findViewById(R.id.rbtn11)
        rbt12 = findViewById(R.id.rbtn12)
        rbt13 = findViewById(R.id.rbtn13)
        rbt14 = findViewById(R.id.rbtn14)
        rbt15 = findViewById(R.id.rbtn15)
        CheckBtn = findViewById(R.id.btnCheck)

        shuffleRadButtons()
        RadGroup.setOnCheckedChangeListener{group, checkedId -> Check()}
        CheckBtn.setOnClickListener { btnCheckClick() }
    }

    lateinit var RadGroup: RadioGroup
    lateinit var rbt1: RadioButton
    lateinit var rbt2: RadioButton
    lateinit var rbt3: RadioButton
    lateinit var rbt4: RadioButton
    lateinit var rbt5: RadioButton
    lateinit var rbt6: RadioButton
    lateinit var rbt7: RadioButton
    lateinit var rbt8: RadioButton
    lateinit var rbt9: RadioButton
    lateinit var rbt10: RadioButton
    lateinit var rbt11: RadioButton
    lateinit var rbt12: RadioButton
    lateinit var rbt13: RadioButton
    lateinit var rbt14: RadioButton
    lateinit var rbt15: RadioButton
    lateinit var CheckBtn: Button


    private fun shuffleRadButtons(){
        val radioButtons = listOf(rbt1, rbt2, rbt3, rbt4, rbt5, rbt6, rbt7, rbt8, rbt9, rbt10, rbt11, rbt12, rbt13, rbt14, rbt15)
        val shuf = radioButtons.shuffled()
        RadGroup.removeAllViews()
        shuf.forEach{radioButton -> RadGroup.addView(radioButton) }
    }

    fun btnCheckClick() {
        val selectedOption: RadioButton = findViewById(RadGroup.checkedRadioButtonId)
        val answer: String = selectedOption.text.toString()
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("answer", answer)
        setResult(RESULT_OK, intent)
        finish()
    }

    fun Check(){
        val selectedOption: RadioButton? = findViewById(RadGroup.checkedRadioButtonId)
        CheckBtn.isEnabled = selectedOption != null
    }
}
