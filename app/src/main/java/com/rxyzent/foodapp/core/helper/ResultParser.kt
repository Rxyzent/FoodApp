package com.rxyzent.foodapp.core.helper

import com.google.gson.Gson
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

suspend inline fun<S,reified E>parseResponse(
    dispatcher: CoroutineDispatcher, crossinline  apiCall:suspend ()-> Response<S?>
) :ResultWrapper<S?,E>{
    return withContext(dispatcher){

        try {

            val resp=apiCall.invoke()

            if (resp.code() in 200..299) {
                ResultWrapper.Success(code = resp.code(), response = resp.body())
            } else {
                try {
                    if (resp.errorBody() != null) {
                        val errorResponse = Gson().fromJson(resp.errorBody()!!.string(), E::class.java)
                        ResultWrapper.ErrorResponse(code = resp.code(), errorResponse = errorResponse)
                    } else {
                        ResultWrapper.NetworkError()
                    }
                } catch (e: IOException) {
                    ResultWrapper.NetworkError( message = e.message)
                } catch (e: HttpException) {
                    val errorResponse = Gson().fromJson(e.response()!!.errorBody()!!.string(), E::class.java)
                    ResultWrapper.ErrorResponse(code = e.code(), errorResponse = errorResponse)
                } catch (e: Exception) {
                    ResultWrapper.NetworkError()
                }

            }
        } catch (e: Throwable) {
            ResultWrapper.NetworkError(message = e.message)
        }
    }

}