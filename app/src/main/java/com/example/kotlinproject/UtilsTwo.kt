package com.example.kotlinproject

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue
import android.widget.Toast

object UtilsTwo {
    fun showToast(context : Context,message : String){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show()
    }

private val displayMetrics = Resources.getSystem().displayMetrics
    fun dp2px(dp : Float) : Float{
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp, displayMetrics)
    }


}