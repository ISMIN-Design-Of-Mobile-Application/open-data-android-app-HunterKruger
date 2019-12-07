package com.ismin.opendataapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(){

    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list   = findViewById<Button>(R.id.list)
        val map    = findViewById<Button>(R.id.map)
        val prefer = findViewById<Button>(R.id.preference)
        val info   = findViewById<Button>(R.id.information)

        list.setOnClickListener(){
            ShowFragmentOne()
        }
        map.setOnClickListener(){
            ShowFragmentTwo()
        }
        prefer.setOnClickListener(){
            ShowFragmentThree()
        }
        info.setOnClickListener(){
            ShowFragmentFour()
        }
    }

    fun ShowFragmentOne(){
        val transaction = manager.beginTransaction()
        val frag = FragmentOne()
        transaction.replace(R.id.a_main, frag) //replace the using one when you want to use another
        transaction.addToBackStack(null)
        transaction.commit()
    }
    fun ShowFragmentTwo(){
        val transaction = manager.beginTransaction()
        val frag = FragmentTwo()
        transaction.replace(R.id.a_main, frag) //replace the using one when you want to use another
        transaction.addToBackStack(null)
        transaction.commit()
    }
    fun ShowFragmentThree(){
        val transaction = manager.beginTransaction()
        val frag = FragmentThree()
        transaction.replace(R.id.a_main, frag) //replace the using one when you want to use another
        transaction.addToBackStack(null)
        transaction.commit()
    }
    fun ShowFragmentFour(){
        val transaction = manager.beginTransaction()
        val frag = FragmentFour()
        transaction.replace(R.id.a_main, frag) //replace the using one when you want to use another
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
