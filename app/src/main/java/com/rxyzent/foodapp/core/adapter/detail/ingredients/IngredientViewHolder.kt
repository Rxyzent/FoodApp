package com.rxyzent.foodapp.core.adapter.detail.ingredients

import androidx.recyclerview.widget.RecyclerView
import com.rxyzent.foodapp.core.model.information.ExtendedIngredient
import com.rxyzent.foodapp.databinding.IngredientsListItemBinding

class IngredientViewHolder(val binding: IngredientsListItemBinding):RecyclerView.ViewHolder(binding.root) {
    fun bindData(data:ExtendedIngredient){

        binding.name.text = data.originalName
        binding.unit.text = data.amount.toString().plus(" ").plus(data.unit)
    }
}