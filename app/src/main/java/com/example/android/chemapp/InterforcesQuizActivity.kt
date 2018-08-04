package com.example.android.chemapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.games.Games
import kotlinx.android.synthetic.main.interforces_quiz.*
import java.util.*


class InterforcesQuizActivity : AppCompatActivity() {
    var Interforcesquestions = InterforcesQuestionsLibrary()
    var correctAnswer : String? = null
    var current_score = 0
    val r = Random()
    var current_questions = 0
    var total_questions = Interforcesquestions.obtainTotalNumberofQuestions()

    private lateinit var countDownTimer : CountDownTimer
    private val COUNTDOWN_IN_MILLIS : Long = 40000
    private var timeLeftInMillis : Long = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.trendsinpt_quiz)
    /**
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
**/
        interforcesscore.text = "Score: $current_score / $total_questions"
        interforcesnumQuestions.text = "Q: $current_questions / $total_questions"
        updateQuestion()

        interforcesanswer1.setOnClickListener{
            if(interforcesanswer1.text.toString() == this.correctAnswer){
                this.current_score++
                interforcesscore.text = "Score: $current_score / $total_questions"
            }
            this.current_questions++
            interforcesnumQuestions.text = "Q: $current_questions / $total_questions"
            countDownTimer.cancel()
            updateQuestion()
        }

        interforcesanswer2.setOnClickListener{
            if(interforcesanswer2.text.toString() == this.correctAnswer){
                this.current_score++
                interforcesscore.text = "Score: $current_score / $total_questions"
            }
            this.current_questions++
            interforcesnumQuestions.text = "Q: $current_questions / $total_questions"
            countDownTimer.cancel()
            updateQuestion()
        }

        interforcesanswer3.setOnClickListener{
            if(interforcesanswer3.text.toString() == this.correctAnswer){
                this.current_score++
                interforcesscore.text = "Score: $current_score / $total_questions"
            }
            this.current_questions++
            interforcesnumQuestions.text = "Q: $current_questions / $total_questions"
            countDownTimer.cancel()
            updateQuestion()
        }

        interforcesanswer4.setOnClickListener{
            if(interforcesanswer4.text.toString() == this.correctAnswer){
                this.current_score++
                interforcesscore.text = "Score: $current_score / $total_questions"
            }
            this.current_questions++
            interforcesnumQuestions.text = "Q: $current_questions / $total_questions"
            countDownTimer.cancel()
            updateQuestion()
        }
    }

    fun updateQuestion(){
        if(current_questions > total_questions){
            val acct = GoogleSignIn.getLastSignedInAccount(this)

            if(acct != null){
                Games.getLeaderboardsClient(this, acct)
                        .submitScore(getString(R.string.leaerboard_interforces_id), current_score.toLong())
            //this is a issue im unsure about.
            }


            val intent = Intent(this@InterforcesQuizActivity, InterforcesQuizSummaryActivity::class.java)
            startActivity(intent)

        }
        else{
            interforcesquestion.text = Interforcesquestions.getQuestion()

            val j = r.nextInt(4)

            if(j == 0){
                interforcesanswer1.text = Interforcesquestions.obtainCorrectAnswer()
                interforcesanswer2.text = Interforcesquestions.obtainChoice2()
                interforcesanswer3.text = Interforcesquestions.obtainChoice3()
                interforcesanswer4.text = Interforcesquestions.obtainChoice1()

            }
            else if(j == 1){

                interforcesanswer1.text = Interforcesquestions.obtainChoice2()
                interforcesanswer2.text = Interforcesquestions.obtainCorrectAnswer()
                interforcesanswer3.text = Interforcesquestions.obtainChoice3()
                interforcesanswer4.text = Interforcesquestions.obtainChoice1()

            }
            else if(j== 2){

                interforcesanswer1.text = Interforcesquestions.obtainChoice2()
                interforcesanswer2.text = Interforcesquestions.obtainChoice3()
                interforcesanswer3.text = Interforcesquestions.obtainCorrectAnswer()
                interforcesanswer4.text = Interforcesquestions.obtainChoice1()
            }
            else{

                interforcesanswer1.text = Interforcesquestions.obtainChoice2()
                interforcesanswer2.text = Interforcesquestions.obtainChoice3()
                interforcesanswer3.text = Interforcesquestions.obtainChoice1()
                interforcesanswer4.text = Interforcesquestions.obtainCorrectAnswer()
            }

            this.correctAnswer = Interforcesquestions.obtainCorrectAnswer()

            timeLeftInMillis = COUNTDOWN_IN_MILLIS
            startCountDown()
        }

    }
    private fun startCountDown(){
        interforcesprogress_countdown.max = (COUNTDOWN_IN_MILLIS / 1000).toInt()

        countDownTimer = object : CountDownTimer(timeLeftInMillis, 1000){
            override fun onFinish() {
                timeLeftInMillis = 0
                current_questions++
                interforcesnumQuestions.text = "Q: $current_questions / $total_questions"
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
        interforcestextView_countdown.text = "$minutesUntilFinished:${if (secondsStr.length == 2) secondsStr else "0" + secondsStr}"
        interforcesprogress_countdown.progress = (timerLengthSeconds - secondsRemaining).toInt()

    }

    override fun onDestroy() {
        super.onDestroy()
        if(countDownTimer != null){
            countDownTimer.cancel()
        }
    }
}