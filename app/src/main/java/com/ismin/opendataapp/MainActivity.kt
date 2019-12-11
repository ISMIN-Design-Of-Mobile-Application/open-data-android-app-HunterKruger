package com.ismin.opendataapp
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import co.metalab.asyncawait.async
import  com.ismin.opendataapp.webservice.RetrofitService
import  com.ismin.opendataapp.webservice.WomanWebService



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            // Coroutine body

            val debugV = WomanWebService()
            debugV.main2()

    }




}