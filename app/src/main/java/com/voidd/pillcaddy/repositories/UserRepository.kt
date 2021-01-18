package com.voidd.pillcaddy.repositories

import com.google.firebase.auth.FirebaseAuth
import com.voidd.pillcaddy.firebase.FirebaseSource

class UserRepository (private val firebase: FirebaseSource) {

    fun login (email: String, password: String) = firebase.login(email,password)

    fun register(email: String, password: String) = firebase.register(email, password)

    fun signOut() = firebase.signOut()

    fun currentUser() = firebase.currentUser()

}

