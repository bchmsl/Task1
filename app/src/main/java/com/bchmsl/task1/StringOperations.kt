package com.bchmsl.task1

import android.util.Log.d

class StringOperations {

    fun containsDollar(string: String): Boolean {
        return string.contains("\$")
    }

    fun getReversed(string: String): String {
        var stringList = string.split("")
        d("TAG", "$stringList")
        stringList = stringList.asReversed()
        d("TAG", stringList.joinToString(""))
        return stringList.joinToString("")
    }

    fun isPalindrome(string: String): Boolean {
        return string == getReversed(string)
    }
}