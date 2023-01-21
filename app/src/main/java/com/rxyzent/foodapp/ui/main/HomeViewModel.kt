package com.rxyzent.foodapp.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rxyzent.foodapp.core.helper.ResultWrapper
import com.rxyzent.foodapp.core.model.error.UniversalError
import com.rxyzent.foodapp.core.model.homeMainData.MainData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.rxyzent.foodapp.core.model.search.Result
import com.rxyzent.foodapp.core.repo.HomeRepo

class HomeViewModel @Inject constructor(
    var repo: HomeRepo
) : ViewModel() {

    val breakfastLiveData=MutableLiveData<ArrayList<Result>>()
    val saladLiveData=MutableLiveData<ArrayList<Result>>()
    val snackLiveData=MutableLiveData<ArrayList<Result>>()
    val drinkLiveData=MutableLiveData<ArrayList<Result>>()
    val soupLiveData=MutableLiveData<ArrayList<Result>>()
    val dessertLiveData=MutableLiveData<ArrayList<Result>>()
    val homeLiveData = MutableLiveData<ArrayList<MainData>>()
    var mainListData = ArrayList<MainData>()
    val errorLiveData=MutableLiveData<UniversalError?>()
    val networkErrorLiveData=MutableLiveData<Nothing>()

    fun getMealData() {

        CoroutineScope(Dispatchers.IO).launch {

            when (val response1 = repo.searchBreakfast()) {
                is ResultWrapper.Success->{
                    //breakfastLiveData.postValue(response1.response?.results)
                    mainListData.add(MainData("Breakfast",response1.response!!.results))
                }
                is ResultWrapper.ErrorResponse->{
                    errorLiveData.postValue(response1.errorResponse)
                }
                is ResultWrapper.NetworkError->{
                    networkErrorLiveData.postValue(null)
                }
            }

            when (val response1 = repo.searchSalad()) {
                is ResultWrapper.Success->{
                    //saladLiveData.postValue(response1.response?.results)
                    mainListData.add(MainData("Salad",response1.response!!.results))
                }
                is ResultWrapper.ErrorResponse->{
                    errorLiveData.postValue(response1.errorResponse)
                }
                is ResultWrapper.NetworkError->{
                    networkErrorLiveData.postValue(null)
                }
            }

            when (val response1 = repo.searchSnack()) {
                is ResultWrapper.Success->{
                   // snackLiveData.postValue(response1.response?.results)
                    mainListData.add(MainData("Snack",response1.response!!.results))
                }
                is ResultWrapper.ErrorResponse->{
                    errorLiveData.postValue(response1.errorResponse)
                }
                is ResultWrapper.NetworkError->{
                    networkErrorLiveData.postValue(null)
                }
            }

            when (val response1 = repo.searchDrink()) {
                is ResultWrapper.Success->{
                   // drinkLiveData.postValue(response1.response?.results)
                    mainListData.add(MainData("Drink",response1.response!!.results))
                }
                is ResultWrapper.ErrorResponse->{
                    errorLiveData.postValue(response1.errorResponse)
                }
                is ResultWrapper.NetworkError->{
                    networkErrorLiveData.postValue(null)
                }
            }

            when (val response1 = repo.searchSoup()) {
                is ResultWrapper.Success->{
                    //soupLiveData.postValue(response1.response?.results)
                    mainListData.add(MainData("Soup",response1.response!!.results))
                }
                is ResultWrapper.ErrorResponse->{
                    errorLiveData.postValue(response1.errorResponse)
                }
                is ResultWrapper.NetworkError->{
                    networkErrorLiveData.postValue(null)
                }
            }

            when (val response1 = repo.searchDesert()) {
                is ResultWrapper.Success->{
                    //dessertLiveData.postValue(response1.response?.results)
                    mainListData.add(MainData("Dessert",response1.response!!.results))
                }
                is ResultWrapper.ErrorResponse->{
                    errorLiveData.postValue(response1.errorResponse)
                }
                is ResultWrapper.NetworkError->{
                    networkErrorLiveData.postValue(null)
                }
            }

            homeLiveData.postValue(mainListData)


        }

    }

    override fun onCleared() {
        Log.d("MainViewModelTAG", "onCleared: ")
        super.onCleared()
    }

}