package com.sugam.myapplication11.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sugam.myapplication11.Adapter.User
import com.sugam.myapplication11.Adapter.ValuesAdapter
import com.sugam.myapplication11.R
import com.sugam.myapplication11.databinding.FragmentHome2Binding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHome2Binding
    private lateinit var array: ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentHome2Binding.inflate(inflater, container, false)
        array= ArrayList()
        var arrayList= arrayListOf<Int>(R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4)
        var arrayList2= arrayListOf<String>("A1","A2","A3","A4","A1","A2","A3","A4")
        var arrayList3= arrayListOf<String>("B1","B2","B3","B4","B1","B2","B3","B4")
//        var arrayList3= arrayListOf<Int>(R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4)



        for(i in 0 until 5){
            array.add(User(arrayList[i],arrayList2[i],arrayList3[i]))
        }

        val adapter=ValuesAdapter(requireContext(),array)

        binding.RecyclerView1.layoutManager=StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL)
        binding.RecyclerView1.adapter=adapter

        binding.RecyclerView2.layoutManager=StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL)
        binding.RecyclerView2.adapter=adapter

        return binding.root

    }



}

//
//import android.content.Context
//import android.content.Intent
//import android.graphics.Color
//import android.os.Bundle
//import android.util.Log
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.StaggeredGridLayoutManager
//import com.sugam.trail12.Adapter.Adapter
//import com.sugam.trail12.Adapter.recylerAdapter
//import com.sugam.trail12.R
//import com.sugam.trail12.databinding.ActivityMainBinding
//import com.sugam.trail12.dataclass.User
//import org.json.JSONObject
//
//class MainActivity : AppCompatActivity() {
//    private lateinit var binding: ActivityMainBinding
//    private lateinit var arrayList: ArrayList<User>
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        window.statusBarColor=Color.TRANSPARENT
//        title="MAin"
//        val sharedPreferences=getSharedPreferences(getString(R.string.credentials), Context.MODE_PRIVATE)
//        getjsondata()
//
//        var adapter= recylerAdapter(this,arrayList)
//        binding.rv.layoutManager= StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
//        binding.rv.adapter=adapter
//
//
//
//        binding.listView.isClickable = true
//        binding.listView.adapter = Adapter(this, arrayList)
//        binding.listView.setOnItemClickListener { adapterView, view, i, l ->
////            sharedPreferences.edit().clear().apply()
////            sharedPreferences.edit().putInt("image", arrayList[i].imageId).apply()
////            sharedPreferences.edit().putString("name", arrayList[i].name).apply()
////            sharedPreferences.edit().putString("description", arrayList[i].description).apply()
////            sharedPreferences.edit().putString("time", arrayList[i].time).apply()
//
//            val intent = Intent(this, Display::class.java)
//            intent.putExtra("image", arrayList[i].imageId)
//            intent.putExtra("name", arrayList[i].name)
//            intent.putExtra("description", arrayList[i].description)
//            intent.putExtra("time", arrayList[i].time)
//
//            startActivity(intent)
//        }
//
//
//    }
//
//    private fun getjsondata() {
//        arrayList = arrayListOf<User>()
//        try {
//            val inputStream = assets.open("data.json")
//            val jsontext = inputStream.bufferedReader().use { it.readText() }
//            val jsonObject = JSONObject(jsontext)
//            val jsonArray = jsonObject.getJSONArray("items")
//
//            for (i in 0 until jsonArray.length()) {
//                val obj = jsonArray.getJSONObject(i)
//                val image = getresouceid(obj.getString("imageId"))
//                val name = obj.getString("name")
//                val message = obj.getString("message")
//                val time = obj.getString("time")
//
//                arrayList.add(User(image, name, message, time))
//                arrayList.add(User(image, name, message, time))
//                arrayList.add(User(image, name, message, time))
//                arrayList.add(User(image, name, message, time))
//                arrayList.add(User(image, name, message, time))
//            }
//
//
//        } catch (e: Exception) {
//            Log.i("ex250","error occured ${e.message}")
//        }
//
//
//    }
//
//    private fun getresouceid(string: String): Int {
//        val source = string.substringAfterLast(".")
//        return resources.getIdentifier(source, "drawable", packageName)
//    }
//
//
//}
