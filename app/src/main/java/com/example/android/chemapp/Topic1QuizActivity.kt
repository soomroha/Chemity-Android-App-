package com.example.android.chemapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.games.Games
import kotlinx.android.synthetic.main.topic1_quiz.*
import java.io.File
import java.io.InputStream
import java.util.*


class Topic1QuizActivity : AppCompatActivity() {

    var questions = Topic1QuestionsLibrary()

    var correctAnswer : String? = null

    var current_score = 0

    val r = Random()

    var current_questions = 0

    var total_questions = questions.obtainTotalNumberofQuestions()

    private lateinit var countDownTimer : CountDownTimer
    private val COUNTDOWN_IN_MILLIS : Long = 40000
    private var timeLeftInMillis : Long = 0




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.topic1_quiz)

        // .........

        var lineList = mutableListOf<String>()


        applicationContext.assets.open("compounds.txt").bufferedReader().useLines { lines -> lines.forEach { lineList.add(it) } }
        lineList.forEach{

            val list = it.split(" - ", " -", " = ")
            if(0 < list.size){
                questions.addFormula(list[0])
            }
            if(1 < list.size){
                questions.addName(list[1])
            }
        }

        lineList = mutableListOf<String>()

        applicationContext.assets.open("element_info.txt").bufferedReader().useLines { lines -> lines.forEach { lineList.add(it) } }
        lineList.forEach{

            val str = it.split("\\s".toRegex())
            val element = str[0]
            val symbol = str[1]
            val atomicNumber = str[2]
            val atomicWeight = Math.ceil(str[3].toDouble()).toInt().toString()

            questions.addElementInfo(element, symbol, atomicNumber, atomicWeight)
        }

        lineList = mutableListOf<String>()

        applicationContext.assets.open("charges.txt").bufferedReader().useLines { lines -> lines.forEach { lineList.add(it) } }
        lineList.forEach{

            val str = it.split("\\s".toRegex())
            questions.addElementCharge(str[1], str[2])
        }






        // .........



        score.text = "Score: $current_score / $total_questions"

        numQuestions.text = "Q: $current_questions / $total_questions"

        updateQuestion()

        answer1.setOnClickListener{
            if(answer1.text.toString() == this.correctAnswer){
                this.current_score++
                score.text = "Score: $current_score / $total_questions"
            }
            this.current_questions++
            numQuestions.text = "Q: $current_questions / $total_questions"
            countDownTimer.cancel()
            updateQuestion()
        }

        answer2.setOnClickListener{
            if(answer2.text.toString() == this.correctAnswer){
                this.current_score++
                score.text = "Score: $current_score / $total_questions"
            }
            this.current_questions++
            numQuestions.text = "Q: $current_questions / $total_questions"
            countDownTimer.cancel()
            updateQuestion()
        }

        answer3.setOnClickListener{
            if(answer3.text.toString() == this.correctAnswer){
                this.current_score++
                score.text = "Score: $current_score / $total_questions"
            }
            this.current_questions++
            numQuestions.text = "Q: $current_questions / $total_questions"
            countDownTimer.cancel()
            updateQuestion()
        }

        answer4.setOnClickListener{
            if(answer4.text.toString() == this.correctAnswer){
                this.current_score++
                score.text = "Score: $current_score / $total_questions"
            }
            this.current_questions++
            numQuestions.text = "Q: $current_questions / $total_questions"
            countDownTimer.cancel()
            updateQuestion()
        }

    }


    fun updateQuestion(){

        if(current_questions > total_questions){

            val acct = GoogleSignIn.getLastSignedInAccount(this)

            if(acct != null){

                Games.getLeaderboardsClient(this, acct)
                        .submitScore(getString(R.string.leaderboard_atoms_ions_compounds_id), current_score.toLong())

            }


            val intent = Intent(this@Topic1QuizActivity, Topic1QuizSummaryActivity::class.java)
            startActivity(intent)

        }
        else{
            question.text = questions.getQuestion()

            val j = r.nextInt(4)

            if(j == 0){
                answer1.text = questions.obtainCorrectAnswer()
                answer2.text = questions.obtainChoice2()
                answer3.text = questions.obtainChoice3()
                answer4.text = questions.obtainChoice1()

            }
            else if(j == 1){

                answer1.text = questions.obtainChoice2()
                answer2.text = questions.obtainCorrectAnswer()
                answer3.text = questions.obtainChoice3()
                answer4.text = questions.obtainChoice1()

            }
            else if(j== 2){

                answer1.text = questions.obtainChoice2()
                answer2.text = questions.obtainChoice3()
                answer3.text = questions.obtainCorrectAnswer()
                answer4.text = questions.obtainChoice1()
            }
            else{

                answer1.text = questions.obtainChoice2()
                answer2.text = questions.obtainChoice3()
                answer3.text = questions.obtainChoice1()
                answer4.text = questions.obtainCorrectAnswer()
            }

            this.correctAnswer = questions.obtainCorrectAnswer()

            timeLeftInMillis = COUNTDOWN_IN_MILLIS
            startCountDown()
        }

    }

    private fun startCountDown(){

        progress_countdown.max = (COUNTDOWN_IN_MILLIS / 1000).toInt()

        countDownTimer = object : CountDownTimer(timeLeftInMillis, 1000){
            override fun onFinish() {
                timeLeftInMillis = 0
                current_questions++
                numQuestions.text = "Q: $current_questions / $total_questions"
                updateCountdownUI()
                updateQuestion()

            }

            override fun onTick(p0: Long) {
                timeLeftInMillis = p0
                updateCountdownUI()
            }
        }.start()

    }


    private fun updateCountdownUI(){

        val secondsRemaining = timeLeftInMillis / 1000
        val timerLengthSeconds = COUNTDOWN_IN_MILLIS / 1000
        val minutesUntilFinished = secondsRemaining / 60
        val secondsInMinuteUntilFinished = secondsRemaining - minutesUntilFinished * 60
        val secondsStr = secondsInMinuteUntilFinished.toString()
        textView_countdown.text = "$minutesUntilFinished:${if (secondsStr.length == 2) secondsStr else "0" + secondsStr}"
        progress_countdown.progress = (timerLengthSeconds - secondsRemaining).toInt()

    }

    override fun onDestroy() {
        super.onDestroy()
        if(countDownTimer != null){
            countDownTimer.cancel()
        }
    }
}
