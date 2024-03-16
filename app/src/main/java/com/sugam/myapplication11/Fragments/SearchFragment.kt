package com.sugam.myapplication11.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sugam.myapplication11.Adapter.ListAdapter2
import com.sugam.myapplication11.Adapter.User
import com.sugam.myapplication11.R
import com.sugam.myapplication11.databinding.FragmentSearchBinding
import org.json.JSONArray
import java.util.Locale

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var array: ArrayList<User>
    private lateinit var tempArray: ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(layoutInflater, container, false)
        array = arrayListOf()
        tempArray = arrayListOf()
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
        tempArray.addAll(array)

        val adapter = ListAdapter2(requireContext(), tempArray)
        binding.RecyclerView1.adapter = adapter
        binding.RecyclerView1.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {

                tempArray.clear()
                val searchText = p0?.toLowerCase(Locale.getDefault())

                if (searchText.isNullOrEmpty()) {

                    array.forEach {
                        if (it.name.toLowerCase(Locale.getDefault()).contains(searchText)) {
                            tempArray.addAll(it)
                        }

                    }

                } else {
                    tempArray.clear()
                    tempArray.addAll(array)
                    adapter.notifyDataSetChanged()

                }

                return false
            }

        })

        return binding.root
    }


}