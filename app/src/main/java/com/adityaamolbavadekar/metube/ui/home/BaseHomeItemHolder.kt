package com.adityaamolbavadekar.metube.ui.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.adityaamolbavadekar.metube.model.Post

abstract class BaseHomeItemHolder(v: View) : RecyclerView.ViewHolder(v){

    abstract fun bind(item: Post, position: Int)
    open fun unbind(){}

}