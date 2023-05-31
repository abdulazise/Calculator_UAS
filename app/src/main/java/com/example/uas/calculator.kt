package com.example.uas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class calculator : Fragment(), View.OnClickListener {

    private lateinit var textViewResult: TextView
    private lateinit var button0: Button
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var buttonAdd: Button
    private lateinit var buttonSubtract: Button
    private lateinit var buttonMultiply: Button
    private lateinit var buttonDivide: Button
    private lateinit var buttonEquals: Button
    private lateinit var buttonClear: Button

    private var currentNumber = ""
    private var operator = ""
    private var operand1 = 0.0
    private var operand2 = 0.0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_calculator, container, false)

        textViewResult = root.findViewById(R.id.textViewResult)
        button0 = root.findViewById(R.id.button0)
        button1 = root.findViewById(R.id.button1)
        button2 = root.findViewById(R.id.button2)
        button3 = root.findViewById(R.id.button3)
        button4 = root.findViewById(R.id.button4)
        button5 =root. findViewById(R.id.button5)
        button6 =root. findViewById(R.id.button6)
        button7 =root. findViewById(R.id.button7)
        button8 =root. findViewById(R.id.button8)
        button9 =root. findViewById(R.id.button9)
        buttonAdd =root. findViewById(R.id.buttonAdd)
        buttonSubtract =root. findViewById(R.id.buttonSubtract)
        buttonMultiply =root. findViewById(R.id.buttonMultiply)
        buttonDivide =root. findViewById(R.id.buttonDivide)
        buttonEquals =root. findViewById(R.id.buttonEquals)
        buttonClear =root. findViewById(R.id.buttonClear)

        button0.setOnClickListener(this)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        buttonAdd.setOnClickListener(this)
        buttonSubtract.setOnClickListener(this)
        buttonMultiply.setOnClickListener(this)
        buttonDivide.setOnClickListener(this)
        buttonEquals.setOnClickListener(this)
        buttonClear.setOnClickListener(this)
        return root
    }


    override fun onClick(view: View) {
        when (view.id) {
            R.id.button0 -> numberPressed("0")
            R.id.button1 -> numberPressed("1")
            R.id.button2 -> numberPressed("2")
            R.id.button3 -> numberPressed("3")
            R.id.button4 -> numberPressed("4")
            R.id.button5 -> numberPressed("5")
            R.id.button6 -> numberPressed("6")
            R.id.button7 -> numberPressed("7")
            R.id.button8 -> numberPressed("8")
            R.id.button9 -> numberPressed("9")
            R.id.buttonAdd -> operatorPressed("+")
            R.id.buttonSubtract -> operatorPressed("-")
            R.id.buttonMultiply -> operatorPressed("*")
            R.id.buttonDivide -> operatorPressed("/")
            R.id.buttonEquals -> equalPressed()
            R.id.buttonClear -> clearPressed()
        }
    }

    private fun numberPressed(number: String) {
        currentNumber += number
        textViewResult.text = currentNumber
    }

    private fun operatorPressed(op: String) {
        operator = op
        operand1 = currentNumber.toDouble()
        currentNumber = ""
    }

    private fun equalPressed() {
        operand2 = currentNumber.toDouble()
        val result: Double = when (operator) {
            "+" -> operand1 + operand2
            "-" -> operand1 - operand2
            "*" -> operand1 * operand2
            "/" -> operand1 / operand2
            else -> 0.0
        }
        textViewResult.text = result.toString()
        currentNumber = ""
    }

    private fun clearPressed() {
        currentNumber = ""
        operator = ""
        operand1 = 0.0
        operand2 = 0.0
        textViewResult.text = "0"
    }

}