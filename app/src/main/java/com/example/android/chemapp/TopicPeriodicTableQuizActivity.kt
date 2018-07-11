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
import kotlinx.android.synthetic.main.topic1_quiz.*

class TopicPeriodicTableQuizActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.topicperiodictable_quiz)
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