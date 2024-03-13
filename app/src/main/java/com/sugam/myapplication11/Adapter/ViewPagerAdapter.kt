package com.sugam.myapplication11.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sugam.myapplication11.databinding.DesignImageViewpagerBinding


class ViewPagerAdapter(var context: Context,var imageArr:ArrayList<Int>):RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {

    inner class ViewHolder(var binding:DesignImageViewpagerBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding=DesignImageViewpagerBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return imageArr.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.postImage.setImageResource(imageArr[position])
    }
}