package com.rxyzent.foodapp.core.adapter.home.main

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rxyzent.foodapp.core.model.instruction.Step
import com.rxyzent.foodapp.core.adapter.home.sub.SubAdapter
import com.rxyzent.foodapp.core.model.homeMainData.MainData
import com.rxyzent.foodapp.databinding.MainListItemBinding

class MainViewHolder(val binding: MainListItemBinding):RecyclerView.ViewHolder(binding.root) {

    private val adapter = SubAdapter()

    fun bindData(data: MainData, onDetailListClick: MainAdapter.OnDetailListClick?){

        binding.subList.adapter = adapter
        binding.subList.layoutManager = LinearLayoutManager(binding.root.context,LinearLayoutManager.HORIZONTAL,false)

        adapter.data = data.subData

        binding.category.text = data.title

        adapter.onSubItemClick = object : SubAdapter.OnSubListClick{
            override fun onSubClick(subData: Step) {
                onDetailListClick?.onDetailClick(subData)
            }

        }


    }
}
