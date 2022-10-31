package com.adityaamolbavadekar.metube.utils

import android.util.Patterns

class FieldValidator {

    companion object {

        fun validateIsNotEmpty(text: String?): Boolean {
            return text != null && text.trim().isNotEmpty()
        }

        fun name(text: String?): Boolean {
            return text != null && text(text) && text.length >= NAME_MIN_LENGTH
        }

        fun password(text: String?): Boolean {
            return text != null && text(text) && text.length >= PASSWORD_MIN_LENGTH
        }

        fun email(text: String?): Boolean {
            return text != null && text(text) && Patterns.EMAIL_ADDRESS.toRegex().matches(text)
        }

        fun username(text: String?): Boolean {
            return text != null && text(text) && USERNAME_REGEX.matches(text) && text.length >= USERNAME_MIN_LENGTH
        }

        fun text(text: String?): Boolean {
            return text != null && validateIsNotEmpty(text)
        }

        private const val PASSWORD_MIN_LENGTH = 8
        private const val USERNAME_MIN_LENGTH = 3
        private const val NAME_MIN_LENGTH = 3
        private val USERNAME_REGEX: Regex = """^(?!.*[.]{2,})(?!.*[_]{2,})[\w.]+$""".toRegex()

    }

}
