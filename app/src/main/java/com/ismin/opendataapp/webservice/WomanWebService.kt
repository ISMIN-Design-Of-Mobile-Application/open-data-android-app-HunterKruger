package com.ismin.opendataapp.webservice
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


internal class WomanWebService:WomenStorage {

    private val liveData = MutableLiveData<ArrayList<Women>>()

    var gson = GsonBuilder()
        .setLenient()
        .create()

     private val womenWebService = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
         .create<RetrofitService>(RetrofitService::class.java)

    init {

        liveData.value = arrayListOf()
    }


    override fun getAllWomen(): LiveData<ArrayList<Women>> {

        womenWebService.findWomen()
            .enqueue(object: Callback<List<Women>>{
                override fun onResponse(call: Call<List<Women>>,
                                        response: Response<List<Women>>
                ) {
                    val serverWomen = response.body()
                    if (serverWomen != null) {
                        liveData.value = ArrayList(serverWomen)
                    }
                }

                override fun onFailure(call: Call<List<Women>>,
                                       t: Throwable) {
                    //Log.e(TAG, "Unable to load cellar")
                }
            })
        return liveData
            }


    companion object {
        private const val BASE_URL = "https://opendata.paris.fr/api/records/1.0/search/?dataset=femmes-illustres-a-paris-portraits"
    }

  //  val repository= womenWebService.create<RetrofitService>(RetrofitService::class.java)



    fun  main2() :LiveData<ArrayList<Women>>{
      //obalScope.launch {
            val requete=WomanWebService()
            val variables = requete.getAllWomen()
            return variables
      //  val women = repository.findWomen()
        //println(women)

        //val variables = women.execute().body()
       // println("after execute body")
         //   println(variables)

       // variables?.forEach {
           // println(it)

        //}



        }
}


