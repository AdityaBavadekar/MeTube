package com.adityaamolbavadekar.metube.model

import com.adityaamolbavadekar.metube.utils.NotNullCheckable

data class ProfileAccountInfo(
    var userId: String? = null,
    var username: String? = null,
    var displayName: String? = null,
    var phone: String? = null,
    var email: String? = null,
    var profileUrl: String? = null,
    var profileImage: ProfilePicture? = null,
    var deleted: Boolean = false,
    var verified: Boolean = false,
    var type: String = AccountType.PRIVATE.name,
    var contactsMethods: String = ContactMethod.NONE.name,
    var created: Long = 0,
    var lastUpdated: Long = 0,
    var followersCount: Long = 0,
    var followingCount: Long = 0,
    var followers: List<AuthorInfo> = emptyList(),
    var following: List<AuthorInfo> = emptyList(),
    var postsCount: Long = 0,
    var description: String? = null,
    var links: List<String> = emptyList()
) : NotNullCheckable {

    enum class ContactMethod {
        ALL, EMAIL, EMAIL_AND_PHONE, MESSAGING, MESSAGING_AND_EMAIL, MESSAGING_AND_PHONE, NONE, PHONE
    }

    enum class AccountType {
        PRIVATE, PUBLIC
    }

    override fun onShouldProvideCheckNotNullData(): Array<out Any?> {
        return arrayOf(userId, username)
    }

}