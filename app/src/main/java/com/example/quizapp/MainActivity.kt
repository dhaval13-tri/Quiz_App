package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = findViewById<TextInputEditText>(R.id.et_name)
        val startButton = findViewById<MaterialButton>(R.id.btn_start)

        startButton.setOnClickListener {
            if (name.text!!.isEmpty()){
                name.error = "Name required!"
            }
            else{
                val intent = Intent(this,QuizQuestionsActivity::class.java)
                intent.putExtra(QuestionList.USER_NAME,name.text.toString())
                startActivity(intent)
                finish()
            }
        }

    }
}