package com.example.kotlinproject.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import com.example.kotlinproject.UtilsTwo
import com.example.kotlinproject.px
import java.lang.Math.cos
import java.lang.Math.sin
import android.R.attr.y
import android.R.attr.x


class PieView(var mcontext: Context, attrs: AttributeSet?) : View(mcontext, attrs) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        measuredHeight
        measuredWidth
      var  heightSize : Int =  resolveSize(measuredHeight,heightMeasureSpec)
       var widthSize =  resolveSize(measuredWidth,widthMeasureSpec)
        setMeasuredDimension(widthSize,heightSize)


    }

    private val RADIUS = 150f.px
    private val ANGLES = floatArrayOf(60f, 90f, 150f, 60f)
    private val COLORS = listOf(Color.parseColor("#C2185B"), Color.parseColor("#00ACC1"), Color.parseColor("#558B2F"), Color.parseColor("#5D4037"))
    private val OFFSET_LENGTH = 20f.px
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var clickIndex = -1


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
    }

    override fun onDraw(canvas: Canvas) {
        // 画弧
        var startAngle = 0f
        for ((index, angle) in ANGLES.withIndex()) {
            paint.color = COLORS[index]
            if (clickIndex>=0) {
                if (index == clickIndex) {
                    canvas.save()
                    canvas.translate(OFFSET_LENGTH * cos(Math.toRadians(startAngle + angle / 2f.toDouble())).toFloat(), OFFSET_LENGTH * sin(Math.toRadians(startAngle + angle / 2f.toDouble())).toFloat())
                }
            }
            canvas.drawArc(width / 2f - RADIUS, height / 2f - RADIUS, width / 2f + RADIUS, height / 2f + RADIUS, startAngle, angle, true, paint)
            startAngle += angle
            if (clickIndex>=0) {
                if (index == clickIndex) {
                    canvas.restore()
                }
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        when (event.action) {
            MotionEvent.ACTION_DOWN -> doOnSpecialTypeClick(event)
        }
        return super.onTouchEvent(event)
    }

    private fun doOnSpecialTypeClick(event: MotionEvent) {
        var eventX = event.x
        var eventY = event.y
        var clickAngle = 0
        // 第一象限    反正切可以根据斜率计算角度
        if (eventX >= width / 2 && eventY >= height / 2) {
            clickAngle = (Math.atan(((eventY - height / 2) * 1.0f / (eventX - width / 2)).toDouble()) * 180 / Math.PI).toInt()
            UtilsTwo.showToast(mcontext, "第一象限"+clickAngle)

        }else
        // 第二象限
        if (eventX <= width / 2 && eventY >= height / 2) {
            clickAngle = (Math.atan(((width / 2 - eventX) / (eventY - height / 2)).toDouble()) * 180 / Math.PI + 90).toInt()
            UtilsTwo.showToast(mcontext, "第二象限"+clickAngle)
        }else
        // 第三象限
        if (eventX <= width / 2 && eventY <= height / 2) {
            clickAngle = (Math.atan(((height / 2 - eventY) / (width / 2 - eventX)).toDouble()) * 180 / Math.PI + 180).toInt()
            UtilsTwo.showToast(mcontext, "第三象限"+clickAngle)
        }else
        // 第四象限
        if (eventX >= width / 2 && eventY <= height / 2) {

            clickAngle = (Math.atan(((eventX - width / 2) / (height / 2 - eventY)).toDouble()) * 180 / Math.PI + 270).toInt()

            UtilsTwo.showToast(mcontext, "第四象限"+clickAngle)
        }

            if (clickAngle>=0&&clickAngle<60){
                clickIndex =0
            }else if (clickAngle>=60&&clickAngle<150){

                clickIndex =1

            }else if(clickAngle>=150&&clickAngle<300){
                clickIndex =2

            }else{
                clickIndex =3

            }

        invalidate()
    }
}