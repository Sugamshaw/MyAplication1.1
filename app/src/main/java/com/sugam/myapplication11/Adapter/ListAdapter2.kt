package com.sugam.myapplication11.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sugam.myapplication11.databinding.ListDataAdapterBinding

class ListAdapter2(var content:Context,var arrayList: ArrayList<User>):RecyclerView.Adapter<ListAdapter2.ViewHolder>() {

    inner class ViewHolder(var binding: ListDataAdapterBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding=ListDataAdapterBinding.inflate(LayoutInflater.from(content),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.imageView3.setImageResource(arrayList[position].imageId)
        holder.binding.textView9.setText(arrayList[position].name)
        holder.binding.textView10.setText(arrayList[position].details)
    }


}