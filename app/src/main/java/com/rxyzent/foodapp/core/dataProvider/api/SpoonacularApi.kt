package com.rxyzent.foodapp.core.dataProvider.api


import com.rxyzent.foodapp.core.model.information.RecipeInformation
import com.rxyzent.foodapp.core.model.instruction.Instruction
import com.rxyzent.foodapp.core.model.search.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SpoonacularApi {

    @GET("recipes/complexSearch")
    suspend fun searchRecipe(
        @Query("query") q:String,
        @Query("apiKey") apiKey:String
    ): Response<SearchResponse?>

    @GET("recipes/{id}/information")
    suspend fun getInformation(
        @Path("id") id:Int,
        @Query("apiKey") apiKey: String
    ):Response<RecipeInformation?>

    @GET("recipes/{id}/analyzedInstructions")
    suspend fun getInstruction(
        @Path("id") id:Int,
        @Query("apiKey") apiKey:String
    ): Response<Instruction?>

    @GET("recipes/complexSearch")
    suspend fun searchRecipeWithType(
        @Query("apiKey") apiKey:String,
        @Query("type") type:String
    ): Response<SearchResponse?>
}


//3eb04c2b9d0b48aa9e285c05f713dbd6