package com.voidd.pillcaddy.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.voidd.pillcaddy.R
import com.voidd.pillcaddy.databinding.ActivitySignUpBinding
import com.voidd.pillcaddy.utils.startHomeActivity
//import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.activity_sign_up.*
//import kotlinx.android.synthetic.main.activity_sign_up.progressbar
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance
import kotlinx.android.synthetic.main.activity_sign_up.progressbar as progressbar1

class SignUpActivity : AppCompatActivity(), KodeinAware, AuthListener {

    override val kodein by kodein()
    private val factory: AuthViewModelFactory by instance()

    private lateinit var viewModel: AuthViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivitySignUpBinding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        viewModel = ViewModelProvider(this, factory).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel

        viewModel.authListener = this

        YoYo.with(Techniques.BounceInRight).duration(1500).playOn(signup_layout)

    }

    override fun moveSignIn(){
        startActivity(Intent(this,SignInActivity::class.java))
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right)
    }

    override fun onSuccess() {
        progressbar1.visibility = View.GONE
        startHomeActivity()
    }

    override fun onStarted() {
        progressbar1.visibility = View.VISIBLE
    }

    override fun onFailure(message: String) {
        progressbar1.visibility = View.GONE
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        viewModel.user?.let {
            startHomeActivity()
        }
    }
}