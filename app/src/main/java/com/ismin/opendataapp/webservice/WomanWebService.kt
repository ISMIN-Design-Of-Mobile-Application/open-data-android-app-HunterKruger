package com.ismin.opendataapp.webservice
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import androidx.lifecycle.MutableLiveData
import com.ismin.opendataapp.Femme
import kotlinx.coroutines.launch
import kotlinx.coroutines.GlobalScope
import com.google.gson.GsonBuilder
import com.google.gson.Gson





internal class WomanWebService {

    private val liveData = MutableLiveData<ArrayList<Femme>>()

    var gson = GsonBuilder()
        .setLenient()
        .create()

     var womenWebService = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl(BASE_URL)
        .build()

    init {

        liveData.value = arrayListOf()
    }



    companion object {
        private const val BASE_URL = " https://opendata.paris.fr/explore/dataset/femmes-illustres-a-paris-portraits/download/?format=json&timezone=Europe/Berlin"
    }

    val repository= womenWebService.create(RetrofitService::class.java)



    fun  main2() {
        GlobalScope.launch {
        val women = repository.findWomen()
        println("after findwomen")

        val variables = women.execute().body()
        println("after execute body")

        variables?.forEach {
            println(it)
        }
            println(variables)

            println("after printing")


        }}

}

