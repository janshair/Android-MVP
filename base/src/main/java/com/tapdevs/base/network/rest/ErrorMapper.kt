package com.tapdevs.base.network.rest

import com.google.gson.Gson
import retrofit2.HttpException
import java.io.IOException

class ErrorMapper(
    private val gson: Gson
) {

    fun mapErrorToException(throwable: Throwable): Throwable {

        val validationException = getValidationErrorIfPresent(throwable)
        return validationException ?: throwable
    }

    private fun getValidationErrorIfPresent(throwable: Throwable): Throwable? {
        if (throwable is HttpException) {
            val errorBody: String
            try {
                val errorResponse = throwable.response().errorBody()
                if (errorResponse != null) {
                    errorBody = errorResponse.string()
                } else {
                    return throwable
                }
            } catch (e: IOException) {
                return throwable
            }

            val restError = gson.fromJson(errorBody, RestError::class.java)
            return restError.getError(listOf(), throwable)
        }
        return throwable
    }
}
