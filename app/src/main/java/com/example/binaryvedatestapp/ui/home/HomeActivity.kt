package com.example.binaryvedatestapp.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.binaryvedatestapp.R
import com.example.binaryvedatestapp.databinding.ActivityHomeBinding
import com.example.binaryvedatestapp.ui.base.BaseActivity
import com.example.binaryvedatestapp.ui.profile.ProfileActivity
import com.google.android.material.button.MaterialButton

class HomeActivity : BaseActivity<HomeViewModel, ActivityHomeBinding>() {
    override val mViewModel: HomeViewModel by viewModels()
    override fun getViewBinding() = ActivityHomeBinding.inflate(layoutInflater)

    private lateinit var mBtnRegister: MaterialButton

    override fun onBinding() {
        initViews()
        setUpClickListeners()
    }

    private fun initViews(){
        mViewBinding.run {
            mBtnRegister = btnRegister
        }
    }

    private fun setUpClickListeners(){
        mBtnRegister.setOnClickListener {
            goToNextPage()
        }
    }

    private fun goToNextPage(){
        startActivity(Intent(this, ProfileActivity::class.java))
    }
}