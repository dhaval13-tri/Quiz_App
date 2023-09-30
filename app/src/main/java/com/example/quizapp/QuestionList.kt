package com.example.quizapp

object QuestionList {

    const val USER_NAME:String = "user_name"
    const val CORRECT_ANSWERS:String = "correct_answers"
    const val TOTAL_QUESTIONS:String = "total_questions"

    fun getQuestions():ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1,
            "What Country does this flag belongs to?",
            R.drawable.ic_afghanistan,
            "Afghanistan",
            "Armenia",
            "Australia",
            "Algeria",
            1
        )

        questionsList.add(que1)

        val que2 = Question(
            2,
            "What Country does this flag belongs to?",
            R.drawable.ic_brazil,
            "Bangladesh",
            "Brazil",
            "Ukraine",
            "Nepal",
            2
        )

        questionsList.add(que2)

        val que3 = Question(
            3,
            "What Country does this flag belongs to?",
            R.drawable.ic_canada,
            "Syria",
            "Saudi Arabia",
            "Canada",
            "South Africa",
            3
        )

        questionsList.add(que3)

        val que4 = Question(
            4,
            "What Country does this flag belongs to?",
            R.drawable.ic_france,
            "Finland",
            "Ukraine",
            "New Zealand",
            "France",
            4
        )

        questionsList.add(que4)


        val que5 = Question(
            5,
            "What Country does this flag belongs to?",
            R.drawable.ic_india,
            "Iceland",
            "Ireland",
            "India",
            "Iraq",
            3
        )

        questionsList.add(que5)

        val que6 = Question(
            6,
            "What Country does this flag belongs to?",
            R.drawable.ic_japan,
            "Bangladesh",
            "Japan",
            "Ukraine",
            "Russia",
            2
        )

        questionsList.add(que6)

        val que7 = Question(
            7,
            "What Country does this flag belongs to?",
            R.drawable.ic_nepal,
            "Bangladesh",
            "Brazil",
            "Ukraine",
            "Nepal",
            4
        )

        questionsList.add(que7)

        val que8 = Question(
            8,
            "What Country does this flag belongs to?",
            R.drawable.ic_brazil,
            "Nepal",
            "Brazil",
            "Ukraine",
            "New Zealand",
            2
        )

        questionsList.add(que8)

        val que9 = Question(
            9,
            "What Country does this flag belongs to?",
            R.drawable.ic_russia,
            "Russia",
            "Brazil",
            "Ukraine",
            "Nepal",
            1
        )

        questionsList.add(que9)

        val que10 = Question(
            10,
            "What Country does this flag belongs to?",
            R.drawable.ic_sri_lanka,
            "Bangladesh",
            "Sri lanka",
            "Ukraine",
            "Nepal",
            2
        )

        questionsList.add(que10)
        return questionsList
    }

}