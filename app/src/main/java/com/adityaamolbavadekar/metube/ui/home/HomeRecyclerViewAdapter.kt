package com.adityaamolbavadekar.metube.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.adityaamolbavadekar.metube.model.Post
import com.adityaamolbavadekar.metube.model.RecyclerViewTypes
import com.adityaamolbavadekar.metube.ui.home.holders.PostItemHolder
import com.adityaamolbavadekar.metube.ui.home.holders.StoriesRecyclerViewHolder

class HomeRecyclerViewAdapter : ListAdapter<Post,BaseHomeItemHolder>(Post.DiffUtillCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHomeItemHolder {
        return when {
            isPost(viewType) -> PostItemHolder(parent)
            isStoryRecyclerView(viewType) -> StoriesRecyclerViewHolder(parent)
            else -> throw IllegalArgumentException()
        }
    }

    override fun onBindViewHolder(holder: BaseHomeItemHolder, position: Int) {
        holder.bind(getItem(position),position)
    }

    private fun isPost(viewType: Int) = viewType == RecyclerViewTypes.POST_ITEM
    private fun isStoryRecyclerView(viewType: Int) = viewType == RecyclerViewTypes.STORIES_HOLDER

    override fun getItemViewType(position: Int): Int {
        return when(requireNotNull(getItem(position)).isAllNull()){
            true -> RecyclerViewTypes.STORIES_HOLDER
            false -> RecyclerViewTypes.POST_ITEM
        }
    }
}