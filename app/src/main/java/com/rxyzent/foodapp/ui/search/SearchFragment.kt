package com.rxyzent.foodapp.ui.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.rxyzent.foodapp.core.adapter.search.SearchAdapter
import com.rxyzent.foodapp.core.dataProvider.db.MyDataBase
import com.rxyzent.foodapp.core.helper.ViewModelProviderFactory
import com.rxyzent.foodapp.core.model.db.Favorite
import com.rxyzent.foodapp.databinding.SearchFragmentBinding
import com.rxyzent.foodapp.ui.main.HomeFragmentDirections
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class SearchFragment: DaggerFragment() {

    private val binding by lazy {
        SearchFragmentBinding.inflate(layoutInflater)
    }

    private val adapter = SearchAdapter()


    @Inject
    lateinit var vmProviderFactory: ViewModelProviderFactory
    private val viewModel: SearchViewModel by viewModels { vmProviderFactory }

    @Inject
    lateinit var favoriteDb:MyDataBase

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchText.showKeyboard()

        binding.mealList.layoutManager = GridLayoutManager(requireContext(),2)
        binding.mealList.adapter = adapter


        binding.searchText.addTextChangedListener {
            it?.let {
                adapter.clearData()
                viewModel.searchMeal(it.toString())
            }
        }

        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }

        adapter.onListItemClick = {
            val action = SearchFragmentDirections.actionSearchFragmentToDetailFragment()
            action.arguments.putInt("meal_id",it.id)
            action.arguments.putString("meal_name",it.title)
            action.arguments.putString("meal_img",it.image)
            findNavController().navigate(action)
        }

        ItemTouchHelper(itemTouchHelperCallBack).attachToRecyclerView(binding.mealList)

        viewModel.searchLiveData.observe(viewLifecycleOwner){
            adapter.data = it
        }
        viewModel.errorLiveData.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), it?.message, Toast.LENGTH_SHORT).show()
        }
        viewModel.networkErrorLiveData.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), "networkErrorLiveData", Toast.LENGTH_SHORT).show()
        }

    }

    val itemTouchHelperCallBack=object : ItemTouchHelper.SimpleCallback(
        0, ItemTouchHelper.START
    ){
        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
            return false
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {


            adapter.removeItem(viewHolder.adapterPosition)

            val meal = adapter.data[viewHolder.adapterPosition]

            when (direction) {
                ItemTouchHelper.START->{
                    favoriteDb.userDao().addMeal(Favorite(meal.id,meal.title,meal.image))
                }
            }

        }

    }

    fun View.showKeyboard() {
        this.requestFocus()
        val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
    }


}

