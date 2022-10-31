package com.adityaamolbavadekar.metube.model

data class PostContent(
    var message: String? = null,
    var messageMentions: List<MessageMention> = emptyList(),
    var thumbnailMentions: List<ThumbnailMention> = emptyList(),
    var thumbnails: List<Thumbnail> = emptyList(),
    var commentsCount: Long = 0,
    var commentsEnabled: Boolean = true,
    var isStory: Boolean = false,
) {

    fun loadComments() {
        // TODO: 10/30/2022  
    }

    fun hasThumbnails() = thumbnails.isNotEmpty()

    fun thumbnailsSize() = thumbnails.size

    fun isTextOnly() = !hasThumbnails() && message != null

    fun hasComments() = commentsCount > 0

    companion object {
        fun newPost(
            message: String? = null,
            messageMentions: List<MessageMention> = emptyList(),
            thumbnailMentions: List<ThumbnailMention> = emptyList(),
            thumbnails: List<Thumbnail> = emptyList()
        ): PostContent {
            return PostContent(
                message,
                messageMentions,
                thumbnailMentions,
                thumbnails,
                0,
                true,
                isStory = false
            )
        }

        fun newStory(
            message: String? = null,
            messageMentions: List<MessageMention> = emptyList(),
            thumbnailMentions: List<ThumbnailMention> = emptyList(),
            thumbnails: List<Thumbnail> = emptyList()
        ): PostContent {
            return PostContent(
                message,
                messageMentions,
                thumbnailMentions,
                thumbnails,
                0,
                commentsEnabled = false,
                isStory = false
            )
        }
    }

}