package com.voidd.pillcaddy.homepage

import android.view.View
import androidx.lifecycle.ViewModel
import com.voidd.pillcaddy.auth.AuthListener
import com.voidd.pillcaddy.repositories.UserRepository
import com.voidd.pillcaddy.utils.startSignInActivity

class HomeViewModel(
    private val repository: UserRepository
) : ViewModel() {


    val user by lazy {
        repository.currentUser()
    }

    fun signout(view: View){
        repository.signOut()
        view.context.startSignInActivity()
    }
}