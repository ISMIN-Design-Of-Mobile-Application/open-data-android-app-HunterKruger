package com.ismin.opendataapp.webservice



import android.database.Observable
import com.ismin.opendataapp.Women


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

 interface RetrofitService {

    @GET(".")
    fun findWomen():Call<List<Women>>
}


