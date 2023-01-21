package com.rxyzent.foodapp.core.model.instruction


import com.google.gson.annotations.SerializedName

data class InstructionItem(
    @SerializedName("name")
    val name: String,
    @SerializedName("steps")
    val steps: ArrayList<Step>
)