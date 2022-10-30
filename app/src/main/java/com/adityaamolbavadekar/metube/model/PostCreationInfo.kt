package com.adityaamolbavadekar.metube.model

import com.adityaamolbavadekar.metube.utils.DateUtils

data class PostCreationInfo(
    var created: Long = DateUtils.now(),
    var lastUpdated: Long = created
) {

    fun setLastUpdatedToNow() {
        lastUpdated = DateUtils.now()
    }

}