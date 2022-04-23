package com.filmeagora.filmeagora

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.facebook.*
import com.facebook.login.LoginResult
import com.filmeagora.filmeagora.presentation.UserProfile
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private final val TAG = "RESULT ===>>> "
    val callbackManager: CallbackManager = CallbackManager.Factory.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        goProfile.setOnClickListener() {
            val intent = Intent(this, UserProfile::class.java)
            startActivity(intent)
        }

        login_button.registerCallback(callbackManager, object : FacebookCallback<LoginResult?> {

            @JvmName("onSuccess1")
            fun onSuccess(loginResult: LoginResult) {
                // App code
            }
            override fun onCancel() {
                Log.i(TAG, "Cancel")
            }

            override fun onError(error: FacebookException) {
                Log.i(TAG, "Error = $error")
            }

            override fun onSuccess(result: LoginResult?) {
                Log.i(TAG, "Sucess $result")
            }
        })
    }

//    @Deprecated("Deprecated in Java")
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        callbackManager.onActivityResult(requestCode, resultCode, data)
//        super.onActivityResult(requestCode, resultCode, data)
//    }


}
