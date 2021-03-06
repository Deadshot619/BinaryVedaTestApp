package com.example.binaryvedatestapp.ui.splash

import android.content.Intent
import androidx.activity.viewModels
import com.example.binaryvedatestapp.databinding.ActivitySplashBinding
import com.example.binaryvedatestapp.ui.base.BaseActivity
import com.example.binaryvedatestapp.ui.home.HomeActivity
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.ticker
import kotlinx.coroutines.launch

class SplashActivity : BaseActivity<SplashViewModel, ActivitySplashBinding>() {

    override val mViewModel: SplashViewModel by viewModels()
    override fun getViewBinding() = ActivitySplashBinding.inflate(layoutInflater)

    private val mainScope = MainScope()

    override fun onBinding() {
        goToNextScreen()
    }

    private fun goToNextScreen(){
        mainScope.launch {
            ticker(WAIT_DURATION).receive()
            this@SplashActivity.startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
            this@SplashActivity.finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mainScope.cancel()
    }

    companion object {
        private const val WAIT_DURATION = 3000L
    }
}