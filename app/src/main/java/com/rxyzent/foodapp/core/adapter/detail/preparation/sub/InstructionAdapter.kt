package com.rxyzent.foodapp.core.adapter.detail.preparation.sub

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rxyzent.foodapp.core.model.instruction.Step
import com.rxyzent.foodapp.databinding.InstructionListItemBinding

class InstructionAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var onInstructionItemClick : OnInstructionListClick?=null

    var data = ArrayList<Step>()
    set(value) {
        field.addAll(value)
        notifyItemRangeInserted(data.size - value.size,value.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       return InstructionViewHolder(InstructionListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as InstructionViewHolder).bindData(data[position])
    }

    override fun getItemCount(): Int= data.size


    interface OnInstructionListClick{
        fun onInstructionClick(subData:Step)
    }
}