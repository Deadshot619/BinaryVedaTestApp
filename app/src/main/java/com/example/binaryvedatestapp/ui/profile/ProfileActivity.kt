package com.example.binaryvedatestapp.ui.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.example.binaryvedatestapp.databinding.ActivityProfileBinding
import com.example.binaryvedatestapp.ui.base.BaseActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ProfileActivity : BaseActivity<ProfileViewModel, ActivityProfileBinding>() {
    override val mViewModel: ProfileViewModel by viewModels()
    override fun getViewBinding() = ActivityProfileBinding.inflate(layoutInflater)

    private lateinit var mTlProfile: TabLayout
    private lateinit var mVpProfile: ViewPager2
    private lateinit var mAdapter: ProfilePagerAdapter

    override fun onBinding() {
        initViews()
        setUpViewPager()
    }

    private fun initViews(){
        mViewBinding.run {
            mTlProfile = tlProfile
            mVpProfile = vpProfile
            mAdapter = ProfilePagerAdapter(supportFragmentManager, lifecycle)
        }
    }

    private fun setUpViewPager(){
        mVpProfile.adapter = mAdapter
        TabLayoutMediator(mTlProfile, mVpProfile) { tab, position ->
            tab.text = tabLayoutArr[position]
        }.attach()
    }

    companion object {
        private val tabLayoutArr = arrayOf(
            "Uploads", "Exhibitions", "Revenue"
        )
    }
}