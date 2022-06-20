package com.bchmsl.task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import com.bchmsl.task1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        init()
    }

    private fun init() {
        listeners()
    }

    private fun listeners() {
        var number1: Int
        var number2: Int
        val numberOperations = NumberOperations()
        val stringOperations = StringOperations()

        val etNumber1 = binding.etNumber1
        val etNumber2 = binding.etNumber2
        val etString = binding.etStringInput

        binding.btnGCD.setOnClickListener {
            if (checkNumbers(etNumber1, etNumber2)) {
                number1 = etNumber1.text.toString().toInt()
                number2 = etNumber2.text.toString().toInt()
                binding.tvResultMath.text =
                    numberOperations.greatestCommonDivisor(number1, number2).toString()
            } else {
                Toast.makeText(this, "Please provide Integer numbers.", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnLCM.setOnClickListener {
            if (checkNumbers(etNumber1, etNumber2)) {
                number1 = etNumber1.text.toString().toInt()
                number2 = etNumber2.text.toString().toInt()
                binding.tvResultMath.text =
                    numberOperations.leastCommonMultiple(number1, number2).toString()
            } else {
                Toast.makeText(this, "Please provide Integer numbers.", Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnDollar.setOnClickListener {
            if (checkString(etString)) {
                binding.tvResultString.text =
                    stringOperations.containsDollar(etString.text.toString()).toString()
            }
        }

        binding.btnGetPalindrome.setOnClickListener {
//            if (!checkString(etString)) {
                binding.tvResultString.text =
                    stringOperations.isPalindrome(etString.text.toString()).toString()
//            }
        }

        binding.btnGetNumberReversed.setOnClickListener {
//            if (!checkString(etString)) {
                val reversed = stringOperations.getReversed(etString.text.toString())

                binding.tvResultString.text = reversed
//            }
        }

        binding.btnSumAllEven.setOnClickListener {
            binding.tvResultSumEven.text = numberOperations.sumEven(0, 100).toString()
        }
    }

    private fun checkNumbers(etNumber1: AppCompatEditText, etNumber2: AppCompatEditText): Boolean {
        return if (!etNumber1.text.isNullOrEmpty() && !etNumber2.text.isNullOrEmpty()) {
            try {
                etNumber1.text.toString().toInt()
                etNumber2.text.toString().toInt()
                true
            } catch (e: Exception) {
                false
            }
        } else {
            false
        }
    }

    private fun checkString(string: AppCompatEditText): Boolean {
        return !string.text.isNullOrEmpty()
    }
}