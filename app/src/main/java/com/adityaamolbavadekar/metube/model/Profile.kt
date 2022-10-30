package com.adityaamolbavadekar.metube.model

import com.adityaamolbavadekar.metube.utils.NotNullCheckable

data class Profile(
    val id: String? = null,
    val profileAccountInfo: ProfileAccountInfo? = null,
    val accountCreationInfo: AccountVerificationInfo? = null
) : NotNullCheckable {

    override fun onShouldProvideCheckNotNullData(): Array<out Any?> {
        return arrayOf(id, profileAccountInfo, accountCreationInfo)
    }

}