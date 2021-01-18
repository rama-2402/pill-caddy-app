package com.voidd.pillcaddy.utils

import android.content.Context
import android.content.Intent
import android.view.View
import com.voidd.pillcaddy.auth.SignInActivity
import com.voidd.pillcaddy.auth.SignUpActivity
import com.voidd.pillcaddy.homepage.HomeActivity

fun Context.startHomeActivity() = Intent(this, HomeActivity::class.java)
    .also {
    it.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
    startActivity(it)
}


fun Context.startSignInActivity() = Intent(this, SignInActivity::class.java).also {
    it.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
    startActivity(it)

}


