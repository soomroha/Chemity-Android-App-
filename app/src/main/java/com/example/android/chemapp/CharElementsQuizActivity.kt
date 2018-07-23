package com.example.android.chemapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.games.Games
import kotlinx.android.synthetic.main.charelements_quiz.*
import java.io.File
import java.io.InputStream
import java.util.*
import android.widget.Toast


class CharElementsQuizActivity : AppCompatActivity() {
    var CharElementsquestions = CharElementsQuestionsLibrary()
    var correctAnswer : String? = null
    var current_score = 0
    val r = Random()
    var current_questions = 0
    var total_questions = CharElementsquestions.obtainTotalNumberofQuestions()

    private lateinit var countDownTimer : CountDownTimer
    private val COUNTDOWN_IN_MILLIS : Long = 40000
    private var timeLeftInMillis : Long = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.charelements_quiz)

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
            CharElementsquestions.addElementInfo(element, symbol, atomicNumber, atomicWeight, numValence, group)
        }

        charelementsscore.text = "Score: $current_score / $total_questions"
        charelementsnumQuestions.text = "Q: $current_questions / $total_questions"
        updateQuestion()

        charelementsanswer1.setOnClickListener{
            if(charelementsanswer1.text.toString() == this.correctAnswer){
                this.current_score++
                charelementsscore.text = "Score: $current_score / $total_questions"
            }
            this.current_questions++
            charelementsnumQuestions.text = "Q: $current_questions / $total_questions"
            countDownTimer.cancel()
            updateQuestion()
        }

        charelementsanswer2.setOnClickListener{
            if(charelementsanswer2.text.toString() == this.correctAnswer){
                this.current_score++
                charelementsscore.text = "Score: $current_score / $total_questions"
            }
            this.current_questions++
            charelementsnumQuestions.text = "Q: $current_questions / $total_questions"
            countDownTimer.cancel()
            updateQuestion()
        }

        charelementsanswer3.setOnClickListener{
            if(charelementsanswer3.text.toString() == this.correctAnswer){
                this.current_score++
                charelementsscore.text = "Score: $current_score / $total_questions"
            }
            this.current_questions++
            charelementsnumQuestions.text = "Q: $current_questions / $total_questions"
            countDownTimer.cancel()
            updateQuestion()
        }

        charelementsanswer4.setOnClickListener{
            if(charelementsanswer4.text.toString() == this.correctAnswer){
                this.current_score++
                charelementsscore.text = "Score: $current_score / $total_questions"
            }
            this.current_questions++
            charelementsnumQuestions.text = "Q: $current_questions / $total_questions"
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


            val intent = Intent(this@CharElementsQuizActivity, CharElementsQuizSummaryActivity::class.java)
            startActivity(intent)

        }
        else{
            charelementsquestion.text = CharElementsquestions.getQuestion()

            val j = r.nextInt(4)

            if(j == 0){
                charelementsanswer1.text = CharElementsquestions.obtainCorrectAnswer()
                charelementsanswer2.text = CharElementsquestions.obtainChoice2()
                charelementsanswer3.text = CharElementsquestions.obtainChoice3()
                charelementsanswer4.text = CharElementsquestions.obtainChoice1()

            }
            else if(j == 1){

                charelementsanswer1.text = CharElementsquestions.obtainChoice2()
                charelementsanswer2.text = CharElementsquestions.obtainCorrectAnswer()
                charelementsanswer3.text = CharElementsquestions.obtainChoice3()
                charelementsanswer4.text = CharElementsquestions.obtainChoice1()

            }
            else if(j== 2){

                charelementsanswer1.text = CharElementsquestions.obtainChoice2()
                charelementsanswer2.text = CharElementsquestions.obtainChoice3()
                charelementsanswer3.text = CharElementsquestions.obtainCorrectAnswer()
                charelementsanswer4.text = CharElementsquestions.obtainChoice1()
            }
            else{

                charelementsanswer1.text = CharElementsquestions.obtainChoice2()
                charelementsanswer2.text = CharElementsquestions.obtainChoice3()
                charelementsanswer3.text = CharElementsquestions.obtainChoice1()
                charelementsanswer4.text = CharElementsquestions.obtainCorrectAnswer()
            }

            this.correctAnswer = CharElementsquestions.obtainCorrectAnswer()

            timeLeftInMillis = COUNTDOWN_IN_MILLIS
            startCountDown()
        }

    }
    private fun startCountDown(){
        charelementsprogress_countdown.max = (COUNTDOWN_IN_MILLIS / 1000).toInt()

        countDownTimer = object : CountDownTimer(timeLeftInMillis, 1000){
            override fun onFinish() {
                timeLeftInMillis = 0
                current_questions++
                charelementsnumQuestions.text = "Q: $current_questions / $total_questions"
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
        charelementstextView_countdown.text = "$minutesUntilFinished:${if (secondsStr.length == 2) secondsStr else "0" + secondsStr}"
        charelementsprogress_countdown.progress = (timerLengthSeconds - secondsRemaining).toInt()

    }

    override fun onDestroy() {
        super.onDestroy()
        if(countDownTimer != null){
            countDownTimer.cancel()
        }
    }
}