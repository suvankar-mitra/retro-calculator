package com.suvankarmitra.retrocalculator.helpers

import androidx.appcompat.widget.AppCompatButton

interface Calculator {
    fun evaluate(expression: String) : String
    fun handleButtonPress(type: ButtonType)
}