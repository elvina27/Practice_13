package com.example.practice_13

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat.startActivityForResult
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        //  @SuppressLint("MissingInflatedID")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RiddleTxt = findViewById(R.id.txtRiddle)
        AnswerTxt = findViewById(R.id.txtAnswer)
        ScoreTxt = findViewById(R.id.txtScore)
        StatisticsBtn = findViewById(R.id.btnStatistics)
        RiddleBtn = findViewById(R.id.btnRiddle)
        AnswerBtn = findViewById(R.id.btnAnswer)
    }

    lateinit var RiddleTxt: TextView
    lateinit var AnswerTxt: TextView
    lateinit var ScoreTxt: TextView
    lateinit var StatisticsBtn: Button
    lateinit var RiddleBtn: Button
    lateinit var AnswerBtn: Button
    var right = 0
    var wrong = 0
    var count = 0
    val askedRiddles = mutableListOf<Int>()

    fun btnRiddleClick(view: View) {
        // val randomRiddle = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
        var randomRiddle: Int
        do {
            randomRiddle = Random.nextInt(1, 16)
        }
        while (randomRiddle in askedRiddles)
        askedRiddles.add(randomRiddle)
        when (randomRiddle) {
            1 -> RiddleTxt.text = "А утром выйдет солнышко — и не найти ни зёрнышка!"
            2 -> RiddleTxt.text =
                "Шар невелик, лениться не велит; если знаешь предмет, то покажешь весь свет."
            3 -> RiddleTxt.text = "Грамоты не знаю, целый век пишу."
            4 -> RiddleTxt.text = "Какой чудачок имел пятачок, его не потратил и другого не нажил?"
            5 -> RiddleTxt.text =
                "Не бранит никто мальца, но колотят без конца. Пока он не скроется, никто не успокоится."
            6 -> RiddleTxt.text =
                "Две сестры качались, правды добивались. Правды добились — остановились."
            7 -> RiddleTxt.text =
                "При двух руках, с одной ходит по воде. На себе носит, а не тонет."
            8 -> RiddleTxt.text = "Ходят великаны, горбят океаны. К берегу придут — сразу пропадут."
            9 -> RiddleTxt.text = "Всем, кто придёт, и всем, кто уйдёт, руку подаёт."
            10 -> RiddleTxt.text = "Шарик невелик, да плакать велит."
            11 -> RiddleTxt.text = "По сеням взад-вперёд ходит, а в избу не входит."
            12 -> RiddleTxt.text =
                "Не мотор, а гудит. Не пилот, а летит. Не змея, а жалит. Не воин, а врага валит."
            13 -> RiddleTxt.text = "Бел, да не сахар. Пушист, да не птица. Нет ног, а идёт."
            14 -> RiddleTxt.text = "У кого глаза на рогах, а дом на спине?"
            15 -> RiddleTxt.text =
                "Шёл мужик по лесу, нёс зеркало за поясом. Лесу поклонился, лес повалился."
        }
        RiddleBtn.isEnabled = false
        AnswerBtn.isEnabled = true
        AnswerTxt.text = ""
        AnswerTxt.setBackgroundColor(Color.WHITE)

    }

    fun btnAnswerClick(view: View) {
        val intent = Intent(this, SecondActivity::class.java)
        startActivityForResult(intent, 1)
    }

    fun btnStatisticsClick(view: View) {
        val intent = Intent(this, ThirdActivity::class.java)
        intent.putExtra("right",right.toString())
        intent.putExtra("wrong",wrong.toString())
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == RESULT_OK) {
            val answer = data?.getStringExtra("answer")
            if (answer != null) {
                AnswerTxt.text = answer
            }
            if (RiddleTxt.text == "А утром выйдет солнышко — и не найти ни зёрнышка!" && AnswerTxt.text == "Звёзды" ||
                RiddleTxt.text == "Шар невелик, лениться не велит; если знаешь предмет, то покажешь весь свет." && AnswerTxt.text == "Глобус" ||
                RiddleTxt.text == "Грамоты не знаю, целый век пишу." && AnswerTxt.text == "Перо" ||
                RiddleTxt.text == "Какой чудачок имел пятачок, его не потратил и другого не нажил?" && AnswerTxt.text == "Поросёнок" ||
                RiddleTxt.text == "Не бранит никто мальца, но колотят без конца. Пока он не скроется, никто не успокоится." && AnswerTxt.text == "Гвоздь" ||
                RiddleTxt.text == "Две сестры качались, правды добивались. Правды добились — остановились." && AnswerTxt.text == "Весы" ||
                RiddleTxt.text == "При двух руках, с одной ходит по воде. На себе носит, а не тонет." && AnswerTxt.text == "Лодка" ||
                RiddleTxt.text == "Ходят великаны, горбят океаны. К берегу придут — сразу пропадут." && AnswerTxt.text == "Волны" ||
                RiddleTxt.text == "Всем, кто придёт, и всем, кто уйдёт, руку подаёт." && AnswerTxt.text == "Дверная ручка" ||
                RiddleTxt.text == "Шарик невелик, да плакать велит." && AnswerTxt.text == "Лук" ||
                RiddleTxt.text == "По сеням взад-вперёд ходит, а в избу не входит." && AnswerTxt.text == "Дверь" ||
                RiddleTxt.text == "Не мотор, а гудит. Не пилот, а летит. Не змея, а жалит. Не воин, а врага валит." && AnswerTxt.text == "Оса" ||
                RiddleTxt.text == "Бел, да не сахар. Пушист, да не птица. Нет ног, а идёт." && AnswerTxt.text == "Снег" ||
                RiddleTxt.text == "У кого глаза на рогах, а дом на спине?" && AnswerTxt.text == "Улитка" ||
                RiddleTxt.text == "Шёл мужик по лесу, нёс зеркало за поясом. Лесу поклонился, лес повалился." && AnswerTxt.text == "Топор"
            ) {
                AnswerTxt.setBackgroundColor(Color.GREEN)
                right++
            } else {
                AnswerTxt.setBackgroundColor(Color.RED)
                wrong++
            }

            AnswerBtn.isEnabled = false
            RiddleBtn.isEnabled = true
            count++
            ScoreTxt.text = "${count}/10"
            if (count == 10) {
                StatisticsBtn.isEnabled = true
                AnswerBtn.isEnabled = false
                RiddleBtn.isEnabled = false
            }
        }
    }
}

