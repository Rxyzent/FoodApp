package com.rxyzent.foodapp.core.repo

import com.rxyzent.foodapp.core.dataProvider.api.SpoonacularApi
import com.rxyzent.foodapp.core.helper.ResultWrapper
import com.rxyzent.foodapp.core.helper.parseResponse
import com.rxyzent.foodapp.core.model.error.UniversalError
import com.rxyzent.foodapp.core.model.information.RecipeInformation
import com.rxyzent.foodapp.core.model.instruction.Instruction
import com.rxyzent.foodapp.core.model.search.SearchResponse
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class DetailRepo @Inject constructor(private val api: SpoonacularApi) {

    suspend fun getInformation(id: Int): ResultWrapper<RecipeInformation?, UniversalError?> {
        return parseResponse(Dispatchers.IO) {
            api.getInformation(id,"3eb04c2b9d0b48aa9e285c05f713dbd6")
        }
    }
    suspend fun getInstruction(id: Int): ResultWrapper<Instruction?, UniversalError?> {
        return parseResponse(Dispatchers.IO) {
            api.getInstruction(id,"3eb04c2b9d0b48aa9e285c05f713dbd6")
        }
    }

}