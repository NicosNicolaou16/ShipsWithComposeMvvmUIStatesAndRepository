package com.nicos.ships.utils.generic_classes

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?) : Resource<T>(data)
    class Error<T>(message: String? = null, data: T? = null) : Resource<T>(data, message)
}