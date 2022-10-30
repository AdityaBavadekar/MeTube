package com.adityaamolbavadekar.metube.model

data class ThumbnailMention(
    val thumbnailId: String,
    val id: String,
    val userId: String,
    val username: String,
    val displayName: String,
    val profilePicture: ProfilePicture
)