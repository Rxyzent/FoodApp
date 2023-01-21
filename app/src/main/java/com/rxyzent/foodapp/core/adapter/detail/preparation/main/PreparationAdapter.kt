package com.rxyzent.foodapp.core.adapter.detail.preparation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rxyzent.foodapp.core.model.instruction.InstructionItem
import com.rxyzent.foodapp.core.model.instruction.Step
import com.rxyzent.foodapp.databinding.PreparationListItemBinding

class PreparationAdapter : RecyclerView.Adapter<PreparationViewHolder>() {

    var onDetailListClick: OnDetailListClick? = null


    var data = ArrayList<InstructionItem>()
        set(value) {
            field.addAll(value)
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreparationViewHolder {
        return PreparationViewHolder(PreparationListItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: PreparationViewHolder, position: Int) {
        holder.bindData(data[position], onDetailListClick)
    }

    override fun getItemCount(): Int = data.size

    interface OnDetailListClick {
        fun onDetailClick(subItem: Step)
    }

}