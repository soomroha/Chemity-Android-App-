package com.example.android.chemapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.games.Games
import kotlinx.android.synthetic.main.topicperiodictable_quiz.*
import java.io.File
import java.io.InputStream
import java.util.*
import android.widget.Toast


class TopicPeriodicTableQuizActivity : AppCompatActivity() {
    var topicperiodictablequestions = TopicPeriodicTableQuestionsLibrary()
    var correctAnswer : String? = null
    var current_score = 0
    val r = Random()
    var current_questions = 0
    var total_questions = topicperiodictablequestions.obtainTotalNumberofQuestions()

    private lateinit var countDownTimer : CountDownTimer
    private val COUNTDOWN_IN_MILLIS : Long = 40000
    private var timeLeftInMillis : Long = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.topicperiodictable_quiz)

        var lineList = mutableListOf<String>()

        applicationContext.assets.open("element_info.txt").bufferedReader().useLines { lines -> lines.forEach { lineList.add(it) } }
        lineList.forEach{

            val str = it.split("\\s".toRegex())
            val element = str[0]
            val symbol = str[1]
            val atomicNumber = str[2]
            val atomicWeight = Math.ceil(str[3].toDouble()).toInt().toString()
            val numValence = Math.ceil(str[5].toDouble()).toInt().toString()
            val group = str[6]
            topicperiodictablequestions.addElementInfo(element, symbol, atomicNumber, atomicWeight, numValence, group)
        }

        topicperiodictablescore.text = "Score: $current_score / $total_questions"
        topicperiodictablenumQuestions.text = "Q: $current_questions / $total_questions"
        updateQuestion()

        topicperiodictableanswer1.setOnClickListener{
            if(topicperiodictableanswer1.text.toString() == this.correctAnswer){
                this.current_score++
                topicperiodictablescore.text = "Score: $current_score / $total_questions"
            }
            this.current_questions++
            topicperiodictablenumQuestions.text = "Q: $current_questions / $total_questions"
            countDownTimer.cancel()
            updateQuestion()
        }

        topicperiodictableanswer2.setOnClickListener{
            if(topicperiodictableanswer2.text.toString() == this.correctAnswer){
                this.current_score++
                topicperiodictablescore.text = "Score: $current_score / $total_questions"
            }
            this.current_questions++
            topicperiodictablenumQuestions.text = "Q: $current_questions / $total_questions"
            countDownTimer.cancel()
            updateQuestion()
        }

        topicperiodictableanswer3.setOnClickListener{
            if(topicperiodictableanswer3.text.toString() == this.correctAnswer){
                this.current_score++
                topicperiodictablescore.text = "Score: $current_score / $total_questions"
            }
            this.current_questions++
            topicperiodictablenumQuestions.text = "Q: $current_questions / $total_questions"
            countDownTimer.cancel()
            updateQuestion()
        }

        topicperiodictableanswer4.setOnClickListener{
            if(topicperiodictableanswer4.text.toString() == this.correctAnswer){
                this.current_score++
                topicperiodictablescore.text = "Score: $current_score / $total_questions"
            }
            this.current_questions++
            topicperiodictablenumQuestions.text = "Q: $current_questions / $total_questions"
            countDownTimer.cancel()
            updateQuestion()
        }
    }

    fun updateQuestion(){
        if(current_questions > total_questions){
            val acct = GoogleSignIn.getLastSignedInAccount(this)

            if(acct != null){
                Games.getLeaderboardsClient(this, acct)
                        .submitScore(getString(R.string.leaderboard_periodic_table_id), current_score.toLong())
            //this is a issue im unsure about.
            }


            val intent = Intent(this@TopicPeriodicTableQuizActivity, TopicPeriodicTableQuizSummaryActivity::class.java)
            startActivity(intent)

        }
        else{
            topicperiodictablequestion.text = topicperiodictablequestions.getQuestion()

            val j = r.nextInt(4)

            if(j == 0){
                topicperiodictableanswer1.text = topicperiodictablequestions.obtainCorrectAnswer()
                topicperiodictableanswer2.text = topicperiodictablequestions.obtainChoice2()
                topicperiodictableanswer3.text = topicperiodictablequestions.obtainChoice3()
                topicperiodictableanswer4.text = topicperiodictablequestions.obtainChoice1()

            }
            else if(j == 1){

                topicperiodictableanswer1.text = topicperiodictablequestions.obtainChoice2()
                topicperiodictableanswer2.text = topicperiodictablequestions.obtainCorrectAnswer()
                topicperiodictableanswer3.text = topicperiodictablequestions.obtainChoice3()
                topicperiodictableanswer4.text = topicperiodictablequestions.obtainChoice1()

            }
            else if(j== 2){

                topicperiodictableanswer1.text = topicperiodictablequestions.obtainChoice2()
                topicperiodictableanswer2.text = topicperiodictablequestions.obtainChoice3()
                topicperiodictableanswer3.text = topicperiodictablequestions.obtainCorrectAnswer()
                topicperiodictableanswer4.text = topicperiodictablequestions.obtainChoice1()
            }
            else{

                topicperiodictableanswer1.text = topicperiodictablequestions.obtainChoice2()
                topicperiodictableanswer2.text = topicperiodictablequestions.obtainChoice3()
                topicperiodictableanswer3.text = topicperiodictablequestions.obtainChoice1()
                topicperiodictableanswer4.text = topicperiodictablequestions.obtainCorrectAnswer()
            }

            this.correctAnswer = topicperiodictablequestions.obtainCorrectAnswer()

            timeLeftInMillis = COUNTDOWN_IN_MILLIS
            startCountDown()
        }

    }
    private fun startCountDown(){
        topicperiodictableprogress_countdown.max = (COUNTDOWN_IN_MILLIS / 1000).toInt()

        countDownTimer = object : CountDownTimer(timeLeftInMillis, 1000){
            override fun onFinish() {
                timeLeftInMillis = 0
                current_questions++
                topicperiodictablenumQuestions.text = "Q: $current_questions / $total_questions"
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
        topicperiodictabletextView_countdown.text = "$minutesUntilFinished:${if (secondsStr.length == 2) secondsStr else "0" + secondsStr}"
        topicperiodictableprogress_countdown.progress = (timerLengthSeconds - secondsRemaining).toInt()

    }

    override fun onDestroy() {
        super.onDestroy()
        if(countDownTimer != null){
            countDownTimer.cancel()
        }
    }
}