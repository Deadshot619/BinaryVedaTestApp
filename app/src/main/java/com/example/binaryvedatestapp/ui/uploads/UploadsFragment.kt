package com.example.binaryvedatestapp.ui.uploads

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.binaryvedatestapp.R
import com.example.binaryvedatestapp.databinding.UploadsFragmentBinding
import com.example.binaryvedatestapp.ui.base.BaseFragment

class UploadsFragment : BaseFragment<UploadsViewModel, UploadsFragmentBinding>() {
    override val mViewModel: UploadsViewModel by viewModels()
    override fun getViewBinding() = UploadsFragmentBinding.inflate(layoutInflater)

    private lateinit var mRvMain : RecyclerView
    private lateinit var mAdapter: UploadsAdapter

    override fun onBinding() {
        initView()
        setUpRecyclerView()
    }

    private fun initView(){
        mViewBinding.run {
            mRvMain = rvUploads
        }
    }

    private fun setUpRecyclerView(){
        mAdapter = UploadsAdapter()
        val linearLayoutManager = GridLayoutManager(requireContext(), 2)
        mRvMain.apply {
            layoutManager = linearLayoutManager
            adapter = mAdapter
        }
        mAdapter.submitList(imagesList)
    }


    companion object {
        private val imagesList = listOf(R.drawable.image_1, R.drawable.image_2, R.drawable.image_3, R.drawable.image_4,
            R.drawable.image_5, R.drawable.image_6)
    }
}