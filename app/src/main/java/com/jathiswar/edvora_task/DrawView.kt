package com.jathiswar.edvora_task

import android.R.attr
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.jathiswar.edvora_task.MainActivity.Companion.option
import com.jathiswar.edvora_task.MainActivity.Companion.paintBrush
import com.jathiswar.edvora_task.MainActivity.Companion.path
import android.graphics.Paint

import android.R.attr.bottom

import android.R.attr.right

import android.R.attr.top

import android.R.attr.left

import android.graphics.RectF





class DrawView : View {

    var parameters: ViewGroup.LayoutParams? = null

    companion object {
        var pathList = ArrayList<Path>()
        var isDrawing = false
        var colorList = ArrayList<Int>()
        var currentColor = Color.BLACK
        var currentStyle = Paint.Style.STROKE
        var drawRectangle = false
        var startPoint:PointF? = null
        var endPoint:PointF? = null
        var beginCoordinate: PointF? = null
        var endCoordinate: PointF? = null
        var mPaint: Paint? = null
        var mX = 0f
        var mY = 0f
        var aX = 0f
        var aY = 0f
        var bX = 0f
        var bY = 0f


    }


    constructor(context: Context) : this(context, null) {
        mPaint = Paint()
        mX = (-100.also { mY = it.toFloat() }).toFloat()
        aX = (-100.also { aY = it.toFloat() }).toFloat()
        bX = (-100.also { bY = it.toFloat() }).toFloat()


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


        1-> {
            when (event.action) {

                MotionEvent.ACTION_DOWN -> {
                    aX = event.x
                    aY = event.y
                    invalidate()
                }

            }

        }

        2-> {
            when (event.action) {

                MotionEvent.ACTION_DOWN -> {
                    bX = event.x
                    bY = event.y
                    invalidate()
                }

            }

        }


        3-> {
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


            1->{

                canvas.drawLine(aX,aY,aX-400,aY, paintBrush)
                canvas.drawLine(aX,aY,aX-100,aY-40, paintBrush)
                canvas.drawLine(aX,aY,aX-100,aY+40, paintBrush)

                invalidate()
            }



            2->{

                canvas.drawLine(bX,bY,bX-300,bY, paintBrush)
                canvas.drawLine(bX,bY+400,bX-300,bY+400, paintBrush)
                canvas.drawLine(bX,bY+400,bX-300,bY, paintBrush)
                canvas.drawLine(bX,bY+400,bX,bY, paintBrush)




                /*
                canvas.drawLine(bX,500F,width-300F,500F, paintBrush)
                canvas.drawLine(300F,900F,width-300F,900F, paintBrush)
                canvas.drawLine(width-300F,900F,width-300F,500F, paintBrush)
                canvas.drawLine(300F,900F,300F,500F, paintBrush)
*/
                invalidate()
            }


            3->{

                    canvas.drawCircle(mX, mY, 200F, paintBrush)
                    invalidate()

            }
        }


        }


    }





