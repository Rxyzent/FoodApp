package com.rxyzent.foodapp.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.rxyzent.foodapp.core.adapter.favorite.FavoriteAdapter
import com.rxyzent.foodapp.core.dataProvider.db.MyDataBase
import com.rxyzent.foodapp.databinding.FavoriteFragmentBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class FavoriteFragment:DaggerFragment() {

    private val binding by lazy {
        FavoriteFragmentBinding.inflate(layoutInflater)
    }

    private val adapter = FavoriteAdapter()

    @Inject
    lateinit var favoriteDb :MyDataBase

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.favoriteList.adapter = adapter
        binding.favoriteList.layoutManager = GridLayoutManager(requireContext(),2)

        adapter.setData(favoriteDb.userDao().getAllData())

        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }


        ItemTouchHelper(itemTouchHelperCallBack).attachToRecyclerView(binding.favoriteList)


}
    val itemTouchHelperCallBack=object : ItemTouchHelper.SimpleCallback(
        0, ItemTouchHelper.START or ItemTouchHelper.END
    ){
        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
            return false
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {


            adapter.removeItem(viewHolder.adapterPosition)

            when (direction) {
                ItemTouchHelper.END->{
                    favoriteDb.userDao().deleteMeal(adapter.data[viewHolder.adapterPosition])
                }
                ItemTouchHelper.START->{
                    favoriteDb.userDao().deleteMeal(adapter.data[viewHolder.adapterPosition])
                }
            }

        }

    }
}