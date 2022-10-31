package com.adityaamolbavadekar.metube.model

data class ProfilePicture(
    var profileImageUrl: String? = null,
    var profileImageAvatar: String = ProfilePictureAvatarType.NOT_CONFIGURED.name,
) {

    fun imageAvatar() = ProfilePictureAvatarType.valueOf(profileImageAvatar)

    fun hasPhotoUrl(): Boolean =
        imageAvatar() == ProfilePictureAvatarType.PROFILE_PICTURE_URL && profileImageUrl != null

    fun newPhotoUrl(url:String){
        profileImageUrl = url
        profileImageAvatar = ProfilePictureAvatarType.PROFILE_PICTURE_URL.name
    }
}