package com.adhityaprimandhika.tix.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.adhityaprimandhika.tix.R
import com.adhityaprimandhika.tix.sign.login.LoginActivity
import com.adhityaprimandhika.tix.utils.Preferences

class OnboardingThreeActivity : AppCompatActivity() {

    private lateinit var preferences : Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_three)

        preferences = Preferences(this)
        if (preferences.getValues("onboarding").equals("1")) {
            finishAffinity()

            val getStartedIntent = Intent(this@OnboardingThreeActivity, LoginActivity::class.java)
            startActivity(getStartedIntent)
        }
        val btnGetStarted : Button = findViewById(R.id.btn_get_started)
        btnGetStarted.setOnClickListener {
            preferences.setValues("onboarding", "1")
            finishAffinity()

            val getStartedIntent = Intent(this@OnboardingThreeActivity, LoginActivity::class.java)
            startActivity(getStartedIntent)
        }
    }
}