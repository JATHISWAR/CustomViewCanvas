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
        }

        arrow.setOnClickListener{
            path.reset()
        }

        rectangle.setOnClickListener{
            path.reset()
        }

        circle.setOnClickListener {
            path.reset()
        }

        palette.setOnClickListener {
            drawpalette.isVisible = drawpalette.isVisible != true
        }

        redButton.setOnClickListener {
            paintBrush.color = Color.RED
        }

        blueButton.setOnClickListener {
            paintBrush.color = Color.BLUE
        }

        greenButton.setOnClickListener {
            paintBrush.color = Color.GREEN
        }
        blackButton.setOnClickListener {
            paintBrush.color = Color.BLACK
        }


    }

    private fun currentcolor(color:Int){
        currentColor = color
        path = Path()


    }


}