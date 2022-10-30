package com.adityaamolbavadekar.metube.utils

class ThrowIfNull {

    companion object{

        /**
         * Checks whether provided value(s) is/are not null.
         *
         * @param data
         * @return true if nullable objects were not found.
         * @throws NullPointerException If some object was null.
         *
         * @author Aditya Bavadekar
         * @since 10/30/2022
         */
        @JvmStatic
        fun check(vararg data : Any?): Boolean {
            data.forEach { requireNotNull(it) { "item in provided data was null." } }
            return true
        }
    }

}