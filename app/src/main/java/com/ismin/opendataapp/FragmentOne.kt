package com.ismin.opendataapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.Fragment

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.FieldPosition


class FragmentOne : Fragment(), OnWomanClickListener {

    lateinit var recyclerView: RecyclerView
    lateinit var womenadapter: ListAdapter
    lateinit var allWomen : MutableList<Women>

    lateinit var allWomenLoaderClass : AllWomenLoader

    val TAG = "FragmentOne"
    override fun onAttach(context: Context) {
        Log.d(TAG, "onAttach") //for recording each change of fragment by showing the msg
        super.onAttach(context)
        allWomenLoaderClass = AllWomenLoader(context)
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
        allWomenLoaderClass.loadList()
        allWomen = allWomenLoaderClass.getTheWholeWholeList()
        womenadapter = ListAdapter(allWomen, context, this)
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

    override fun onWomanClick(woman: Women, position: Int) {
        Toast.makeText(context, woman.fields.name, Toast.LENGTH_SHORT).show()

        val intent = Intent(context, WomanActivity::class.java)
        val str = "ID: " + woman.recordid + "\nCoordinate: (" + woman.fields.geo_point_2d[0] + ", " +
                woman.fields.geo_point_2d[1] + ") \nName: " + woman.fields.name + "\nInfo: " +
                woman.fields.desc1 + "\n" + woman.fields.desc2 + "\nThumb_url: " + woman.fields.thumb_url +
                "\nTab_name: " + woman.fields.tab_name
        intent.putExtra("signal", str)
        startActivity(intent)
    }
}