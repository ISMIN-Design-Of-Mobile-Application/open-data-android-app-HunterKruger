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


class FragmentOne : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var femmeadapter: ListAdapter
    val str : String = "sss"
    val femme1 : Femme = Femme(1,22.2f,13.0f, str,str,str,str,str,str,str,str)
    val femme2 : Femme = Femme(2,11.2f,13.0f, "ppp",str,str,str,str,str,str,str)
    var femmelist: MutableList<Femme> = MutableList<Femme>(1){femme1}

    val TAG = "FragmentOne"
    override fun onAttach(context: Context) {
        Log.d(TAG, "onAttach") //for recording each change of fragment by showing the msg
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate")
        super.onCreate(savedInstanceState)
    }


//    fun readJson() {
//        var json: String?=null
//        try {
//            val inputStream: InputStream = getResources().getAssets().open("a.json")
//            json = inputStream.bufferedReader().use { it.readText() }
//            jsonText.text = json
//        } catch (e: IOException) {
//
//        }
//
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView")

        val rootfrag = inflater.inflate(R.layout.fragment_one, container,false) //inflate the layout
        recyclerView = rootfrag.findViewById(R.id.list_weman)

        // specify an adapter
        femmelist.add(femme2)
        femmeadapter = ListAdapter(femmelist, context)
        recyclerView.adapter = femmeadapter


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