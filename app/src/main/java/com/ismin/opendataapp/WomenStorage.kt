package com.ismin.opendataapp


import androidx.lifecycle.LiveData

import com.ismin.opendataapp.Women


interface WomenStorage {

    fun getAllWomen():LiveData<ArrayList<Women>>

}