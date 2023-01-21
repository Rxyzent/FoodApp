package com.rxyzent.foodapp.core.model.homeMainData

import com.rxyzent.foodapp.core.model.search.Result

data class MainData(
    var title:String,
    var subData : ArrayList<Result>
    ) {
}