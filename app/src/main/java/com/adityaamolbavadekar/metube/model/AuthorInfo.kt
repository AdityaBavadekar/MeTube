package com.adityaamolbavadekar.metube.model

import com.adityaamolbavadekar.metube.utils.NotNullCheckable

data class AuthorInfo(
    val authorUserId: String? = null,
    var authorUsername: String? = null,
    var authorDisplayName: String? = null,
    var authorPhone: String? = null,
    var authorEmail: String? = null,
    var authorProfilePicture: ProfilePicture = ProfilePicture(),
    var authorDeleted: Boolean = false,
    var verified: Boolean = false,
) : NotNullCheckable {

    override fun onShouldProvideCheckNotNullData(): Array<out Any?> {
        return arrayOf(authorUserId, authorUsername)
    }
    
}