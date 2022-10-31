package com.adityaamolbavadekar.metube.utils

import com.adityaamolbavadekar.metube.model.*

@Suppress("MemberVisibilityCanBePrivate")
class DataGenerator {

    companion object {
        fun <T> generateItems(size: Int, itemCreator: (Int) -> T): MutableList<T> {
            val list = mutableListOf<T>()
            for (i in 0..size) {
                list.add(itemCreator(i))
            }
            return list
        }

        fun generatePosts(size: Int) = generateItems(size) { createNewPost(it) }

        private fun createNewPost(i: Int): Post {
            val id = Id.get() + i.toString()
            if (i == 0) {
                return Post(id, null, null, null, null)
            }
            val message = "Hello there, i am a human with id=${id}."
            val authorInfo = AuthorInfo(
                authorUserId = id,
                authorUsername = "username@${i}${id.subSequence(0..5)}"
            )
            val content = PostContent(message,thumbnails = listOf(Thumbnail(id,0,0,DateUtils.now(),"https://picsum.photos/id/${i}")))
            val creationInfo = PostCreationInfo()
            if (i.toString().endsWith("0")) {
                authorInfo.authorProfilePicture.newPhotoUrl("https://picsum.photos/id/${i}")
                creationInfo.lastUpdated = System.currentTimeMillis() - 100
            }
            val list = (0..(25 + i)).toList().map { it.toString() }
            return Post(id, authorInfo, content, PostStats(list, list), creationInfo)
        }

    }

}