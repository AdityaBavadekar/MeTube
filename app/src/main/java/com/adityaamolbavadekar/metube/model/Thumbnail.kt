package com.adityaamolbavadekar.metube.model

data class Thumbnail(
    val id: String = "",
    val height: Int = 0,
    val width: Int = 0,
    val uploaded: Long = 0,
    val url: String? = null
) {

    fun hasConfiguredLengthAttributes(): Boolean {
        return height != -1 && width != -1
    }

}