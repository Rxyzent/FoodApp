package com.rxyzent.foodapp.ui.search

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rxyzent.foodapp.core.helper.ResultWrapper
import com.rxyzent.foodapp.core.model.error.UniversalError
import com.rxyzent.foodapp.core.model.search.Result
import com.rxyzent.foodapp.core.repo.SearchRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    var repo : SearchRepo
): ViewModel() {


    private var currentTime = System.currentTimeMillis()

    val searchLiveData= MutableLiveData<ArrayList<Result>>()
    val errorLiveData= MutableLiveData<UniversalError?>()
    val networkErrorLiveData= MutableLiveData<Nothing>()

    fun searchMeal(name: String) {

        val searchTime = System.currentTimeMillis()

        if((currentTime+2000)>searchTime){
            return
        }
        currentTime = System.currentTimeMillis()

        CoroutineScope(Dispatchers.IO).launch {

            val response = repo.searchData(name)

            when (response) {
                is ResultWrapper.Success->{
                    searchLiveData.postValue(response.response?.results)
                }
                is ResultWrapper.ErrorResponse->{
                    errorLiveData.postValue(response.errorResponse)
                }
                is ResultWrapper.NetworkError->{
                    networkErrorLiveData.postValue(null)
                }
            }


        }

    }

    override fun onCleared() {
        Log.d("MainViewModelTAG", "onCleared: ")
        super.onCleared()
    }

}