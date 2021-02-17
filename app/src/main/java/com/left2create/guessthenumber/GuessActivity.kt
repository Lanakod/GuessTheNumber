package com.left2create.guessthenumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class GuessActivity : AppCompatActivity() {

    private var difficulty: Int = 0
    private var answer = ""
    private var hintCounter = 0
    private var hintString = ""
    private lateinit var tvHint: TextView
    lateinit var etResult: EditText

    private val congratulation = "Поздравляю!\nВы угадали число!"
    private val guess = "Угадайте число\nКоличество цифр: %d"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guess)
        tvHint = findViewById(R.id.textView3)
        etResult = findViewById(R.id.editText)

        tvHint.text = ""
        if(intent.hasExtra("difficulty"))  difficulty = intent.getIntExtra("difficulty", 2)
        for(i in 1..difficulty) answer += (0..9).random().toString()
        findViewById<TextView>(R.id.textView2).text = guess.format(difficulty)
    }

    fun hintClick(view: View)
    {
        if(hintCounter < difficulty)
        {
            hintString += "%s цифра - %s\n".format(++hintCounter, answer[hintCounter - 1])
            tvHint.text = hintString
        }
    }

    fun enterClick(view: View)
    {
        if(etResult.text.toString() == answer) tvHint.text = congratulation
    }
}