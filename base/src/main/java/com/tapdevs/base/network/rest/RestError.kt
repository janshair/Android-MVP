package com.tapdevs.base.network.rest

class RestError {

    public fun getError(
        nonFieldErrors: List<String>,
        cause: Throwable
    ): Throwable {
        return if (nonFieldErrors.contains("OVER_QUERY_LIMIT")) {
            LocationLookupOverQueryLimit(cause)
        } else {
            ValidationException(nonFieldErrors[0], cause)
        }
    }
}
