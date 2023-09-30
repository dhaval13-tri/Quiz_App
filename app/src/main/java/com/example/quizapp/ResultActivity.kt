package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var tvUsername = findViewById<MaterialTextView>(R.id.tv_username)
        val tvScore = findViewById<MaterialTextView>(R.id.tv_score)
        val btnFinishLast = findViewById<MaterialButton>(R.id.btn_finish_last)

        tvUsername.text = intent.getStringExtra(QuestionList.USER_NAME)
        val totalQuestions = intent.getIntExtra(QuestionList.TOTAL_QUESTIONS,0)
        val correctAnswers = intent.getIntExtra(QuestionList.CORRECT_ANSWERS,0)
        tvScore.text = "You got $correctAnswers out of $totalQuestions"

        btnFinishLast.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}