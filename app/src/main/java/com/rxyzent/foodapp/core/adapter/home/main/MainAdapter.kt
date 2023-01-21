package com.rxyzent.foodapp.core.adapter.home.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rxyzent.foodapp.core.model.homeMainData.MainData
import com.rxyzent.foodapp.core.model.instruction.Step
import com.rxyzent.foodapp.databinding.MainListItemBinding

class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {

    var onDetailListClick: OnDetailListClick? = null


    var data = ArrayList<MainData>()
        set(value) {
            data.clear()
            field.addAll(value)
            notifyDataSetChanged()
        }
    fun addData(d:MainData){
        data.add(d)
        notifyItemInserted(data.size-1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(MainListItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bindData(data[position], onDetailListClick)
    }

    override fun getItemCount(): Int = data.size
    fun clearData() {
        data.clear()
    }

    interface OnDetailListClick {
        fun onDetailClick(subItem: Step)
    }

}