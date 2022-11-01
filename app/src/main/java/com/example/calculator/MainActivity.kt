
package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var isNewOp = true
    var oldNumber = ""
    var op = "+"
    private lateinit var da : TextView
    private lateinit var gam : TextView
    private lateinit var ga : TextView
    private lateinit var dev : TextView



    private lateinit var resultTextView: TextView
    lateinit var resutTextView: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.editText)
        da = findViewById<TextView>(R.id.da)
        gam = findViewById<TextView>(R.id.gam)
        ga = findViewById<TextView>(R.id.ga)
        dev = findViewById<TextView>(R.id.dev)
    }
    fun numberEvent(clickedView: View){
        if (clickedView is TextView){
            var text = resultTextView.text.toString()
            val number = clickedView.text.toString()

            if (text == "0"){
                isNewOp=false
                text = ""
            }

            val result = text + number

            resultTextView.text = result
        }
    }

    fun operatorEvent(view: View) {
        isNewOp = true
        oldNumber = resultTextView.text.toString()
        var number:Button = view as Button
        when(number.id){
            da.id -> {op= "+"}
            gam.id -> {op= "*"}
            dev.id -> {op= "/"}
            ga.id -> {op= "-"}

        }

    }

    fun equalEvent(view: View) {
        var newnumber = resultTextView.text.toString()
        var result = 0.0
        when(op){
            "+"->{result=oldNumber.toDouble()+newnumber.toDouble()}
            "*"->{result=oldNumber.toDouble()*newnumber.toDouble()}
            "/"->{result=oldNumber.toDouble()/newnumber.toDouble()}
            "-"->{result=oldNumber.toDouble()-newnumber.toDouble()}
        }
        resultTextView.text = result.toString()
    }



}


