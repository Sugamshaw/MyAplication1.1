package com.sugam.myapplication11.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sugam.myapplication11.databinding.ListDataAdapterBinding

class ValuesAdapter(var context: Context,var arrayList: ArrayList<User>):RecyclerView.Adapter<ValuesAdapter.ViewHolder3>() {

    inner class ViewHolder3(var binding: ListDataAdapterBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder3 {
        val binding=ListDataAdapterBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder3(binding)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder3, position: Int) {
        holder.binding.imageView3.setImageResource(arrayList[position].imageId)
        holder.binding.textView9.setText(arrayList[position].name)
        holder.binding.textView10.setText(arrayList[position].details)
    }

}