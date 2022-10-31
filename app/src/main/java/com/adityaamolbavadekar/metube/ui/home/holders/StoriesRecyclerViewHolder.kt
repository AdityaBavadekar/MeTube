package com.adityaamolbavadekar.metube.ui.home.holders

import android.view.ViewGroup
import com.adityaamolbavadekar.metube.databinding.StoriesRecyclerviewBinding
import com.adityaamolbavadekar.metube.model.Post
import com.adityaamolbavadekar.metube.ui.home.BaseHomeItemHolder
import com.adityaamolbavadekar.metube.utils.inflater

class StoriesRecyclerViewHolder(private val b: StoriesRecyclerviewBinding) :
    BaseHomeItemHolder(b.root) {

    override fun bind(item: Post, position: Int) {
    }

    constructor(parent: ViewGroup) : this(
        StoriesRecyclerviewBinding.inflate(
            parent.inflater(),
            parent,
            false
        )
    )

}