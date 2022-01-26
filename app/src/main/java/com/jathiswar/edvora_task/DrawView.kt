package com.jathiswar.edvora_task

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.jathiswar.edvora_task.MainActivity.Companion.option
import com.jathiswar.edvora_task.MainActivity.Companion.paintBrush
import com.jathiswar.edvora_task.MainActivity.Companion.path
import android.graphics.PointF





class DrawView : View {

    var parameters: ViewGroup.LayoutParams? = null

    companion object {
        var pathList = ArrayList<Path>()
        var colorList = ArrayList<Int>()
        var currentColor = Color.BLACK
        var currentStyle = Paint.Style.STROKE
        var drawRectangle = false
        var beginCoordinate: PointF? = null
        var endCoordinate: PointF? = null
        var mPaint: Paint? = null
        var mX = 0f
        var mY = 0f

    }


    constructor(context: Context) : this(context, null) {
        mPaint = Paint()
        mX = (-100.also { mY = it.toFloat() }).toFloat()
        brushconfig()
    }

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0) {
        brushconfig()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        brushconfig()
    }

    private fun brushconfig() {
        paintBrush.isAntiAlias = true
        paintBrush.color = currentColor
        paintBrush.style = currentStyle
        paintBrush.strokeJoin = Paint.Join.ROUND
        paintBrush.strokeWidth = 10f


        parameters = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        var x = event.x
        var y = event.y
    when(option) {
        0 -> {
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    path.moveTo(x, y)
                    return true
                }
                MotionEvent.ACTION_MOVE -> {
                    path.lineTo(x, y)
                    pathList.add(path)
                    colorList.add(currentColor)

                }

                else -> return false
            }

        }

        3->{
            when (event.action) {

                MotionEvent.ACTION_DOWN -> {
                    mX = event.x
                    mY = event.y
                   invalidate()
                }

            }

        }



}
        postInvalidate()
            return false

    }


    override fun onDraw(canvas: Canvas) {

        when(option){
            0->{
                for (i in pathList.indices) {
                    paintBrush.setColor(colorList[i])
                    canvas.drawPath(pathList[i], paintBrush)
                    invalidate()
                }
            }

            2->{
                if(drawRectangle)
                    canvas.drawRect(beginCoordinate!!.x, beginCoordinate!!.y, endCoordinate!!.x, endCoordinate!!.y, paintBrush);
                invalidate()
            }

            3->{

                    canvas.drawCircle(mX, mY, 200F, paintBrush)
                    invalidate()

            }
        }


        }


    }





