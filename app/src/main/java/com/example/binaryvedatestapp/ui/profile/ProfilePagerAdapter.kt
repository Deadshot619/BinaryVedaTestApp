package com.example.binaryvedatestapp.ui.profile

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.binaryvedatestapp.ui.uploads.UploadsFragment

class ProfilePagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int  = NUM_TABS

    override fun createFragment(position: Int): Fragment {
        return UploadsFragment()
    }

    companion object{
        private const val NUM_TABS = 3
    }
}