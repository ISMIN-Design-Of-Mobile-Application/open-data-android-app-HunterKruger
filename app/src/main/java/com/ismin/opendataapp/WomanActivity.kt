package com.ismin.opendataapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class WomanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_woman)

        // Receive the info that comes from the FragmentMapTwo


        var sig = intent.getStringExtra("signal")
        val textID = findViewById<TextView>(R.id.textEachWoman)
        textID.text = sig
    }
}
