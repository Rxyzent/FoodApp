package com.rxyzent.foodapp.ui.detail

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.rxyzent.foodapp.R
import com.rxyzent.foodapp.core.adapter.detail.ingredients.IngredientAdapter
import com.rxyzent.foodapp.core.adapter.detail.preparation.main.PreparationAdapter
import com.rxyzent.foodapp.core.dataProvider.db.MyDataBase
import com.rxyzent.foodapp.core.helper.ViewModelProviderFactory
import com.rxyzent.foodapp.core.model.db.Favorite
import com.rxyzent.foodapp.databinding.DetailFragmentBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class DetailFragment:DaggerFragment() {
    private val binding by lazy {
        DetailFragmentBinding.inflate(layoutInflater)
    }

    @Inject
    lateinit var vmProviderFactory: ViewModelProviderFactory
    private val viewModel: DetailViewModel by viewModels { vmProviderFactory }

    private val ingredientAdapter = IngredientAdapter()
    private val preparationAdapter = PreparationAdapter()

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


        val mealId = arguments?.getInt("meal_id")
        val mealName = arguments?.getString("meal_name")
        val mealImg = arguments?.getString("meal_img")

        mealId?.let {
            viewModel.getMealRecipe(it)
            viewModel.getInstruction(it)
        }

        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }

        if(favoriteDb.userDao().searchMealById(mealId.toString()) == Favorite(mealId!!,mealName!!,mealImg!!)){
            favoriteDb.userDao().addMeal(Favorite(mealId!!,mealName!!,mealImg!!))
            binding.favorite.setBackgroundResource(R.drawable.ic_baseline_favorite)
        }

        binding.favorite.setOnClickListener {
            if(favoriteDb.userDao().searchMealById(mealId.toString()) != Favorite(mealId!!,mealName!!,mealImg!!)){
                favoriteDb.userDao().addMeal(Favorite(mealId!!,mealName!!,mealImg!!))
                it.setBackgroundResource(R.drawable.ic_baseline_favorite)
            }else{
                favoriteDb.userDao().deleteMeal(Favorite(mealId!!,mealName!!,mealImg!!))
                it.setBackgroundResource(R.drawable.ic_baseline_favorite_border)
            }

        }

        binding.ingredientList.adapter = ingredientAdapter
        binding.ingredientList.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)

        binding.preparationList.adapter = preparationAdapter
        binding.preparationList.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)

        viewModel.informationLiveData.observe(viewLifecycleOwner){
            if (it != null) {
                ingredientAdapter.data = it.extendedIngredients
                binding.mealName.text = it.title
                binding.timeStr.text = it.readyInMinutes.toString().plus(" minutes")
                binding.likeStr1.text = it.aggregateLikes.toString()
                binding.video.load(it.image)
                binding.numServings.text = it.servings.toString().plus(" servings")
            }

        }

        viewModel.instructionLiveData.observe(viewLifecycleOwner){
            if (it != null){
                preparationAdapter.data = it
            }
        }
        viewModel.errorLiveData.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), it?.message, Toast.LENGTH_SHORT).show()
        }
        viewModel.networkErrorLiveData.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), "networkErrorLiveData", Toast.LENGTH_SHORT).show()
        }
    }
}