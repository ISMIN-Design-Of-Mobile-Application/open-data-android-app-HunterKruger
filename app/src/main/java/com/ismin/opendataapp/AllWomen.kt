package com.ismin.opendataapp

import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.*
import android.util.Log


class AllWomen {

    fun readLocalJson(dir: String) {
        val gson = GsonBuilder().setPrettyPrinting().create()
        val jsonList: String = File(dir).readText(Charsets.UTF_8)
        womenList = gson.fromJson(jsonList, object : TypeToken<List<Women>>() {}.type)

        //womenList.forEach { println(it) }

    }

    var womenList: MutableList<Women> = mutableListOf()

//    a list storing all liked femmes
//    val likeFemmeList: MutableList<Femme> = mutableListOf()

    fun loadList() {
//         val path  = "C:\\workspaceXY\\open-data-android-app-HunterKruger\\app\\src\\main\\java\\Asset\\femmes-illustres-a-paris-portraits.json"
//         readLocalJson(path)
        readLocalJson("/Users/FY/Desktop/workspaceMac/open-data-android-app-HunterKruger/app/src/main/java/com/ismin/opendataapp/femmes-illustres-a-paris-portraits.json")
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

    fun printOneWoman(index: Int) {
        println(womenList[index].recordid)
        println(womenList[index].fields.geo_point_2d[0])
        println(womenList[index].fields.geo_point_2d[1])
        println(womenList[index].fields.name)
        println(womenList[index].fields.desc1)
        println(womenList[index].fields.desc2)
        println(womenList[index].fields.thumb_url)
        println(womenList[index].fields.tab_name)
    }


//    // add a Femme to the likeFemmeList
//    fun addLikeFemme(femme: Femme) {
//        likeFemmeList.add(femme)
//    }
//
//    //get a femme from femmeList by using recordid
//    fun getLikedFemme(recordid: Int): Femme? {
//        val storedFemme = likeFemmeList.find { femme: Femme -> femme.recordid.equals(recordid) }
//        return storedFemme
//    }
//
//    // delete a Femme from the likeFemmeList
//    fun deleteLikeFemme(femme: Femme) {
//        likeFemmeList.remove(femme)
//    }
//
//    //return the number of Femmes in the femmeList
//    fun getNumberOfLikeFemmes(): Int {
//        val numOfLikeFemmes: Int = likeFemmeList.count()
//        return numOfLikeFemmes
//    }
//
//    //delete all femmes in the likeFemmeList
//    fun deleteAllinLikeFemmeList() {
//        likeFemmeList.clear()
//    }
//
//    //get the list "likeFemmeList"
//    fun getTheWholeLikeFemmeList(): MutableList<Femme> {
//        return likeFemmeList
//    }


}


fun main(args: Array<String>) {

    var allWomen = AllWomen()
    allWomen.loadList()
    allWomen.printOneWoman(1)

}


