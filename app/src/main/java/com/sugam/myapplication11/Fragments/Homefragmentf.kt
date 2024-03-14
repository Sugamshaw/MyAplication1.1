package com.sugam.myapplication11.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sugam.myapplication11.Adapter.User
import com.sugam.myapplication11.Adapter.ValuesAdapter
import com.sugam.myapplication11.R
import com.sugam.myapplication11.databinding.FragmentHomefragmentfBinding
import org.json.JSONArray


class Homefragmentf : Fragment() {
    private lateinit var array: ArrayList<User>
    private lateinit var binding: FragmentHomefragmentfBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomefragmentfBinding.inflate(inflater, container, false)
        array = arrayListOf()
        var arrayList = arrayListOf<Int>(
            R.drawable.a1,
            R.drawable.a2,
            R.drawable.a3,
            R.drawable.a4,
            R.drawable.a1,
            R.drawable.a2,
            R.drawable.a3,
            R.drawable.a4
        )
        var arrayList2 = arrayListOf<String>("A1", "A2", "A3", "A4", "A1", "A2", "A3", "A4")
        var arrayList3 = arrayListOf<String>("B1", "B2", "B3", "B4", "B1", "B2", "B3", "B4")
        //        for(i in 0 until 5){
//            array.add(User(arrayList[i],arrayList2[i],arrayList3[i]))
//        }
        try {
            val inputStream = requireContext().assets.open("data.json")
            val jsontext = inputStream.bufferedReader().use { it.readText() }
            val jsonArray = JSONArray(jsontext)

            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)
                val name = jsonObject.getString("name")
                val address = jsonObject.getString("address")
                array.add(User(arrayList[i], name, address))
            }


        } catch (e: Exception) {
            Log.i("4.40", "error ${e.message}")
        }


        val adapter = ValuesAdapter(requireContext(), array)

        binding.RecyclerView1.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
        binding.RecyclerView1.adapter = adapter

        binding.RecyclerView2.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
        binding.RecyclerView2.adapter = adapter

        return binding.root

    }

}