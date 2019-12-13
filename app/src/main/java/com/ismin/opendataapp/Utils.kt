package com.ismin.opendataapp

import android.content.Context
import android.util.Log
import android.util.Property
import java.io.IOException
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


fun getAssetJsonData(context: Context): String? {
    val json: String
    try {
        val inputStream = context.getAssets().open("properties.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.use { it.read(buffer) }
        json = String(buffer)
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        return null
    }
    // print the data
    Log.i("data", json)
    return json
}
