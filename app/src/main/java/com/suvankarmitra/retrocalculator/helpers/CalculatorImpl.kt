package com.suvankarmitra.retrocalculator.helpers

import android.view.View
import androidx.appcompat.widget.AppCompatButton
import com.suvankarmitra.retrocalculator.activities.MainActivity

class CalculatorImpl(private val activity: MainActivity) : Calculator {

    private var operators = arrayListOf("%", "√", "(", ")", "^", "÷", "×", "−", "+")

    override fun evaluate(expression: String): String {
        // TODO evaluate expression
        return "0"
    }

    override fun handleButtonPress(type: ButtonType) {
        when(type) {
            // Action buttons
            ButtonType.BTN_C -> handleClearButtonPress()
            ButtonType.BTN_DEL -> handleDeleteButtonPress()
            ButtonType.BTN_EQUALS -> handleEqualsButtonPress()

            // Operator buttons
            ButtonType.BTN_PERCENT -> handlePercentButtonPress()
            ButtonType.BTN_SQRT -> handleSqrtButtonPress()
            ButtonType.BTN_L_BRACKET -> handleLeftBracketButtonPress()
            ButtonType.BTN_R_BRACKET -> handleRightBracketButtonPress()
            ButtonType.BTN_POWER -> handlePowerButtonPress()
            ButtonType.BTN_DIV -> handleDivisionButtonPress()
            ButtonType.BTN_MUL -> handleMultiplicationButtonPress()
            ButtonType.BTN_MINUS -> handleMinusButtonPress()
            ButtonType.BTN_PLUS -> handlePlusButtonPress()
            else -> TODO("Remove me")
        }
    }

    private fun handlePlusButtonPress() {
        activity.finalResultString += "+";
        activity.showResult()
    }

    private fun handleMinusButtonPress() {
        activity.finalResultString += "−";
        activity.showResult()
    }

    private fun handleMultiplicationButtonPress() {
        activity.finalResultString += "×";
        activity.showResult()
    }

    private fun handleDivisionButtonPress() {
        activity.finalResultString += "÷";
        activity.showResult()
    }

    private fun handlePowerButtonPress() {
        activity.finalResultString += "^";
        activity.showResult()
    }

    private fun handleRightBracketButtonPress() {
        if(activity.finalResultString == "0")
            activity.finalResultString = ")";
        else
            activity.finalResultString += ")";

        activity.showResult()
    }

    private fun handleLeftBracketButtonPress() {
        if(activity.finalResultString == "0")
            activity.finalResultString = "(";
        else
            activity.finalResultString += "(";

        activity.showResult()
    }

    private fun handleSqrtButtonPress() {
        if(activity.finalResultString == "0")
            activity.finalResultString = "√";
        else
            activity.finalResultString += "√";

        activity.showResult()
    }

    private fun handlePercentButtonPress() {
        activity.finalResultString += "%";
        activity.showResult()
    }

    private fun handleEqualsButtonPress() {
        if(operators.any { activity.finalResultString.contains(it) }) {
            activity.finalFormulaString = activity.finalResultString
            activity.finalResultString = "0" // TODO actual expression eval
        }
        activity.showFormula()
        activity.showResult()
    }

    private fun handleDeleteButtonPress() {
        if(activity.finalResultString == "0")
            return
        activity.finalResultString = activity.finalResultString.substring(0, (activity.finalResultString.length - 1))
        activity.showResult()
    }

    private fun handleClearButtonPress() {
        activity.finalResultString = "0"
        activity.showResult()
    }

}