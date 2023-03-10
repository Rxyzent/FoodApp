package com.rxyzent.foodapp.core.helper

sealed class ResultWrapper<out S,out E> {
    data class Success<out S>(val code:Int?=null,val response:S?):ResultWrapper<S,Nothing>()
    data class ErrorResponse<out E>(val code: Int?=null,val errorResponse:E?):ResultWrapper<Nothing,E>()
    data class NetworkError(val code: Int?=null,val message:String?=null):ResultWrapper<Nothing,Nothing>()
}

