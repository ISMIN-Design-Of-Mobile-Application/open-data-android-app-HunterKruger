package com.ismin.opendataapp

import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.*

fun main() {

    var womenList: MutableList<Women> = mutableListOf()
    val dir: String = "/Users/FY/Desktop/workspaceMac/open-data-android-app-HunterKruger/app/src/main/java/com/ismin/opendataapp/femmes-illustres-a-paris-portraits.json"
    val gson = GsonBuilder().setPrettyPrinting().create()
    val jsonList: String = File(dir).readText(Charsets.UTF_8)
    womenList = gson.fromJson(jsonList, object : TypeToken<List<Women>>() {}.type)
    womenList.forEach { println(it) }

    println(womenList[0].recordid)
    println(womenList[0].fields.geo_point_2d[0])
    println(womenList[0].fields.geo_point_2d[1])
    println(womenList[0].fields.name)
    println(womenList[0].fields.desc1)
    println(womenList[0].fields.desc2)
    println(womenList[0].fields.thumb_url)
    println(womenList[0].fields.tab_name)

}


