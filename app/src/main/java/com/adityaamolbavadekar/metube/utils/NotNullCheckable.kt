package com.adityaamolbavadekar.metube.utils

interface NotNullCheckable {
    fun onShouldProvideCheckNotNullData(): Array<out Any?>
    fun checkNotNull(): Boolean {
        return ThrowIfNull.check(onShouldProvideCheckNotNullData())
    }
}