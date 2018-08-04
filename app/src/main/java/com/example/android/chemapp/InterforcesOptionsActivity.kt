package com.example.android.chemapp

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.games.Games
import kotlinx.android.synthetic.main.interforces_options.*
import kotlinx.android.synthetic.main.interforces_options.interforcesPractice


class InterforcesOptionsActivity : AppCompatActivity() {


    private var RC_LEADERBOARD_UI = 9004



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.interforces_options)

        interforcesPractice.setOnClickListener(){
            val intent = Intent(this@InterforcesOptionsActivity, InterforcesQuizActivity::class.java)
            startActivity(intent)
        }

        interforcesLeaderboard.setOnClickListener(){

            val acc = GoogleSignIn.getLastSignedInAccount(this)
            if( acc == null){
                Toast.makeText(this, "You need to sign in!", Toast.LENGTH_SHORT).show()
            }
            else {
                val leaderBoardClient = Games.getLeaderboardsClient(this@InterforcesOptionsActivity, acc)
                Games.getLeaderboardsClient(this, acc)

                        .getLeaderboardIntent(getString(R.string.leaerboard_interforces_id))
                        .addOnSuccessListener {
                            intent -> ActivityCompat.startActivityForResult(this, intent, RC_LEADERBOARD_UI, null)
                            Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()
                        }
            }

        }

    }



}


