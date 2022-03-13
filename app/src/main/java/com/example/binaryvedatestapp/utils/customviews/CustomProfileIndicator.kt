package com.example.binaryvedatestapp.utils.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.binaryvedatestapp.R

class CustomProfileIndicator  @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr)  {
    private val view: View = LayoutInflater.from(context).inflate(R.layout.item_profile_indicator, this, true)

    private lateinit var mIcon: AppCompatImageView
    private lateinit var mValue: TextView

    private var imageSrc: Int = -1
    private var value: String = ""

    init {
        initViews(attrs)
        initData()
    }

    private fun initViews(attrs: AttributeSet?){
        val tempAttrs = context.obtainStyledAttributes(attrs, R.styleable.CustomProfileIndicator)

        mIcon = view.findViewById(R.id.iv_icon)
        mValue = view.findViewById(R.id.tv_value)

        imageSrc = tempAttrs.getResourceId(R.styleable.CustomProfileIndicator_cpi_srcIcon, -1)
        value = tempAttrs.getString(R.styleable.CustomProfileIndicator_cpi_value) ?: ""

        tempAttrs.recycle()
    }

    private fun initData(){
        mIcon.setImageDrawable(ContextCompat.getDrawable(context, imageSrc))
        mValue.text = value
    }
}