package com.rxyzent.foodapp.core.adapter.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rxyzent.foodapp.core.model.search.Result
import com.rxyzent.foodapp.databinding.SearchItemBinding

class SearchAdapter : RecyclerView.Adapter<SearchViewHolder>() {

    var onListItemClick : ((result:Result)->Unit)? = null

    var data = ArrayList<Result>()
        set(value) {
            field.addAll(value)
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(SearchItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bindData(data[position])

        holder.binding.root.setOnClickListener {
            onListItemClick?.invoke(data[position])
        }
    }

    override fun getItemCount(): Int = data.size

    fun clearData(){
        data.clear()
    }

    fun removeItem(adapterPosition: Int) {
        data.removeAt(adapterPosition)
        notifyItemRemoved(adapterPosition)
    }
}