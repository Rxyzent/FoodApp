package com.rxyzent.foodapp.core.repo

import com.rxyzent.foodapp.core.dataProvider.api.SpoonacularApi
import com.rxyzent.foodapp.core.helper.ResultWrapper
import com.rxyzent.foodapp.core.helper.parseResponse
import com.rxyzent.foodapp.core.model.error.UniversalError
import com.rxyzent.foodapp.core.model.search.SearchResponse
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class SearchRepo @Inject constructor(private val api: SpoonacularApi) {

    suspend fun searchData(q: String): ResultWrapper<SearchResponse?, UniversalError?> {
        return parseResponse(Dispatchers.IO) {
            api.searchRecipe(q, "3eb04c2b9d0b48aa9e285c05f713dbd6")
        }
    }

}