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

class CustomProfileData  @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr)  {
    private val view: View = LayoutInflater.from(context).inflate(R.layout.item_profile_data, this, true)

    private lateinit var mNumber: TextView
    private lateinit var mTitle: TextView

    private var number: String = ""
    private var title: String = ""

    init {
        initViews(attrs)
        initData()
    }

    private fun initViews(attrs: AttributeSet?){
        val tempAttrs = context.obtainStyledAttributes(attrs, R.styleable.CustomProfileData)

        mNumber = view.findViewById(R.id.tv_number)
        mTitle = view.findViewById(R.id.tv_title)

        number = tempAttrs.getString(R.styleable.CustomProfileData_cpd_number) ?: ""
        title = tempAttrs.getString(R.styleable.CustomProfileData_cpd_title) ?: ""

        tempAttrs.recycle()
    }

    private fun initData(){
        mNumber.text = number
        mTitle.text = title
    }
}