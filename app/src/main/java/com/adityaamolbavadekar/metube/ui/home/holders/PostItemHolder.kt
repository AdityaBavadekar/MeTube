package com.adityaamolbavadekar.metube.ui.home.holders

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.ViewGroup
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.adityaamolbavadekar.metube.R
import com.adityaamolbavadekar.metube.databinding.PostItemBinding
import com.adityaamolbavadekar.metube.model.Post
import com.adityaamolbavadekar.metube.ui.home.BaseHomeItemHolder
import com.adityaamolbavadekar.metube.utils.DateUtils
import com.adityaamolbavadekar.metube.utils.inflater
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

class PostItemHolder(private val b: PostItemBinding) : BaseHomeItemHolder(b.root) {

    private lateinit var post: Post
    private lateinit var context: Context

    override fun bind(item: Post, position: Int) {
        context = b.root.context
        item.checkNotNull()
        post = item
        item.postStats!!.getLikeCount().let {
            b.likesCount.text = context.getString(R.string.Post_likes_count, it)
        }
        item.postContent!!.also {
            initMessage()
            initThumbnails()
        }
        item.postCreationInfo!!.also {
            initTimestamp()
        }
        initActions()
        initToolbar()
    }

    private fun initToolbar() {
        b.profilePicture.also {
            val profilePicture = post.authorInfo!!.authorProfilePicture
            if (profilePicture.hasPhotoUrl()) {
                Glide.with(it)
                    .load(post.authorInfo!!.authorProfilePicture.profileImageUrl!!)
                    .into(it)
            } else {
                it.setImageResource(profilePicture.imageAvatar().drawableRes)
            }
        }
        b.username.also {
            it.text = post.authorInfo!!.authorUsername!!
        }
    }

    private fun initMessage() {
        val message = post.postContent!!.message
        if (message == null) {
            b.message.text = null
            b.message.isGone = true
        } else {
            buildSpannedString {
                bold {
                    append(post.authorInfo!!.authorUsername!!)
                    append(" ")
                }
                append(message)
            }.also { b.message.text = it }
        }
    }

    private fun initThumbnails() {
        if (!post.postContent!!.hasThumbnails()) {
            b.imageView.isGone = true
            hideImageLoading()
            return Glide.with(context).clear(b.imageView)
        }
        showImageLoading()
        Glide.with(context)
            .load(post.postContent!!.thumbnails.first().url)
            .addListener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    hideImageLoading()
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    hideImageLoading()
                    return false
                }

            })
            .error(R.drawable.ic_broken_image)
            .into(b.imageView)
    }

    private fun initTimestamp() {
        if (post.postCreationInfo!!.wasEdited()) {
            DateUtils.getTimeSpanInAgo(context, post.postCreationInfo!!.lastUpdated)
                .also { b.timestamp.text = context.getString(R.string.Post_timestamp_edited, it) }
        } else {
            DateUtils.getTimeSpanInAgo(context, post.postCreationInfo!!.created)
                .also { b.timestamp.text = it }
        }
    }

    private fun initActions() {
        b.likeButton.setOnClickListener {
            it.isSelected = !it.isSelected
        }
        b.shareButton.setOnClickListener {

        }
        b.saveButton.setOnClickListener {
            it.isSelected = !it.isSelected
        }
    }

    private fun showImageLoading() {
        b.progressBarHolder.isVisible = true
    }

    private fun hideImageLoading() {
        b.progressBarHolder.isGone = true
    }

    constructor(parent: ViewGroup) : this(PostItemBinding.inflate(parent.inflater(), parent, false))

}