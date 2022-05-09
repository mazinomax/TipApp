package com.example.tipapp

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    var result: TextView? = null
    var tip:TextView? = null
    var amount:TextView? = null
    var seekbarTip: SeekBar? = null
    val tipPercentlabel: TextView? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var initialTip = 10
        seekBarID.progress = initialTip
        TipPercentID.text = "$initialTip%"
        tipDesc(initialTip)



       // var percentage: Double = 0.01

        //seekbarTip = seekBarID

        seekBarID.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                Log.d("seekbar","SUCCESS: $progress")
                TipPercentID.text = "$progress%"
                calcTip()
                tipDesc(progress)



            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

        enteramountID.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                Log.d("TeXT ", "SUCCESS TEXT CHANGED: $s")
                calcTip()

            }

        }) }


    fun calcTip(){
        if (enteramountID.text.isEmpty()){
            tipID.text = ""
            totalID.text = ""
            return
        }


        var amount = enteramountID.text.toString().toDouble()
        var tip_percent = seekBarID.progress

        var tipAmt = amount * tip_percent / 100
        var totalResult = tipAmt + amount

        // update the u.i

        tipID.text = "%.2f".format(tipAmt)

        totalID.text = "%.2f".format(totalResult) }


    fun tipDesc(tips:Int){

        var s =  when (tips) {
            in 0..9 -> "Poor"
            in 10..15 -> "Good"
            in 16 ..25 -> "Amazing"
            in 26 ..30 -> "Welldone"
            else -> "Excellent"
        }

        tvTiprevID.text = s

    }



}