package com.adityaamolbavadekar.metube.views

import android.content.Context
import android.util.AttributeSet
import com.adityaamolbavadekar.metube.model.Post
import com.google.android.material.card.MaterialCardView

class PostView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {

    private var post: Post? = null
    set(value) {
        field = value
        onPostChanged()
    }

    fun setPost(p: Post, overwrite: Boolean = true) {
        if (overwrite && post != null) return
        this.post = p
    }

    fun getPost() = post

    private fun onPostChanged(){

    }

}