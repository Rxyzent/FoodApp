package com.rxyzent.foodapp.core.model.information


import com.google.gson.annotations.SerializedName

data class WinePairing(
    @SerializedName("pairedWines")
    val pairedWines: ArrayList<Any>,
    @SerializedName("pairingText")
    val pairingText: String,
    @SerializedName("productMatches")
    val productMatches: ArrayList<Any>
)