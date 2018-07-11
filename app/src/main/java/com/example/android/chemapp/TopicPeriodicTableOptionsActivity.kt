package com.example.android.chemapp

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.games.Games
import kotlinx.android.synthetic.main.topicperiodictable_options.*
import kotlinx.android.synthetic.main.topicperiodictable_options.topicperiodictablePractice
import com.google.android.gms.auth.api.signin.GoogleSignInAccount

class TopicPeriodicTableOptionsActivity : AppCompatActivity() {

    private var RC_LEADERBOARD_UI = 9004

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.topicperiodictable_options)
        Toast.makeText(this, "Test Test", Toast.LENGTH_SHORT).show()

        topicperiodictablePractice.setOnClickListener(){
            val intent = Intent(this@TopicPeriodicTableOptionsActivity, TopicPeriodicTableQuizActivity::class.java)
            startActivity(intent)
        }
        /**
        topicPeriodicTableLeaderboard.setOnClickListener(){

        val acc = GoogleSignIn.getLastSignedInAccount(this)
        if( acc == null){
        Toast.makeText(this, "You need to sign in!", Toast.LENGTH_SHORT).show()
        }
        else {
        val leaderBoardClient = Games.getLeaderboardsClient(this@TopicPeriodicTableOptionsActivity, acc)
        Games.getLeaderboardsClient(this, acc)
        .getLeaderboardIntent(getString(R.string.leaderboard_atoms_ions_compounds_id))
        .addOnSuccessListener {
        //Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()
        intent -> ActivityCompat.startActivityForResult(this, intent, RC_LEADERBOARD_UI, null)
        Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()
        }
        }

        }
         */
    }



}