package com.rxyzent.foodapp.core.adapter.detail.preparation.main

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rxyzent.foodapp.core.adapter.detail.preparation.sub.InstructionAdapter
import com.rxyzent.foodapp.core.model.instruction.InstructionItem
import com.rxyzent.foodapp.core.model.instruction.Step
import com.rxyzent.foodapp.databinding.PreparationListItemBinding

class PreparationViewHolder(val binding: PreparationListItemBinding):RecyclerView.ViewHolder(binding.root) {

    private val adapter = InstructionAdapter()

    fun bindData(data: InstructionItem, onDetailListClick: PreparationAdapter.OnDetailListClick?){

        if(data.name != ""){
            binding.name.text = data.name
        }else{
            binding.name.text = "The main part of the meal"
        }


        binding.instruction.adapter = adapter
        binding.instruction.layoutManager = LinearLayoutManager(binding.root.context,LinearLayoutManager.VERTICAL,false)

        adapter.data = data.steps

        adapter.onInstructionItemClick = object : InstructionAdapter.OnInstructionListClick {
            override fun onInstructionClick(InsData: Step) {
                onDetailListClick?.onDetailClick(InsData)
            }

        }


    }
}
