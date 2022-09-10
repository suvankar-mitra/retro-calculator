package com.suvankarmitra.retrocalculator.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.suvankarmitra.retrocalculator.R
import com.suvankarmitra.retrocalculator.helpers.ButtonType
import com.suvankarmitra.retrocalculator.helpers.Calculator
import com.suvankarmitra.retrocalculator.helpers.CalculatorImpl
import kotlinx.android.synthetic.main.view_calc.*

class MainActivity : AppCompatActivity() {

    lateinit var finalResultString : String
    lateinit var finalFormulaString : String
    private lateinit var calculator : Calculator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculator = CalculatorImpl(this)

        finalResultString = calc_result.text!!.toString()
        finalFormulaString = calc_formula.text!!.toString()

        setActionButtonListeners()
        setNumberButtonListeners()
        setOperatorButtonListeners()

    }

    fun showResult() {
        calc_result.text = finalResultString
    }

    fun showFormula() {
        calc_formula.text = finalFormulaString
    }

    private fun setActionButtonListeners() {
        btn_c.setOnClickListener { calculator.handleButtonPress(ButtonType.BTN_C) }
        btn_del.setOnClickListener { calculator.handleButtonPress(ButtonType.BTN_DEL) }
        btn_equals.setOnClickListener { calculator.handleButtonPress(ButtonType.BTN_EQUALS) }
    }

    private fun setNumberButtonListeners() {

    }

    private fun setOperatorButtonListeners() {
        btn_percent.setOnClickListener { calculator.handleButtonPress(ButtonType.BTN_PERCENT) }
        btn_square_root.setOnClickListener { calculator.handleButtonPress(ButtonType.BTN_SQRT) }
        btn_left_parenthesis.setOnClickListener { calculator.handleButtonPress(ButtonType.BTN_L_BRACKET) }
        btn_right_parenthesis.setOnClickListener { calculator.handleButtonPress(ButtonType.BTN_R_BRACKET) }
        btn_power.setOnClickListener { calculator.handleButtonPress(ButtonType.BTN_POWER) }
        btn_division.setOnClickListener { calculator.handleButtonPress(ButtonType.BTN_DIV) }
        btn_multiplication.setOnClickListener { calculator.handleButtonPress(ButtonType.BTN_MUL) }
        btn_minus.setOnClickListener { calculator.handleButtonPress(ButtonType.BTN_MINUS) }
        btn_plus.setOnClickListener { calculator.handleButtonPress(ButtonType.BTN_PLUS) }
    }
}