package com.jathiswar.edvora_task


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.isVisible


class MainActivity : AppCompatActivity() {
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

        }

        arrow.setOnClickListener{

        }

        rectangle.setOnClickListener{

        }

        circle.setOnClickListener {

        }

        palette.setOnClickListener {
            drawpalette.isVisible = drawpalette.isVisible != true
        }










    }
















}