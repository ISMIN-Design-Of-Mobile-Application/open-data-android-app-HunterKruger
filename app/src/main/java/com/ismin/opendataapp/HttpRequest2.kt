package com.ismin.opendataapp
import com.ismin.opendataapp.Women
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.BasicNetwork
import com.android.volley.toolbox.DiskBasedCache
import com.android.volley.toolbox.HurlStack
import com.android.volley.toolbox.StringRequest
import org.json.JSONArray
import org.json.JSONObject


val urlApi="https://www.data.gouv.fr/fr/datasets/r/07a4a948-a51a-4aa4-ad20-ed4e1c83a832"
class HttpRequest2(context: Context) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    val cache = DiskBasedCache(cacheDir, 1024 * 1024) // 1MB cap
    // Set up the network to use HttpURLConnection as the HTTP client.
    val network = BasicNetwork(HurlStack())

    // Instantiate the RequestQueue with the cache and network. Start the queue.
    val requestQueue = RequestQueue(cache, network).apply {
        start()
    }



    fun sendRequest(url:String):Unit{
        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            Response.Listener<String> {
                Toast.makeText(this, "It works, values: $it", Toast.LENGTH_SHORT).show()
            },
            Response.ErrorListener {
                Toast.makeText(this, "It fails with error: $it", Toast.LENGTH_SHORT).show()
            }
        )
        requestQueue.add(stringRequest)

    }

    fun getJsonData():Unit{

        Response.Listener<JSONArray>{
            //Treat data here
            //val Woman:JSONObject=it.getJSONObject()
            Toast.makeText(this,"Getting and proceocessing data from server...",Toast.LENGTH_LONG).show()
        }
    }

}