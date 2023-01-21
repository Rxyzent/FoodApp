package com.rxyzent.foodapp.ui.main


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.rxyzent.foodapp.core.adapter.home.main.MainAdapter
import com.rxyzent.foodapp.core.dataProvider.db.MyDataBase
import com.rxyzent.foodapp.core.helper.ViewModelProviderFactory
import com.rxyzent.foodapp.core.model.homeMainData.MainData
import com.rxyzent.foodapp.databinding.HomeFragmentBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class HomeFragment:DaggerFragment() {


  private val binding by lazy {
      HomeFragmentBinding.inflate(layoutInflater)
  }

    private val adapter = MainAdapter()

    private var mainListData  = ArrayList<MainData>()

    @Inject
    lateinit var db : MyDataBase

    @Inject
    lateinit var vmProviderFactory: ViewModelProviderFactory
    private val viewModel: HomeViewModel by viewModels { vmProviderFactory }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.mainList.adapter = adapter
        binding.mainList.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)

        binding.searchText.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToSearchFragment()
            findNavController().navigate(action)
        }

        binding.favorite.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToFavoriteFragment()
            findNavController().navigate(action)
        }

        viewModel.getMealData()

        viewModel.homeLiveData.observe(viewLifecycleOwner){
            adapter.data = it
        }

       /* viewModel.breakfastLiveData.observe(viewLifecycleOwner){
            //adapter.addData(MainData("Breakfast",it))
            mainListData.add(MainData("Breakfast",it))
        }
        viewModel.saladLiveData.observe(viewLifecycleOwner){
            //adapter.addData(MainData("Salad",it))
            mainListData.add(MainData("Salad",it))
        }
        viewModel.drinkLiveData.observe(viewLifecycleOwner){
            //adapter.addData(MainData("Drink",it))
            mainListData.add(MainData("Drink",it))
        }
        viewModel.snackLiveData.observe(viewLifecycleOwner){
            //adapter.addData(MainData("Snack",it))
            mainListData.add(MainData("Snack",it))
        }
        viewModel.soupLiveData.observe(viewLifecycleOwner){
            //adapter.addData(MainData("Soup",it))
        }
        viewModel.dessertLiveData.observe(viewLifecycleOwner){
            //adapter.addData(MainData("Dessert",it))
        }*/
        viewModel.errorLiveData.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), it?.message, Toast.LENGTH_SHORT).show()
        }
        viewModel.networkErrorLiveData.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), "networkErrorLiveData", Toast.LENGTH_SHORT).show()
        }

        adapter.clearData()
        adapter.data = mainListData

    }

    override fun onResume() {
        super.onResume()

    }

}