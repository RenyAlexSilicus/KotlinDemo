package com.silicus.kotlindemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    //private var txtHelloWorld: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("Hello World")

        val txtHelloWorld: TextView = findViewById(R.id.txtHelloWorld) as TextView
        txtHelloWorld.setText("Hello World, This build is from VSAC ")

        /*txtHelloWorld.setOnClickListener {
            txtHelloWorld.text = "Hello World, This build is from VSAC "
        }*/

    }
}
