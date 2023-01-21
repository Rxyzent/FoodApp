package com.rxyzent.foodapp.core.adapter.detail.preparation.sub

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.rxyzent.foodapp.core.model.instruction.Step
import com.rxyzent.foodapp.databinding.InstructionListItemBinding

class InstructionViewHolder(val binding: InstructionListItemBinding):RecyclerView.ViewHolder(binding.root) {
    fun bindData(data:Step) {

        binding.num.text = data.number.toString()
        binding.text.text = data.step
    }
}