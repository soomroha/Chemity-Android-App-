package com.example.android.chemapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.games.Games
import kotlinx.android.synthetic.main.trendsinpt_quiz.*
import java.io.File
import java.io.InputStream
import java.util.*
import android.widget.Toast


class TrendsInPTQuizActivity : AppCompatActivity() {
    var trendsinptquestions = TrendsInPTQuestionsLibrary()
    var correctAnswer : String? = null
    var current_score = 0
    val r = Random()
    var current_questions = 0
    var total_questions = trendsinptquestions.obtainTotalNumberofQuestions()

    private lateinit var countDownTimer : CountDownTimer
    private val COUNTDOWN_IN_MILLIS : Long = 40000
    private var timeLeftInMillis : Long = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.trendsinpt_quiz)

        var lineList = mutableListOf<String>()

        applicationContext.assets.open("trendsinptinfo.txt").bufferedReader().useLines { lines -> lines.forEach { lineList.add(it) } }
        lineList.forEach{

            val str = it.split("\\s".toRegex())
            val element = str[0]
            val atomicradii = Math.ceil(str[1].toDouble()).toInt().toString()
            val electronegative = Math.ceil(str[2].toDouble()).toInt().toString()
            val atomicafine = Math.ceil(str[3].toDouble()).toInt().toString()
            trendsinptquestions.addElementInfo(element, atomicradii,electronegative,atomicafine)
        }

        trendsinptscore.text = "Score: $current_score / $total_questions"
        trendsinptnumQuestions.text = "Q: $current_questions / $total_questions"
        updateQuestion()

        trendsinptanswer1.setOnClickListener{
            if(trendsinptanswer1.text.toString() == this.correctAnswer){
                this.current_score++
                trendsinptscore.text = "Score: $current_score / $total_questions"
            }
            this.current_questions++
            trendsinptnumQuestions.text = "Q: $current_questions / $total_questions"
            countDownTimer.cancel()
            updateQuestion()
        }

        trendsinptanswer2.setOnClickListener{
            if(trendsinptanswer2.text.toString() == this.correctAnswer){
                this.current_score++
                trendsinptscore.text = "Score: $current_score / $total_questions"
            }
            this.current_questions++
            trendsinptnumQuestions.text = "Q: $current_questions / $total_questions"
            countDownTimer.cancel()
            updateQuestion()
        }

        trendsinptanswer3.setOnClickListener{
            if(trendsinptanswer3.text.toString() == this.correctAnswer){
                this.current_score++
                trendsinptscore.text = "Score: $current_score / $total_questions"
            }
            this.current_questions++
            trendsinptnumQuestions.text = "Q: $current_questions / $total_questions"
            countDownTimer.cancel()
            updateQuestion()
        }

        trendsinptanswer4.setOnClickListener{
            if(trendsinptanswer4.text.toString() == this.correctAnswer){
                this.current_score++
                trendsinptscore.text = "Score: $current_score / $total_questions"
            }
            this.current_questions++
            trendsinptnumQuestions.text = "Q: $current_questions / $total_questions"
            countDownTimer.cancel()
            updateQuestion()
        }
    }

    fun updateQuestion(){
        if(current_questions > total_questions){
            val acct = GoogleSignIn.getLastSignedInAccount(this)

            if(acct != null){
                Games.getLeaderboardsClient(this, acct)
                        .submitScore(getString(R.string.leaderboard_trendsinpt_id), current_score.toLong())
            //this is a issue im unsure about.
            }


            val intent = Intent(this@TrendsInPTQuizActivity, TrendsInPTQuizSummaryActivity::class.java)
            startActivity(intent)

        }
        else{
            trendsinptquestion.text = trendsinptquestions.getQuestion()

            val j = r.nextInt(4)

            if(j == 0){
                trendsinptanswer1.text = trendsinptquestions.obtainCorrectAnswer()
                trendsinptanswer2.text = trendsinptquestions.obtainChoice2()
                trendsinptanswer3.text = trendsinptquestions.obtainChoice3()
                trendsinptanswer4.text = trendsinptquestions.obtainChoice1()

            }
            else if(j == 1){

                trendsinptanswer1.text = trendsinptquestions.obtainChoice2()
                trendsinptanswer2.text = trendsinptquestions.obtainCorrectAnswer()
                trendsinptanswer3.text = trendsinptquestions.obtainChoice3()
                trendsinptanswer4.text = trendsinptquestions.obtainChoice1()

            }
            else if(j== 2){

                trendsinptanswer1.text = trendsinptquestions.obtainChoice2()
                trendsinptanswer2.text = trendsinptquestions.obtainChoice3()
                trendsinptanswer3.text = trendsinptquestions.obtainCorrectAnswer()
                trendsinptanswer4.text = trendsinptquestions.obtainChoice1()
            }
            else{

                trendsinptanswer1.text = trendsinptquestions.obtainChoice2()
                trendsinptanswer2.text = trendsinptquestions.obtainChoice3()
                trendsinptanswer3.text = trendsinptquestions.obtainChoice1()
                trendsinptanswer4.text = trendsinptquestions.obtainCorrectAnswer()
            }

            this.correctAnswer = trendsinptquestions.obtainCorrectAnswer()

            timeLeftInMillis = COUNTDOWN_IN_MILLIS
            startCountDown()
        }

    }
    private fun startCountDown(){
        trendsinptprogress_countdown.max = (COUNTDOWN_IN_MILLIS / 1000).toInt()

        countDownTimer = object : CountDownTimer(timeLeftInMillis, 1000){
            override fun onFinish() {
                timeLeftInMillis = 0
                current_questions++
                trendsinptnumQuestions.text = "Q: $current_questions / $total_questions"
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
        trendsinpttextView_countdown.text = "$minutesUntilFinished:${if (secondsStr.length == 2) secondsStr else "0" + secondsStr}"
        trendsinptprogress_countdown.progress = (timerLengthSeconds - secondsRemaining).toInt()

    }

    override fun onDestroy() {
        super.onDestroy()
        if(countDownTimer != null){
            countDownTimer.cancel()
        }
    }
}