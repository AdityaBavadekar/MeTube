package com.adityaamolbavadekar.metube.model

import androidx.recyclerview.widget.DiffUtil
import com.adityaamolbavadekar.metube.utils.NotNullCheckable

data class Post(
    var id: String? = null,
    var authorInfo: AuthorInfo? = null,
    var postContent: PostContent? = null,
    var postStats: PostStats? = null,
    var postCreationInfo: PostCreationInfo? = null
) : NotNullCheckable {

    class DiffUtillCallback : DiffUtil.ItemCallback<Post>() {
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.id == newItem.id // TODO: 10/31/2022 Implement and Use equals().
        }
    }

    fun updatePostCreationInfoLastUpdated(lastUpdatedLong: Long) {
        postCreationInfo?.lastUpdated = lastUpdatedLong
    }

    override fun onShouldProvideCheckNotNullData(): Array<out Any?> {
        return arrayOf(id, authorInfo, postContent, postStats, postCreationInfo)
    }

    fun isAllNull(): Boolean {
        return authorInfo == null && postContent == null && postStats == null && postCreationInfo == null
    }

}