package com.ismin.opendataapp

import java.io.Serializable

data class Femme (val recordid:Int, val latitude:Float,
                  val longitude:Float, val name:String,
                  val desc1:String, val desc2:String,
                  val desc3:String,val desc4:String,
                  val desc5:String, val thumb_url:String,
                  val lieu:String):Serializable

class AllFemmes {

    val femmeList: MutableList<Femme> = mutableListOf()

    fun addFemme(femme:Femme) :Unit{
        femmeList.add(femme)
    }

    fun getFemme(recordid:Int):Femme? {
        val storedFemme = femmeList.find { femme: Femme -> femme.recordid == recordid }
        return storedFemme
    }

    fun getNumberOfFemmes():Int{
        val numOfFemmes:Int=femmeList.count()
        return numOfFemmes
    }

}