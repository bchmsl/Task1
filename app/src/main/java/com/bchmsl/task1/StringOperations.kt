package com.bchmsl.task1

import android.util.Log.d

class StringOperations {

    fun containsDollar(string: String): Boolean {
        return string.contains("\$")
    }

    fun getReversed(string: String): String {
        return string.reversed()

    }

    fun isPalindrome(string: String): Boolean {
        return string == getReversed(string)
    }
}