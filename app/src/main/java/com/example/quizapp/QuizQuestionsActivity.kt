package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition:Int = 1
    private var mQuestionList:ArrayList<Question>? = null
    private var mOptionSelectedPosition:Int = 0
    private var mUsername:String? = null
    private var mCorrectAnswers:Int = 0

    private var progressBar: ProgressBar? = null
    private var textProgress:MaterialTextView? = null
    private var textQue:MaterialTextView? = null
    private var imageQue:ShapeableImageView? = null

    private var textOption1:MaterialTextView? = null
    private var textOption2:MaterialTextView? = null
    private var textOption3:MaterialTextView? = null
    private var textOption4:MaterialTextView? = null
    private var btn_submit:MaterialButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUsername = intent.getStringExtra(QuestionList.USER_NAME)

        progressBar = findViewById(R.id.progressBar)
        textProgress = findViewById(R.id.text_progress)
        textQue = findViewById(R.id.text_que)
        imageQue = findViewById(R.id.image_que)

        textOption1 = findViewById(R.id.text_option1)
        textOption2 = findViewById(R.id.text_option2)
        textOption3 = findViewById(R.id.text_option3)
        textOption4 = findViewById(R.id.text_option4)
        btn_submit = findViewById(R.id.btn_submit)

        textOption1?.setOnClickListener(this)
        textOption2?.setOnClickListener(this)
        textOption3?.setOnClickListener(this)
        textOption4?.setOnClickListener(this)
        btn_submit?.setOnClickListener(this)


        mQuestionList = QuestionList.getQuestions()
        setQuestion()

    }

    private fun setQuestion() {

        defaultOptionView()

        val question: Question = mQuestionList!![mCurrentPosition - 1]
        textQue?.text = question.question
        imageQue?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        textProgress?.text = "$mCurrentPosition"+"/"+"${progressBar?.max}"

        textOption1?.text = question.optionOne
        textOption2?.text = question.optionTwo
        textOption3?.text = question.optionThree
        textOption4?.text = question.optionFour


        if (mCurrentPosition == mQuestionList!!.size){
            btn_submit?.text = "Finish"
        }else{
            btn_submit?.text = "Submit"
        }
    }

    private fun defaultOptionView(){
        val options = ArrayList<MaterialTextView>()
        textOption1?.let {
            options.add(0,it)
        }
        textOption2?.let {
            options.add(1,it)
        }
        textOption3?.let {
            options.add(2,it)
        }
        textOption4?.let {
            options.add(3,it)
        }

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.option_border
            )
        }

    }

    private fun selectedOptionView(tv: MaterialTextView, selectedOptionNum:Int){
        defaultOptionView()

        mOptionSelectedPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.typeface = Typeface.DEFAULT_BOLD
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border
        )

    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.text_option1 -> {
                textOption1?.let {
                    selectedOptionView(it,1)
                }
            }
            R.id.text_option2 -> {
                textOption2?.let {
                    selectedOptionView(it,2)
                }
            }
            R.id.text_option3 -> {
                textOption3?.let {
                    selectedOptionView(it,3)
                }
            }
            R.id.text_option4 -> {
                textOption4?.let {
                    selectedOptionView(it,4)
                }
            }
            R.id.btn_submit -> {

                 if (mOptionSelectedPosition == 0){
                     mCurrentPosition++

                     when{
                         mCurrentPosition <= mQuestionList!!.size -> {
                             setQuestion()
                         }

                         else -> {

                             val intent = Intent(this,ResultActivity::class.java)
                             intent.putExtra(QuestionList.USER_NAME,mUsername)
                             intent.putExtra(QuestionList.CORRECT_ANSWERS,mCorrectAnswers)
                             intent.putExtra(QuestionList.TOTAL_QUESTIONS,mQuestionList?.size)
                             startActivity(intent)
                             finish()
                         }
                     }
                 }else{
                     val question = mQuestionList?.get(mCurrentPosition-1)

                     if (question!!.correctAnswer != mOptionSelectedPosition){
                         answersView(mOptionSelectedPosition,R.drawable.incorrect_answer_border)

                     }else{
                         mCorrectAnswers++
                         answersView(mOptionSelectedPosition,R.drawable.correct_answer_border)
                     }

                     if (mCurrentPosition == mQuestionList!!.size){
                         btn_submit?.text = "Finish"
                     }
                     else{
                         btn_submit?.text = "Go to Next Question"
                     }

                     mOptionSelectedPosition = 0

                 }
            }


        }
    }

    private fun answersView(answer:Int, drawableView:Int){
       when(answer){
           1 -> {
               textOption1?.background = ContextCompat.getDrawable(
                   this,
                   drawableView
               )
           }
           2 -> {
               textOption2?.background = ContextCompat.getDrawable(
                   this,
                   drawableView
               )
           }
           3 -> {
               textOption3?.background = ContextCompat.getDrawable(
                   this,
                   drawableView
               )
           }
           4 -> {
               textOption4?.background = ContextCompat.getDrawable(
                   this,
                   drawableView
               )
           }
       }
    }
}