package com.example.kotlinproject

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue
import android.widget.Toast

fun showToast(context:Context,message:String){
    Toast.makeText(context,message,Toast.LENGTH_LONG).show()
}

val Float.px get() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, Resources.getSystem().displayMetrics)