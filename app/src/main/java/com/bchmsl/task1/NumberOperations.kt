package com.bchmsl.task1

class NumberOperations {

    fun leastCommonMultiple(number1: Int, number2: Int): Int? {
        var lcm = getLargest(number1, number2)
        val result: Int
        while (true) {
            if (lcm % number1 == 0 && lcm % number2 == 0) {
                result = lcm
                break
            }
            ++lcm
        }
        return result
    }

    fun greatestCommonDivisor(number1: Int, number2: Int): Int {
        var gcd = 1
        var result = 1
        while (gcd <= number1 && gcd <= number2) {
            if (number1 % gcd == 0 && number2 % gcd == 0) {
                result = gcd
            }
            gcd++
        }
        return result
    }

    private fun getLargest(number1: Int, number2: Int): Int {
        return if (number1 > number2) number1
        else number2
    }

    fun sumEven(num1: Int, num2: Int): Int {
        if (num1 > num2)
            return 0
        return num1 + sumEven(num1 + 2, num2)
    }
}