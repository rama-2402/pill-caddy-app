package com.voidd.pillcaddy.auth

import android.view.View

interface AuthListener {

    fun onSuccess()
    fun onStarted()
    fun onFailure(message: String)
    fun moveSignIn()
}