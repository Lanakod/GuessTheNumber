package com.left2create.guessthenumber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun difficultyClick(view: View)
    {
        when(view.id)
        {
            R.id.easy -> changeActivity(2)
            R.id.medium ->  changeActivity(3)
            R.id.hard ->  changeActivity(4)
            R.id.insane ->  changeActivity(5)
        }
    }

    private fun changeActivity(difficulty: Int)
    {
        val intent = Intent(applicationContext, GuessActivity::class.java)
        intent.putExtra("difficulty", difficulty)
        startActivity(intent)
    }
}