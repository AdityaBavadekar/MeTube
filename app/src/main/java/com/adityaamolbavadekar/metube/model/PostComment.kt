package com.adityaamolbavadekar.metube.model

import com.adityaamolbavadekar.metube.utils.DateUtils
import com.adityaamolbavadekar.metube.utils.Id

class PostComment(
    val postId: String? = Id.get(),
    var authorInfo: AuthorInfo? = null,
    var fromPostCreator: Boolean = false,
    var message: String? = null,
    var created: Long = DateUtils.now(),
    var updated: Long = created,
    var likeCount: Long = 0,
) {

    constructor(
        authorInfo: AuthorInfo?,
        message: String?,
        fromPostCreator: Boolean
    ) : this(
        postId = Id.get(),
        authorInfo = authorInfo,
        fromPostCreator = fromPostCreator,
        message = message
    )

}