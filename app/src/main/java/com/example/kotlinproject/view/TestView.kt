package com.example.kotlinproject.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import com.example.kotlinproject.px

class TestView (context:Context,attrs: AttributeSet): View(context,attrs)  {
    private val path = Path()
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    val Radius = 100f.px


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        path.addCircle(width/2f, height/2f, Radius,Path.Direction.CCW)
        path.addRect(RectF(width/2-Radius,height/2f,width/2+Radius,height/2+Radius*2),Path.Direction.CCW)
        path.fillType = Path.FillType.EVEN_ODD

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawPath(path,paint)
    }

    
}