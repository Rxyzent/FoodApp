package com.rxyzent.foodapp.core.adapter.favorite

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.rxyzent.foodapp.core.model.db.Favorite
import com.rxyzent.foodapp.databinding.FavoriteListItemBinding
import com.rxyzent.foodapp.databinding.SubListItemBinding

class FavoriteViewHolder(val binding: FavoriteListItemBinding):RecyclerView.ViewHolder(binding.root) {
    fun bindData(data:Favorite){
        binding.name.text = data.title
        binding.image.load(data.image)
    }
}