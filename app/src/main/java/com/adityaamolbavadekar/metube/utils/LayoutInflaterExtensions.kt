package com.adityaamolbavadekar.metube.utils

import android.view.LayoutInflater
import android.view.ViewGroup

fun ViewGroup.inflater(): LayoutInflater {
    return LayoutInflater.from(context)
}