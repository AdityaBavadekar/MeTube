package com.adityaamolbavadekar.metube.utils

data class Resource<out T>(val status: Status, val data: T?, val message: String?) {

    companion object {

        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): Resource<T> {
            return Resource(Status.ERROR, data, msg)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }

    }

    fun isSuccess() = this.status == Status.SUCCESS
    fun isError() = this.status == Status.ERROR
    fun isLoading() = this.status == Status.LOADING

}
