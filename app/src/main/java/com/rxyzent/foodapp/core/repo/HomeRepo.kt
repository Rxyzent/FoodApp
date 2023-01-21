package com.rxyzent.foodapp.core.repo

import com.rxyzent.foodapp.core.dataProvider.api.SpoonacularApi
import com.rxyzent.foodapp.core.helper.ResultWrapper
import com.rxyzent.foodapp.core.helper.parseResponse
import com.rxyzent.foodapp.core.model.error.UniversalError
import com.rxyzent.foodapp.core.model.search.SearchResponse
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class HomeRepo @Inject constructor(private val api: SpoonacularApi) {

    suspend fun searchDesert(): ResultWrapper<SearchResponse?, UniversalError?> {
        return parseResponse(Dispatchers.IO) {
            api.searchRecipeWithType( "3eb04c2b9d0b48aa9e285c05f713dbd6","dessert")
        }
    }
    suspend fun searchSalad(): ResultWrapper<SearchResponse?, UniversalError?> {
        return parseResponse(Dispatchers.IO) {
            api.searchRecipeWithType( "3eb04c2b9d0b48aa9e285c05f713dbd6","salad")
        }
    }
    suspend fun searchDrink(): ResultWrapper<SearchResponse?, UniversalError?> {
        return parseResponse(Dispatchers.IO) {
            api.searchRecipeWithType( "3eb04c2b9d0b48aa9e285c05f713dbd6","drink")
        }
    }
    suspend fun searchBreakfast(): ResultWrapper<SearchResponse?, UniversalError?> {
        return parseResponse(Dispatchers.IO) {
            api.searchRecipeWithType( "3eb04c2b9d0b48aa9e285c05f713dbd6","breakfast")
        }
    }
    suspend fun searchSoup(): ResultWrapper<SearchResponse?, UniversalError?> {
        return parseResponse(Dispatchers.IO) {
            api.searchRecipeWithType( "3eb04c2b9d0b48aa9e285c05f713dbd6","soup")
        }
    }
    suspend fun searchSnack(): ResultWrapper<SearchResponse?, UniversalError?> {
        return parseResponse(Dispatchers.IO) {
            api.searchRecipeWithType( "3eb04c2b9d0b48aa9e285c05f713dbd6","snack")
        }
    }

}