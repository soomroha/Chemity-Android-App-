package com.example.android.chemapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.ActionBar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.google.android.gms.auth.api.signin.GoogleSignIn
import kotlinx.android.synthetic.main.activity_main.*
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import android.R.attr.data
import android.support.v7.app.AlertDialog
import android.widget.Toast
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInResult
import com.google.android.gms.tasks.Task
import android.support.annotation.NonNull
import android.support.v4.app.FragmentActivity
import android.util.Log
import android.widget.Toolbar
import com.bumptech.glide.Glide
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.games.Games.signOut
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.internal.service.Common
import com.google.android.gms.games.Games
import com.google.android.gms.signin.SignIn


val RC_SIGN_IN = 1

class MainActivity : AppCompatActivity() {

    lateinit var toolbar: ActionBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        //setSupportActionBar(findViewById(R.id.toolbar))



        // Google Sign In

        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .requestScopes(Games.SCOPE_GAMES_LITE)
                .build()



        // Build a GoogleSignInClient with the options specified by gso.
        var mGoogleSignInClient = GoogleSignIn.getClient(this, gso);




        //toolbar = supportActionBar!!

        val bottomNavigation: BottomNavigationView = findViewById(R.id.navigationView)

        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)


        topic1.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View): Unit {
                // Handler code here.
                val intent = Intent(this@MainActivity, Topic1OptionsActivity::class.java)
                startActivity(intent)
            }
        })
        topicperiodictable.setOnClickListener(object: View.OnClickListener {
            override  fun onClick(view: View): Unit {
                //for periodic table section
                val intent = Intent(this@MainActivity , TopicPeriodicTableOptionsActivity::class.java)
                startActivity(intent)
            }
        })
        characteristicselement.setOnClickListener(object: View.OnClickListener {
            override  fun onClick(view: View): Unit {
                //for CharElement section
                val intent = Intent(this@MainActivity , CharElementsOptionsActivity::class.java)
                startActivity(intent)
            }
        })



    }

    override fun onStart() {
        super.onStart()
        // Check for existing Google Sign In account, if the user is already signed in
        // the GoogleSignInAccount will be non-null.
        val acct = GoogleSignIn.getLastSignedInAccount(this)

        if (acct != null) {
            val personName = acct.displayName
            val personGivenName = acct.givenName
            val personFamilyName = acct.familyName
            val personEmail = acct.familyName
            val personId = acct.id
            val personPhoto = acct.photoUrl


        }

        // User has signed out
        else{

        }


    }


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {

            R.id.learn -> {


                return@OnNavigationItemSelectedListener true
            }
            R.id.practice -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.tools -> {

                return@OnNavigationItemSelectedListener true
            }

            R.id.leaderboard -> {

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.topbar, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId

        if (id == R.id.signin) {

            signIn()

        }
        else if(R.id.signout == id){

            signOut()


        }
        return super.onOptionsItemSelected(item)
    }


    private fun signOut() {
        val signInClient = GoogleSignIn.getClient(this,
        GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN)
        signInClient.signOut().addOnCompleteListener(this
        ) {
    // at this point, the user is signed out.
            Toast.makeText(this, "You signed out!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun signIn() {

        var account = GoogleSignIn.getLastSignedInAccount(this)


        if(account == null){
            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestEmail()
                    .requestScopes(Games.SCOPE_GAMES_LITE)
                    .build()

            val signInIntent = GoogleSignIn.getClient(this, gso).signInIntent

            startActivityForResult(signInIntent, RC_SIGN_IN)

        }
        else{
            Toast.makeText(this, "You are already signed in as ${account.displayName}", Toast.LENGTH_SHORT).show()
        }

    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)



            // Signed in successfully, show authenticated UI.
        } catch (e: ApiException) {

            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            val TAG = MainActivity::class.java.simpleName
            Log.e(TAG, "signInResult:failed code=" + e.statusCode)
        }

    }



}
