package com.ismin.opendataapp

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.File
import android.content.res.AssetManager
import java.io.IOException
import java.io.InputStream


class FragmentOne : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var womenadapter: ListAdapter

    var womenList: MutableList<Man>  = mutableListOf()

    val TAG = "FragmentOne"
    override fun onAttach(context: Context) {
        Log.d(TAG, "onAttach") //for recording each change of fragment by showing the msg
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate")
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView")

        val rootfrag = inflater.inflate(R.layout.fragment_one, container,false) //inflate the layout
        recyclerView = rootfrag.findViewById(R.id.list_weman)

        // specify an adapter

        var man1:Man=Man("Omar",0.231f,0.323f,"Omar is a muslim")
        var man2:Man=Man("Yuan",0.211f,0.353f,"Yuan is a Han")

        womenList.add(man1)
        womenList.add(man2)


        womenadapter = ListAdapter(womenList, context)
        recyclerView.adapter = womenadapter


        // use a linear layout manager
        val layoutManager =LinearLayoutManager(activity)
        recyclerView.layoutManager = layoutManager

        return rootfrag

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d(TAG, "onActivityCreated")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d(TAG, "onStart")
        super.onStart()
        //jsonText.text="FUCK"
        //readJson()
    }

    override fun onResume() {
        Log.d(TAG, "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG, "onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d(TAG, "onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.d(TAG, "onDetach")
        super.onDetach()
    }
}