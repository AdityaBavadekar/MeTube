package com.adityaamolbavadekar.metube.model

data class MessageMention(
    val id:String,
    val userId: String,
    val username: String,
    val displayName: String,
    val profilePicture: ProfilePicture,
    val startIndex: Int = 0,
    val endIndex: Int = 0
)