package com.rxyzent.foodapp.core.model.instruction


import com.google.gson.annotations.SerializedName

data class Length(
    @SerializedName("number")
    val number: Int,
    @SerializedName("unit")
    val unit: String
)