package com.tapdevs.base.network.rest

class NoAccessException(message: String, cause: Throwable) : Throwable(message, cause)
class InvalidDomainException(message: String, cause: Throwable) : Throwable(message, cause)
class ValidationException(message: String, cause: Throwable) : Throwable(message, cause)