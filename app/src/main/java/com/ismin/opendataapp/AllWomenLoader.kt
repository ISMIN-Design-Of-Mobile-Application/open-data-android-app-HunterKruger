package com.ismin.opendataapp

import android.content.Context
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.*
import android.util.Log
import com.google.gson.JsonDeserializationContext
import java.nio.charset.Charset

class AllWomenLoader(private val context: Context) {

    var womenList: MutableList<Women> = mutableListOf()

//    a list storing all liked femmes
//    val likeFemmeList: MutableList<Femme> = mutableListOf()

    fun loadList() {
        val inputStream = context.assets.open("femmes-illustres-a-paris-portraits.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.use { it.read(buffer) }
        val json = String(buffer)
        val gson = GsonBuilder().setPrettyPrinting().create()
        womenList = gson.fromJson(json, object : TypeToken<List<Women>>() {}.type)
    }

    //add a femme to the femmeList by Femme object
    fun addWomen(women: Women) {
        womenList.add(women)
    }


    //get a femme from femmeList by using recordid
    fun getWomen(recordid: Int): Women? {
        val storedWomen = womenList.find { women: Women -> women.recordid.equals(recordid) }
        return storedWomen
    }

    //return the number of women in the womenList
    fun getNumberOfFemmes(): Int {
        val numOfFemmes: Int = womenList.count()
        return numOfFemmes
    }

    //delete all women in the womenList
    fun deleteAllinWomenList() {
        womenList.clear()
    }

    //get the list "womenList"
    fun getTheWholeWholeList(): MutableList<Women> {
        return womenList
    }

    fun retureOneWoman(index: Int): String {
        val str =
            "ID: " + womenList[index].recordid + "\nCoordinate: (" + womenList[index].fields.geo_point_2d[0] + ", " +
                    womenList[index].fields.geo_point_2d[1] + ") \nName: " + womenList[index].fields.name + "\nInfo: " +
                    womenList[index].fields.desc1 + "\n" + womenList[index].fields.desc2 + "\nThumb_url: " + womenList[index].fields.thumb_url +
                    "\nTab_name: " + womenList[index].fields.tab_name

        return str
    }

}

