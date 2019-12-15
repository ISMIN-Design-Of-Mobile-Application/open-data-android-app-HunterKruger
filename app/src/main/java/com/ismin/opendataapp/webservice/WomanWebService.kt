package com.ismin.opendataapp.webservice
import android.util.Log
import androidx.lifecycle.LiveData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import androidx.lifecycle.MutableLiveData
import com.ismin.opendataapp.Women
import kotlinx.coroutines.launch
import kotlinx.coroutines.GlobalScope
import com.google.gson.GsonBuilder
import com.google.gson.Gson
import com.ismin.opendataapp.WomenStorage
import com.ismin.opendataapp.webservice.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


internal class WomanWebService {
    private val women = ArrayList<Women>()
    private lateinit var womenWebService: RetrofitService


    // private val liveData = MutableLiveData<ArrayList<Women>>()



    fun getBottles(): ArrayList<Women>{

        return women
    }

    fun gettingDatafromServer() {

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        womenWebService = retrofit.create(RetrofitService::class.java)

        serverCommunication()
    }

    private fun serverCommunication() {
        womenWebService.findWomen()
            .enqueue(object : Callback<List<Women>> {
                override fun onResponse(
                    call: Call<List<Women>>,
                    response: Response<List<Women>>
                ) {
                    val serverWomen = response.body()
                    println( serverWomen)
                    if (serverWomen != null) {
                        women.clear()
                        women.addAll(serverWomen)
                        Log.d("problem", "good")

                        println(women)
                    }
                }

                override fun onFailure(
                    call: Call<List<Women>>,
                    t: Throwable
                ) {
                    Log.d("problem", "Unable to load cellar")
                }
            })


    }


    companion object {
        private const val BASE_URL =
            "https://opendata.paris.fr/api/records/1.0/search/?dataset=femmes-illustres-a-paris-portraits&facet=name&facet=tab_name&facet=short_desc"
    }




}

