package com.example.android.chemapp

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.games.Games
import kotlinx.android.synthetic.main.trendsinpt_options.*
import kotlinx.android.synthetic.main.trendsinpt_quiz_summary.*


class TrendsInPTQuizSummaryActivity : AppCompatActivity() {

    private var RC_LEADERBOARD_UI = 9004


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.trendsinpt_quiz_summary)


        trendsinptleaderboard_button.setOnClickListener(){

            val acc = GoogleSignIn.getLastSignedInAccount(this)
            if( acc == null){
                Toast.makeText(this, "You need to sign in!", Toast.LENGTH_SHORT).show()
            }
            else {
                Games.getLeaderboardsClient(this, acc)
                        .getLeaderboardIntent(getString(R.string.leaderboard_trendsinpt_id))
                        .addOnSuccessListener {
                            intent -> ActivityCompat.startActivityForResult(this, intent, RC_LEADERBOARD_UI, null)
                        }
            }

        }

        trendsinptreplay.setOnClickListener(){

            val intent = Intent(this@TrendsInPTQuizSummaryActivity, TrendsInPTQuizActivity::class.java)
            startActivity(intent)
            finish()

        }
    }



}


