package com.adityaamolbavadekar.metube.model

data class ProfilePicture(
    val profileImageUrl: String? = null,
    val profileImageAvatar: String = ProfilePictureAvatarType.NOT_SET.name,
    val isSet: Boolean = false
)