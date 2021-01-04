package com.adhityaprimandhika.tix.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.adhityaprimandhika.tix.R
import com.adhityaprimandhika.tix.sign.login.LoginActivity
import com.adhityaprimandhika.tix.utils.Preferences

class OnboardingTwoActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var preference : Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_two)

        preference = Preferences(this)
        if (preference.getValues("onboarding").equals("1")) {
            finishAffinity()

            val skipIntent = Intent(this@OnboardingTwoActivity, LoginActivity::class.java)
            startActivity(skipIntent)
        }
        val btnNext : Button = findViewById(R.id.btn_next)
        btnNext.setOnClickListener(this)
        val btnSkip : Button = findViewById(R.id.btn_skip)
        btnSkip.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.btn_next->{
                val nextIntent = Intent(this@OnboardingTwoActivity, OnboardingThreeActivity::class.java)
                startActivity(nextIntent)
            }
            R.id.btn_skip->{
                preference.setValues("onboarding", "1")
                finishAffinity()

                val skipIntent = Intent(this@OnboardingTwoActivity, LoginActivity::class.java)
                startActivity(skipIntent)
            }
        }
    }
}