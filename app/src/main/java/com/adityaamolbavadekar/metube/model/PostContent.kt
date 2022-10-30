package com.adityaamolbavadekar.metube.model

data class PostContent(
    var message: String? = null,
    var messageMentions: List<MessageMention> = emptyList(),
    var thumbnailMentions: List<ThumbnailMention> = emptyList(),
    var hasThumbnails: Boolean = false,
    var thumbnails: List<Thumbnail> = emptyList(),
    var thumbnailsSize: Int = thumbnails.size,
    var isTextOnly: Boolean = true,
    var commentsCount: Long = 0,
    var hasComments: Boolean = false,
) {

    fun loadComments() {
        // TODO: 10/30/2022  
    }

}