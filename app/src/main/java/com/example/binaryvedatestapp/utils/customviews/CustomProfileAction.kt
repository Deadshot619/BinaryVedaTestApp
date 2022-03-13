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

class CustomProfileAction  @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr)  {
    private val view: View = LayoutInflater.from(context).inflate(R.layout.item_profile_action, this, true)

    private lateinit var mIcon: AppCompatImageView
    private lateinit var mTitle: TextView

    private var imageSrc: Int = -1
    private var title: String = ""

    init {
        initViews(attrs)
        initData()
    }

    private fun initViews(attrs: AttributeSet?){
        val tempAttrs = context.obtainStyledAttributes(attrs, R.styleable.CustomProfileAction)

        mIcon = view.findViewById(R.id.iv_icon)
        mTitle = view.findViewById(R.id.tv_title)

        imageSrc = tempAttrs.getResourceId(R.styleable.CustomProfileAction_cpa_srcIcon, -1)
        title = tempAttrs.getString(R.styleable.CustomProfileAction_cpa_title) ?: ""

        tempAttrs.recycle()
    }

    private fun initData(){
        mIcon.setImageDrawable(ContextCompat.getDrawable(context, imageSrc))
        mTitle.text = title
    }
}