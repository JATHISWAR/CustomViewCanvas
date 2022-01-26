package com.jathiswar.edvora_task


import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.isVisible
import android.graphics.Path
import com.jathiswar.edvora_task.DrawView.Companion.currentColor


class MainActivity : AppCompatActivity() {

    companion object{
        var path = Path()
        var paintBrush = Paint()
        var option = 0
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pencil = findViewById<ImageButton>(R.id.pencil)
        val arrow = findViewById<ImageButton>(R.id.arrow)
        val rectangle = findViewById<ImageButton>(R.id.rectangle)
        val circle = findViewById<ImageButton>(R.id.circle)
        val palette = findViewById<ImageButton>(R.id.palette)
        val drawpalette = findViewById<LinearLayout>(R.id.draw_palette)

        val redButton = findViewById<ImageButton>(R.id.red)
        val greenButton = findViewById<ImageButton>(R.id.green)
        val blueButton = findViewById<ImageButton>(R.id.blue)
        val blackButton = findViewById<ImageButton>(R.id.black)


        pencil.setOnClickListener {
            path.reset()
            option = 0
        }

        arrow.setOnClickListener{
            path.reset()
            option = 1
        }

        rectangle.setOnClickListener{
            path.reset()
            option = 2
        }

        circle.setOnClickListener {
            path.reset()
            option = 3
        }

        palette.setOnClickListener {
            drawpalette.isVisible = drawpalette.isVisible != true
        }

        redButton.setOnClickListener {
            path.reset()
            paintBrush.color = Color.parseColor("#dc2f23")
            currentcolor(paintBrush.color)
        }

        blueButton.setOnClickListener {
            path.reset()
            paintBrush.color = Color.parseColor("#3376d7")
            currentcolor(paintBrush.color)
        }

        greenButton.setOnClickListener {
            path.reset()
            paintBrush.color = Color.parseColor("#41872e")
            currentcolor(paintBrush.color)
        }
        blackButton.setOnClickListener {
            path.reset()
            paintBrush.color = Color.parseColor("#131313")
            currentcolor(paintBrush.color)
        }


    }

    private fun currentcolor(color:Int){
        currentColor = color
        path = Path()

    }


}