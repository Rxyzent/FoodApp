package com.rxyzent.foodapp.core.adapter.search

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.rxyzent.foodapp.databinding.SearchItemBinding
import com.rxyzent.foodapp.core.model.search.Result

class SearchViewHolder(val binding: SearchItemBinding):RecyclerView.ViewHolder(binding.root) {
    fun bindData(data:Result){
        binding.image.load(data.image)
        binding.mealName.text = data.title
    }
}