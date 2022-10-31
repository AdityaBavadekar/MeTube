package com.adityaamolbavadekar.metube

import com.adityaamolbavadekar.metube.model.*
import com.adityaamolbavadekar.metube.utils.Id
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.app
import org.junit.After
import org.junit.Before
import org.junit.Test

class DataGeneratorTest {

    private var size = 0

    @Before
    fun setup() {
        println("Starting create posts...")
        for (i in 1..10) {
            val id = Id.get() + i.toString()
            val message = "Hello there, i am a human with id=${id}."
            val authorInfo = AuthorInfo(
                authorUserId = id,
                authorUsername = "username@${i}__${id.subSequence(0..5)}__"
            )
            val content = PostContent(message)
            val list = (0..(25 + i)).toList().map { it.toString() }
            val post = Post(id, authorInfo, content, PostStats(list, list), PostCreationInfo())
            println("\n , ")
            println(post)
            size++
        }
    }

    @After
    fun tearDown() {
        println("Ended with create posts...")
    }

    @Test
    fun create_posts() {
        if (size < 5) throw AssertionError("size < 5 (${size})")
    }

}