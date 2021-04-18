package com.example.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.math.sqrt


class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private lateinit var equalsButton: Button
    private lateinit var clearButton: Button
    private lateinit var percentButton: Button
    private lateinit var sqrtbutton: Button
    private lateinit var plusminusbutton: Button



    private var operand: Double = 0.0

    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)
        equalsButton = findViewById(R.id.equalsButton)
        clearButton = findViewById(R.id.clearButton)
        percentButton = findViewById(R.id.percentbutton)
        sqrtbutton = findViewById(R.id.sqrt)
        plusminusbutton = findViewById(R.id.PlusMinus)


        equalsButton.setOnClickListener {

            val secOperandText = resultTextView.text.toString()
            var secOperand: Double = 0.0

            if (!secOperandText.isEmpty()) {
                secOperand = secOperandText.toDouble()
            }

            when(operation) {
                "+" -> resultTextView.text = (operand + secOperand).toString()
                "-" -> resultTextView.text = (operand - secOperand).toString()
                "*" -> resultTextView.text = (operand * secOperand).toString()
                "/" -> resultTextView.text = (operand / secOperand).toString()


            }

        }
        clearButton.setOnClickListener {
            resultTextView.text = " "
            resultTextView.text = " "
        }

        plusminusbutton.setOnClickListener {
            resultTextView.text = "-" + resultTextView.text

        }



    }
    fun percentButtonEvent(view: View)
    {
        val number=(resultTextView.text.toString().toDouble())/100
        resultTextView.text = number.toString()

    }

    fun squareroot(view: View) {
        val number2=(sqrt(resultTextView.text.toString().toDouble()))
        resultTextView.text = number2.toString()
    }



    fun numberClick(view: View) {

        if (view is Button) {

            val number: String = view.text.toString()
            var result: String = resultTextView.text.toString()

            if (result == "0"){
                result = ""
            }

            resultTextView.text = result + number

        }

    }



    fun operationClick(view: View) {

        if (view is Button) {

            if (!resultTextView.text.isEmpty()) {
                operand = resultTextView.text.toString().toDouble()
            }

            resultTextView.text = ""

            operation = view.text.toString()

        }

    }

}