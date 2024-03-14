package com.sugam.myapplication11.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sugam.myapplication11.Adapter.User
import com.sugam.myapplication11.R
import com.sugam.myapplication11.databinding.FragmentCartBinding
import org.json.JSONArray
import java.io.InputStream


class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding
    private lateinit var array: ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCartBinding.inflate(inflater, container, false)

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
            array= arrayListOf()
            val inputStream:InputStream = requireContext().assets.open("data.json")
            val jsontext = inputStream.bufferedReader().use { it.readText() }
            val jsonArray = JSONArray(jsontext)
            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)
                val name = jsonObject.getString("name")
                val address = jsonObject.getString("address")
                array.add(User(R.drawable.a1, name, address))
            }

            binding.txtnew.text = jsontext


        } catch (e: Exception) {

        }
        return binding.root
    }
}