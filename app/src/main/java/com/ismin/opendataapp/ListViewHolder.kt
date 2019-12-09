package com.ismin.opendataapp

import android.view.View
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListViewHolder(rootView: View) : RecyclerView.ViewHolder(rootView) { //cache the view objects in order to save memory
    var itemID : TextView
    //var itemLocation : (2, 2)
    init {
        this.itemID = rootView.findViewById(R.id.textfemme) //need to change
    }
}