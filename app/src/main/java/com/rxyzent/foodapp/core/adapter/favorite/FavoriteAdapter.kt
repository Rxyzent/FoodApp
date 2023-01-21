package com.rxyzent.foodapp.core.adapter.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rxyzent.foodapp.core.model.db.Favorite
import com.rxyzent.foodapp.databinding.FavoriteListItemBinding

class FavoriteAdapter:RecyclerView.Adapter<FavoriteViewHolder>() {

    var data = ArrayList<Favorite>()

    fun setData(data:List<Favorite>){
        this.data.addAll(data)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        return FavoriteViewHolder(FavoriteListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bindData(data[position])
    }

    override fun getItemCount(): Int = data.size
    fun removeItem(position: Int) {
        data.removeAt(position)
        notifyItemRemoved(position)
    }
}