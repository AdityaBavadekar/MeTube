package com.adityaamolbavadekar.metube.model

import com.adityaamolbavadekar.metube.utils.NotNullCheckable

data class Post(
    var id: String? = null,
    var author: AuthorInfo? = null,
    var postContent: PostContent? = null,
    var postStats: PostStats? = null,
    var postCreationInfo: PostCreationInfo? = null
) : NotNullCheckable {

    fun updatePostCreationInfoLastUpdated(lastUpdatedLong: Long) {
        postCreationInfo?.lastUpdated = lastUpdatedLong
    }

    override fun onShouldProvideCheckNotNullData(): Array<out Any?> {
        return arrayOf(id, author, postContent, postStats, postCreationInfo)
    }

}