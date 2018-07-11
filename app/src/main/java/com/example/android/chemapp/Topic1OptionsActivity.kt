package com.example.android.chemapp

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.games.Games
import kotlinx.android.synthetic.main.topic1_options.*
import kotlinx.android.synthetic.main.topic1_options.topic1Practice
import com.google.android.gms.auth.api.signin.GoogleSignInAccount



class Topic1OptionsActivity : AppCompatActivity() {


    private var RC_LEADERBOARD_UI = 9004



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.topic1_options)

        topic1Practice.setOnClickListener(){

            val intent = Intent(this@Topic1OptionsActivity, Topic1QuizActivity::class.java)
            startActivity(intent)
        }

        topic1Leaderboard.setOnClickListener(){

            val acc = GoogleSignIn.getLastSignedInAccount(this)
            if( acc == null){
                Toast.makeText(this, "You need to sign in!", Toast.LENGTH_SHORT).show()
            }
            else {
                val leaderBoardClient = Games.getLeaderboardsClient(this@Topic1OptionsActivity, acc)
                Games.getLeaderboardsClient(this, acc)
                        .getLeaderboardIntent(getString(R.string.leaderboard_atoms_ions_compounds_id))
                        .addOnSuccessListener {
                            //Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()
                            intent -> ActivityCompat.startActivityForResult(this, intent, RC_LEADERBOARD_UI, null)
                            Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()
                        }
            }

        }

    }



}


