package com.filmeagora.filmeagora.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.facebook.AccessToken
import com.filmeagora.filmeagora.R
import kotlinx.android.synthetic.main.activity_user_profile.*


class UserProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)


        val accessToken = AccessToken.getCurrentAccessToken()
        val isLoggedIn = accessToken != null && !accessToken.isExpired

        if (isLoggedIn) {
            mainText.text = accessToken?.source.toString()
        }

    }
}