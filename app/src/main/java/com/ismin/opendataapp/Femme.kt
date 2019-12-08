package com.ismin.opendataapp

import java.io.Serializable

data class Femme(
    val recordid: Int,
    val latitude: Float,
    val longitude: Float,
    val name: String,
    val desc1: String,
    val desc2: String,
    val desc3: String,
    val desc4: String,
    val desc5: String,
    val thumb_url: String,
    val lieu: String,
    var like: Boolean = false       // "like" is a "var", it is not from json
                                    //  the default value of "like" is "false"
) : Serializable

class AllFemmes {

    //a list storing all femmes
    val femmeList: MutableList<Femme> = mutableListOf()

    //a list storing all liked femmes
    val likeFemmeList: MutableList<Femme> = mutableListOf()



    //add a femme to the femmeList
    fun addFemme(femme: Femme): Unit {
        femmeList.add(femme)
    }

    //get a femme from femmeList by using recordid
    fun getFemme(recordid: Int): Femme? {
        val storedFemme = femmeList.find { femme: Femme -> femme.recordid == recordid }
        return storedFemme
    }

    //return the number of Femmes in the femmeList
    fun getNumberOfFemmes(): Int {
        val numOfFemmes: Int = femmeList.count()
        return numOfFemmes
    }

    //delete all femmes in the femmeList
    fun deleteAllinFemmeList() {
        femmeList.clear()
    }

    //get the list "femmeList"
    fun getTheWholeFemmeList():MutableList<Femme>{
        return femmeList
    }



    // add a Femme to the likeFemmeList
    fun addLikeFemme(femme: Femme) {
        likeFemmeList.add(femme)
    }

    //get a femme from femmeList by using recordid
    fun getLikedFemme(recordid: Int): Femme? {
        val storedFemme = likeFemmeList.find { femme: Femme -> femme.recordid == recordid }
        return storedFemme
    }

    // delete a Femme from the likeFemmeList
    fun deleteLikeFemme(femme: Femme) {
        likeFemmeList.remove(femme)
    }

    //return the number of Femmes in the femmeList
    fun getNumberOfLikeFemmes(): Int {
        val numOfLikeFemmes: Int = likeFemmeList.count()
        return numOfLikeFemmes
    }

    //delete all femmes in the likeFemmeList
    fun deleteAllinLikeFemmeList() {
        likeFemmeList.clear()
    }

    //get the list "likeFemmeList"
    fun getTheWholeLikeFemmeList():MutableList<Femme>{
        return likeFemmeList
    }

}



