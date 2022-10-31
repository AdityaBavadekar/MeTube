package com.adityaamolbavadekar.metube.model

data class PostStats(
    var viewedBy: List<String> = emptyList(),
    var likedBy: List<String> = emptyList()
) {

    fun getViewCount() = viewedBy.size
    fun getLikeCount() = likedBy.size

}