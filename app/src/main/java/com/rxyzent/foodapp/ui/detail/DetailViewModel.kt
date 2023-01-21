package com.rxyzent.foodapp.ui.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rxyzent.foodapp.core.helper.ResultWrapper
import com.rxyzent.foodapp.core.model.error.UniversalError
import com.rxyzent.foodapp.core.model.information.RecipeInformation
import com.rxyzent.foodapp.core.model.instruction.Instruction
import com.rxyzent.foodapp.core.repo.DetailRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailViewModel @Inject constructor(
    var repo: DetailRepo
) : ViewModel() {

    val informationLiveData= MutableLiveData<RecipeInformation?>()
    val instructionLiveData= MutableLiveData<Instruction?>()
    val errorLiveData= MutableLiveData<UniversalError?>()
    val networkErrorLiveData= MutableLiveData<Nothing>()

    fun getInstruction(id:Int){
        CoroutineScope(Dispatchers.IO).launch {

            val response = repo.getInstruction(id)

            when (response) {
                is ResultWrapper.Success->{
                    instructionLiveData.postValue(response.response)
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
    fun getMealRecipe(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {

            val response = repo.getInformation(id)

            when (response) {
                is ResultWrapper.Success->{
                    informationLiveData.postValue(response.response)
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