package com.adityaamolbavadekar.metube.utils

import java.util.*

object Id {
    private const val MAX_LENGTH = 20
    fun get(): String {
        var id = UUID.randomUUID().toString()
        if (id.length > MAX_LENGTH) id = id.substring(0, MAX_LENGTH - 1)
        return id
    }
}