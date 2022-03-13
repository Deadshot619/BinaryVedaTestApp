package com.example.binaryvedatestapp.utils.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.binaryvedatestapp.R

class CustomHomeView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private val view: View = LayoutInflater.from(context).inflate(R.layout.item_home, this, true)

    private lateinit var mIcon: AppCompatImageView

    private var imageSrc: Int = -1

    init {
        initViews(attrs)
        initData()
    }

    private fun initViews(attrs: AttributeSet?){
        val tempAttrs = context.obtainStyledAttributes(attrs, R.styleable.CustomHomeView)

        mIcon = view.findViewById(R.id.iv_icon)

        imageSrc = tempAttrs.getResourceId(R.styleable.CustomHomeView_srcIcon, -1)

        tempAttrs.recycle()
    }

    private fun initData(){
        mIcon.setImageDrawable(ContextCompat.getDrawable(context, imageSrc))
    }
}