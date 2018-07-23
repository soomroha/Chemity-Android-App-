package com.example.android.chemapp

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.games.Games
import kotlinx.android.synthetic.main.topicperiodictable_quiz_summary.*

// change name to correct class
class TopicPeriodicTableQuizSummaryActivity : AppCompatActivity() {
    private var RC_LEADERBOARD_UI = 9004


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.topicperiodictable_quiz_summary)

        //change button names to match properly no overlap
        topicperiodictableleaderboard_button.setOnClickListener() {

            val acc = GoogleSignIn.getLastSignedInAccount(this)
            if (acc == null) {
                Toast.makeText(this, "You need to sign in!", Toast.LENGTH_SHORT).show()
            } else {
                Games.getLeaderboardsClient(this, acc)
                        //change leaderboardname
                        .getLeaderboardIntent(getString(R.string.leaderboard_periodic_table_id))
                        .addOnSuccessListener { intent ->
                            ActivityCompat.startActivityForResult(this, intent, RC_LEADERBOARD_UI, null)
                        }
            }

        }

        //change button listening to
        topicperiodictablereplay.setOnClickListener() {
            //change intent here
            val intent = Intent(this@TopicPeriodicTableQuizSummaryActivity, TopicPeriodicTableQuizActivity::class.java)
            startActivity(intent)
            finish()

        }
    }
}