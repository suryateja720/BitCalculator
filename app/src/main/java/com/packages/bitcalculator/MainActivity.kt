package com.packages.bitcalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.TextView

var resultDisplay: TextView? = null
var inputText: TextView? = null

var n0: Button? = null
var n1: Button? = null
var n2: Button? = null
var n3: Button? = null
var n4: Button? = null
var n5: Button? = null
var n6: Button? = null
var n7: Button? = null
var n8: Button? = null
var n9: Button? = null
var nA: Button? = null
var nB: Button? = null
var nC: Button? = null
var nD: Button? = null
var nE: Button? = null
var nF: Button? = null

var outputType: Button? = null
var inputType: Button? = null

var add: Button? = null
var substract: Button? = null
var multiply: Button? = null
var divide: Button? = null

var and: Button? = null
var or: Button? = null
var xor: Button? = null
var xnor: Button? = null

var mC: Button? = null
var mR: Button? = null
var mPlus: Button? = null
var mMinus: Button? = null
var allClear: Button? = null
var backSpace: Button? = null

var equal: Button? = null
var dot: Button? = null

var digitsLimit: Int = 0
var inputNumberSystem: Int = 10
var outputNumberSystem: Int = 10


var previousOperation: Int? = null
var currentOperation: Int? = null

var refreshTime: Long = 0
var decimalPartLimit: Int = 9
var fractionPartLimit: Int = 16


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        n0 = findViewById(R.id.n0)
        n1 = findViewById(R.id.n1)
        n2 = findViewById(R.id.n2)
        n3 = findViewById(R.id.n3)
        n4 = findViewById(R.id.n4)
        n5 = findViewById(R.id.n5)
        n6 = findViewById(R.id.n6)
        n7 = findViewById(R.id.n7)
        n8 = findViewById(R.id.n8)
        n9 = findViewById(R.id.n9)
        nA = findViewById(R.id.na)
        nB = findViewById(R.id.nb)
        nC = findViewById(R.id.nc)
        nD = findViewById(R.id.nd)
        nE = findViewById(R.id.ne)
        nF = findViewById(R.id.nf)

        outputType = findViewById(R.id.output_type)
        inputType = findViewById(R.id.input_type)

        add = findViewById(R.id.plus)
        substract = findViewById(R.id.minus)
        multiply = findViewById(R.id.mul)
        divide = findViewById(R.id.divide)

        and = findViewById(R.id.and)
        or = findViewById(R.id.or)
        xor = findViewById(R.id.ex_or)
        xnor = findViewById(R.id.ex_nor)

        mC = findViewById(R.id.m_clear)
        mR = findViewById(R.id.m_result)
        mPlus = findViewById(R.id.m_plus)
        mMinus = findViewById(R.id.m_minus)
        allClear = findViewById(R.id.all_clear)
        backSpace = findViewById(R.id.backspace)

        equal = findViewById(R.id.equal_to)
        dot = findViewById(R.id.dot)

        resultDisplay = findViewById(R.id.result_display)
        inputText = findViewById(R.id.input_text)

        digitsLimit = decimalPartLimit + fractionPartLimit + 1

        inputType?.text = "DEC(10)"
        inputNumberSystem = 10
        disableAllInputButtons()
        alterInputButtons(inputNumberSystem)
        outputType?.text = "DEC(10)"
        outputNumberSystem = 10

        inputText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                convertInput(p0.toString(), inputNumberSystem, outputNumberSystem)
            }
        })

//Input Buttons...
        dot?.setOnClickListener {
            if ((inputText?.text?.length!! < digitsLimit) && !(inputText?.text?.contains('.')!!)) {
                if (inputText?.text?.isEmpty()!!) {
                    inputText?.text = "${inputText?.text}0."
                } else {
                    inputText?.text = "${inputText?.text}."
                }
            }
        }
        n0?.setOnClickListener {
            if (inputText?.text?.length!! < digitsLimit && checkForLimits()) {
                inputText?.text = "${inputText?.text}0"
            }
        }
        n1?.setOnClickListener {

            if (inputText?.text?.length!! < digitsLimit && checkForLimits()) {
                inputText?.text = "${inputText?.text}1"
            }
        }
        n2?.setOnClickListener {
            if (inputText?.text?.length!! < digitsLimit && checkForLimits()) {
                inputText?.text = "${inputText?.text}2"
            }
        }
        n3?.setOnClickListener {
            if (inputText?.text?.length!! < digitsLimit && checkForLimits()) {
                inputText?.text = "${inputText?.text}3"
            }
        }
        n4?.setOnClickListener {
            if (inputText?.text?.length!! < digitsLimit && checkForLimits()) {
                inputText?.text = "${inputText?.text}4"
            }
        }
        n5?.setOnClickListener {
            if (inputText?.text?.length!! < digitsLimit && checkForLimits()) {
                inputText?.text = "${inputText?.text}5"
            }
        }
        n6?.setOnClickListener {
            if (inputText?.text?.length!! < digitsLimit && checkForLimits()) {
                inputText?.text = "${inputText?.text}6"
            }
        }
        n7?.setOnClickListener {
            if (inputText?.text?.length!! < digitsLimit && checkForLimits()) {
                inputText?.text = "${inputText?.text}7"
            }
        }
        n8?.setOnClickListener {
            if (inputText?.text?.length!! < digitsLimit && checkForLimits()) {
                inputText?.text = "${inputText?.text}8"
            }
        }
        n9?.setOnClickListener {
            if (inputText?.text?.length!! < digitsLimit && checkForLimits()) {
                inputText?.text = "${inputText?.text}9"
            }
        }
        nA?.setOnClickListener {
            if (inputText?.text?.length!! < digitsLimit && checkForLimits()) {
                inputText?.text = "${inputText?.text}A"
            }
        }
        nB?.setOnClickListener {
            if (inputText?.text?.length!! < digitsLimit && checkForLimits()) {
                inputText?.text = "${inputText?.text}B"
            }
        }
        nC?.setOnClickListener {
            if (inputText?.text?.length!! < digitsLimit && checkForLimits()) {
                inputText?.text = "${inputText?.text}C"
            }
        }
        nD?.setOnClickListener {
            if (inputText?.text?.length!! < digitsLimit && checkForLimits()) {
                inputText?.text = "${inputText?.text}D"
            }
        }
        nE?.setOnClickListener {
            if (inputText?.text?.length!! < digitsLimit && checkForLimits()) {
                inputText?.text = "${inputText?.text}E"
            }
        }
        nF?.setOnClickListener {
            if (inputText?.text?.length!! < digitsLimit && checkForLimits()) {
                inputText?.text = "${inputText?.text}F"
            }
        }
        backSpace?.setOnClickListener {
            if (inputText?.text?.isNotEmpty()!!) {
                inputText?.text = inputText?.text?.substring(0, inputText?.text?.length?.minus(1)!!)
            }
        }
        allClear?.setOnClickListener {
            inputText?.text = ""
            resultDisplay?.text = ""
            previousOperation = null
        }
        add?.setOnClickListener {
            currentOperation = 0
            newOperation()
        }
        substract?.setOnClickListener {
            currentOperation = 1
            newOperation()
        }
        multiply?.setOnClickListener {
            currentOperation = 2
            newOperation()
        }
        divide?.setOnClickListener {
            currentOperation = 3
            newOperation()
        }
        equal?.setOnClickListener {
            newOperation()
        }
        inputType?.setOnClickListener {
            disableAllInputButtons()
            when (inputNumberSystem) {
                2 -> {
                    inputNumberSystem = 3
                    inputType?.text = "TRN(3)"
                    alterInputButtons(inputNumberSystem)
                }
                3 -> {
                    inputNumberSystem = 4
                    inputType?.text = "QDR(4)"
                    alterInputButtons(inputNumberSystem)
                }
                4 -> {
                    inputNumberSystem = 8
                    inputType?.text = "OCT(8)"
                    alterInputButtons(inputNumberSystem)
                }
                8 -> {
                    inputNumberSystem = 10
                    inputType?.text = "DEC(10)"
                    alterInputButtons(inputNumberSystem)
                }
                10 -> {
                    inputNumberSystem = 16
                    inputType?.text = "HEX(16)"
                    alterInputButtons(inputNumberSystem)
                }
                16 -> {
                    inputNumberSystem = 2
                    inputType?.text = "BNR(2)"
                    alterInputButtons(inputNumberSystem)
                }
            }
        }
        outputType?.setOnClickListener {
            when (outputNumberSystem) {
                2 -> {
                    outputNumberSystem = 3
                    outputType?.text = "TRN(3)"
                }
                3 -> {
                    outputNumberSystem = 4
                    outputType?.text = "QDR(4)"
                }
                4 -> {
                    outputNumberSystem = 8
                    outputType?.text = "OCT(8)"
                }
                8 -> {
                    outputNumberSystem = 10
                    outputType?.text = "DEC(10)"
                }
                10 -> {
                    outputNumberSystem = 16
                    outputType?.text = "HEX(16)"
                }
                16 -> {
                    outputNumberSystem = 2
                    outputType?.text = "BNR(2)"
                }
            }
        }
// Input Buttons Ends......

    }

    private fun checkForLimits(): Boolean {
        return if (inputText?.text!!.contains(".")) {
            inputText?.text!!.split(".")[1].length < fractionPartLimit
        } else {
            inputText?.text!!.split(".")[0].length < decimalPartLimit
        }
    }

    private fun disableAllInputButtons() {
        n0?.isEnabled = false
        n1?.isEnabled = false
        n2?.isEnabled = false
        n3?.isEnabled = false
        n4?.isEnabled = false
        n5?.isEnabled = false
        n6?.isEnabled = false
        n7?.isEnabled = false
        n8?.isEnabled = false
        n9?.isEnabled = false
        nA?.isEnabled = false
        nB?.isEnabled = false
        nC?.isEnabled = false
        nD?.isEnabled = false
        nE?.isEnabled = false
        nF?.isEnabled = false
        n0?.setTextColor(resources.getColor(R.color.white))
        n1?.setTextColor(resources.getColor(R.color.white))
        n2?.setTextColor(resources.getColor(R.color.white))
        n3?.setTextColor(resources.getColor(R.color.white))
        n4?.setTextColor(resources.getColor(R.color.white))
        n5?.setTextColor(resources.getColor(R.color.white))
        n6?.setTextColor(resources.getColor(R.color.white))
        n7?.setTextColor(resources.getColor(R.color.white))
        n8?.setTextColor(resources.getColor(R.color.white))
        n9?.setTextColor(resources.getColor(R.color.white))
        nA?.setTextColor(resources.getColor(R.color.white))
        nB?.setTextColor(resources.getColor(R.color.white))
        nC?.setTextColor(resources.getColor(R.color.white))
        nD?.setTextColor(resources.getColor(R.color.white))
        nE?.setTextColor(resources.getColor(R.color.white))
        nF?.setTextColor(resources.getColor(R.color.white))
    }

    private fun convertInput(input: String, inputSystem: Int, outputSystem: Int) {
        if (input == "") {
            resultDisplay?.text = ""
        } else {
            when (inputSystem) {
                2 -> {
                    when (outputSystem) {
                        2 -> resultDisplay?.text = ConvertDecimalInput().ConvertToBNR(input)
                        3 -> resultDisplay?.text = ConvertDecimalInput().ConvertToTRN(input)
                        4 -> resultDisplay?.text = ConvertDecimalInput().ConvertToQDR(input)
                        8 -> resultDisplay?.text = ConvertDecimalInput().ConvertToOCT(input)
                        16 -> resultDisplay?.text = ConvertDecimalInput().ConvertToHEX(input)
                    }
                }
                3 -> {
                    when (outputSystem) {
                        2 -> resultDisplay?.text = ConvertDecimalInput().ConvertToBNR(input)
                        3 -> resultDisplay?.text = ConvertDecimalInput().ConvertToTRN(input)
                        4 -> resultDisplay?.text = ConvertDecimalInput().ConvertToQDR(input)
                        8 -> resultDisplay?.text = ConvertDecimalInput().ConvertToOCT(input)
                        16 -> resultDisplay?.text = ConvertDecimalInput().ConvertToHEX(input)
                    }
                }
                4 -> {
                    when (outputSystem) {
                        2 -> resultDisplay?.text = ConvertDecimalInput().ConvertToBNR(input)
                        3 -> resultDisplay?.text = ConvertDecimalInput().ConvertToTRN(input)
                        4 -> resultDisplay?.text = ConvertDecimalInput().ConvertToQDR(input)
                        8 -> resultDisplay?.text = ConvertDecimalInput().ConvertToOCT(input)
                        16 -> resultDisplay?.text = ConvertDecimalInput().ConvertToHEX(input)
                    }
                }
                8 -> {
                    when (outputSystem) {
                        2 -> resultDisplay?.text = ConvertDecimalInput().ConvertToBNR(input)
                        3 -> resultDisplay?.text = ConvertDecimalInput().ConvertToTRN(input)
                        4 -> resultDisplay?.text = ConvertDecimalInput().ConvertToQDR(input)
                        8 -> resultDisplay?.text = ConvertDecimalInput().ConvertToOCT(input)
                        16 -> resultDisplay?.text = ConvertDecimalInput().ConvertToHEX(input)
                    }
                }
                10 -> {
                    when (outputSystem) {
                        2 -> resultDisplay?.text = ConvertDecimalInput().ConvertToBNR(input)
                        3 -> resultDisplay?.text = ConvertDecimalInput().ConvertToTRN(input)
                        4 -> resultDisplay?.text = ConvertDecimalInput().ConvertToQDR(input)
                        8 -> resultDisplay?.text = ConvertDecimalInput().ConvertToOCT(input)
                        10 -> resultDisplay?.text = input
                        16 -> resultDisplay?.text = ConvertDecimalInput().ConvertToHEX(input)
                    }
                }
                16 -> {
                    when (outputSystem) {
                        2 -> resultDisplay?.text = ConvertDecimalInput().ConvertToBNR(input)
                        3 -> resultDisplay?.text = ConvertDecimalInput().ConvertToTRN(input)
                        4 -> resultDisplay?.text = ConvertDecimalInput().ConvertToQDR(input)
                        8 -> resultDisplay?.text = ConvertDecimalInput().ConvertToOCT(input)
                        16 -> resultDisplay?.text = ConvertDecimalInput().ConvertToHEX(input)
                    }
                }
            }

        }
    }

    private fun alterInputButtons(inputSystem: Int) {
        inputText?.text = ""
        inputType?.isEnabled = false
        Handler().postDelayed({
            if (inputSystem > 0) {
                n0?.isEnabled = inputSystem > 0
                n0?.setTextColor(resources.getColor(R.color.grey))
            } else {
                n0?.setTextColor(resources.getColor(R.color.grey_light))
            }
        }, 100)
        Handler().postDelayed({
            if (inputSystem > 1) {
                n1?.isEnabled = inputSystem > 1
                n1?.setTextColor(resources.getColor(R.color.grey))
            } else {
                n1?.setTextColor(resources.getColor(R.color.grey_light))
            }
        }, 150)
        Handler().postDelayed({
            if (inputSystem > 2) {
                n2?.isEnabled = inputSystem > 2
                n2?.setTextColor(resources.getColor(R.color.grey))
            } else {
                n2?.setTextColor(resources.getColor(R.color.grey_light))
            }
        }, 200)
        Handler().postDelayed({
            if (inputSystem > 3) {
                n3?.isEnabled = inputSystem > 3
                n3?.setTextColor(resources.getColor(R.color.grey))
            } else {
                n3?.setTextColor(resources.getColor(R.color.grey_light))
            }
        }, 250)
        Handler().postDelayed({
            if (inputSystem > 4) {
                n4?.isEnabled = inputSystem > 4
                n4?.setTextColor(resources.getColor(R.color.grey))
            } else {
                n4?.setTextColor(resources.getColor(R.color.grey_light))
            }
        }, 300)
        Handler().postDelayed({
            if (inputSystem > 5) {
                n5?.isEnabled = inputSystem > 5
                n5?.setTextColor(resources.getColor(R.color.grey))
            } else {
                n5?.setTextColor(resources.getColor(R.color.grey_light))
            }
        }, 350)
        Handler().postDelayed({
            if (inputSystem > 6) {
                n6?.isEnabled = inputSystem > 6
                n6?.setTextColor(resources.getColor(R.color.grey))
            } else {
                n6?.setTextColor(resources.getColor(R.color.grey_light))
            }
        }, 400)
        Handler().postDelayed({
            if (inputSystem > 7) {
                n7?.isEnabled = inputSystem > 7
                n7?.setTextColor(resources.getColor(R.color.grey))
            } else {
                n7?.setTextColor(resources.getColor(R.color.grey_light))
            }
        }, 450)
        Handler().postDelayed({
            if (inputSystem > 8) {
                n8?.isEnabled = inputSystem > 8
                n8?.setTextColor(resources.getColor(R.color.grey))
            } else {
                n8?.setTextColor(resources.getColor(R.color.grey_light))
            }
        }, 500)
        Handler().postDelayed({
            if (inputSystem > 9) {
                n9?.isEnabled = inputSystem > 9
                n9?.setTextColor(resources.getColor(R.color.grey))
            } else {
                n9?.setTextColor(resources.getColor(R.color.grey_light))
            }
        }, 550)
        Handler().postDelayed({
            if (inputSystem > 10) {
                nA?.isEnabled = inputSystem > 10
                nA?.setTextColor(resources.getColor(R.color.grey))
            } else {
                nA?.setTextColor(resources.getColor(R.color.grey_light))
            }
        }, 600)
        Handler().postDelayed({
            if (inputSystem > 11) {
                nB?.isEnabled = inputSystem > 11
                nB?.setTextColor(resources.getColor(R.color.grey))
            } else {
                nB?.setTextColor(resources.getColor(R.color.grey_light))
            }
        }, 650)
        Handler().postDelayed({
            if (inputSystem > 12) {
                nC?.isEnabled = inputSystem > 12
                nC?.setTextColor(resources.getColor(R.color.grey))
            } else {
                nC?.setTextColor(resources.getColor(R.color.grey_light))
            }
        }, 700)
        Handler().postDelayed({
            if (inputSystem > 13) {
                nD?.isEnabled = inputSystem > 13
                nD?.setTextColor(resources.getColor(R.color.grey))
            } else {
                nD?.setTextColor(resources.getColor(R.color.grey_light))
            }
        }, 750)
        Handler().postDelayed({
            if (inputSystem > 14) {
                nE?.isEnabled = inputSystem > 14
                nE?.setTextColor(resources.getColor(R.color.grey))
            } else {
                nE?.setTextColor(resources.getColor(R.color.grey_light))
            }
        }, 800)
        Handler().postDelayed({
            if (inputSystem > 15) {
                nF?.isEnabled = inputSystem > 15
                nF?.setTextColor(resources.getColor(R.color.grey))
            } else {
                nF?.setTextColor(resources.getColor(R.color.grey_light))
            }
            inputType?.isEnabled = true
        }, 850)

    }

    @SuppressLint("SetTextI18n")
    private fun newOperation() {
        when {
            inputText?.text == "" -> {
                inputText?.text = "Enter the number"
                Handler().postDelayed({
                    inputText?.text = ""
                    add?.isEnabled = true
                }, 1000)
                add?.isEnabled = false
            }
            resultDisplay?.text == "" -> {
                resultDisplay?.text = inputText?.text
                inputText?.text = ""
                previousOperation = currentOperation
            }

            else -> {
                val operand1 = Integer.parseInt(resultDisplay?.text.toString())
                val operand2 = Integer.parseInt(inputText?.text.toString())
                val result: Int =
                    when (previousOperation) {
                        0 -> operand1 + operand2
                        1 -> operand1 - operand2
                        2 -> operand1 * operand2
                        3 -> operand1 / operand2
                        else -> 0
                    }
                previousOperation = currentOperation
                resultDisplay?.text = result.toString()
                inputText?.text = ""
            }
        }
    }
}