package com.ismin.opendataapp


import androidx.lifecycle.LiveData

import com.ismin.opendataapp.Femme


interface WomenStorage {

    fun getAllWomen():LiveData<ArrayList<Femme>>

}