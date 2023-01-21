package com.rxyzent.foodapp.core.adapter.detail.ingredients

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rxyzent.foodapp.core.model.information.ExtendedIngredient
import com.rxyzent.foodapp.databinding.IngredientsListItemBinding

class IngredientAdapter:RecyclerView.Adapter<IngredientViewHolder>() {

    var data = ArrayList<ExtendedIngredient>()
    set(value) {
        field.addAll(value)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder {
        return IngredientViewHolder(IngredientsListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {
        holder.bindData(data[position])
    }

    override fun getItemCount(): Int = data.size
}