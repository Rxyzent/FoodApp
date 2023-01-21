package com.rxyzent.foodapp.core.adapter.home.sub

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.rxyzent.foodapp.core.model.search.Result
import com.rxyzent.foodapp.databinding.SubListItemBinding

class SubViewHolder(val binding: SubListItemBinding):RecyclerView.ViewHolder(binding.root) {
    fun bindData(data:Result) {
        binding.image.load(data.image)
        binding.name.text = data.title
    }
}