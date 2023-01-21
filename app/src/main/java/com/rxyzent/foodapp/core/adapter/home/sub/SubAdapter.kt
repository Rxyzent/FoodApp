package com.rxyzent.foodapp.core.adapter.home.sub

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rxyzent.foodapp.core.model.instruction.Step
import com.rxyzent.foodapp.databinding.SubListItemBinding
import com.rxyzent.foodapp.core.model.search.Result

class SubAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var onSubItemClick : OnSubListClick?=null

    var data = ArrayList<Result>()
    set(value) {
        field.addAll(value)
        notifyItemRangeInserted(data.size - value.size,value.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       return SubViewHolder(SubListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as SubViewHolder).bindData(data[position])
    }

    override fun getItemCount(): Int= data.size


    interface OnSubListClick{
        fun onSubClick(subData:Step)
    }
}