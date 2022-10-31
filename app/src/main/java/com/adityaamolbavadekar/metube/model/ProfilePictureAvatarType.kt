package com.adityaamolbavadekar.metube.model

import androidx.annotation.DrawableRes
import com.adityaamolbavadekar.metube.R

enum class ProfilePictureAvatarType {
    GAMING, MUSICAL, NOT_CONFIGURED {
        override val drawableRes: Int = R.drawable.ic_baseline_account_circle_24
    },
    PROFILE_PICTURE_URL, SMILE, SPORTS, WORK;

    @DrawableRes
    open val drawableRes: Int = R.drawable.ic_person
}