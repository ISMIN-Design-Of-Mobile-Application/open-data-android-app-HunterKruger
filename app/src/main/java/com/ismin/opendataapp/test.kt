package com.ismin.opendataapp
import java.io.File

fun main(args: Array<String>) {

    val jsonList: String = File("C:/workspaceXY/open-data-android-app-HunterKruger/app/src/main/assets/femmes-illustres-a-paris-portraits.json").readText(Charsets.UTF_8)
    print(jsonList)
    //var allWomen = AllWomenLoader(context)
    //allWomen.loadList()
    //allWomen.printOneWoman(5)

}