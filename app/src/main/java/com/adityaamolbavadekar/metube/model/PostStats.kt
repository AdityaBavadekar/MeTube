package com.adityaamolbavadekar.metube.model

data class PostStats(
    var viewedBy: List<String> = emptyList(),
    var likedBy: List<String> = emptyList()
) {

    fun getViewCount() = viewedBy.size.toLong()
    fun getLikeCount() = likedBy.size.toLong()

}