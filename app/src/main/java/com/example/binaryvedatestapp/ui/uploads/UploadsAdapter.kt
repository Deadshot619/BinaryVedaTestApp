package com.example.binaryvedatestapp.ui.uploads

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.binaryvedatestapp.databinding.ItemUploadBinding

class UploadsAdapter: ListAdapter<Int, UploadsAdapter.UploadsViewHolder>(DiffUtils){

    companion object DiffUtils : DiffUtil.ItemCallback<Int>() {
        override fun areItemsTheSame(
            oldItem: Int,
            newItem: Int
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: Int,
            newItem: Int
        ): Boolean {
            return oldItem == newItem
        }

    }

    inner class UploadsViewHolder(val binding: ItemUploadBinding): RecyclerView.ViewHolder(binding.root) {
        fun onBind(@DrawableRes value: Int){
            binding.ivMainImage.setImageResource(value)
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UploadsViewHolder {
        val view =ItemUploadBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UploadsViewHolder(view)
    }

    override fun onBindViewHolder(holder: UploadsViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}