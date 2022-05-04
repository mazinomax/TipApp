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



       // var percentage: Double = 0.01

        //seekbarTip = seekBarID

        seekBarID.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                Log.d("seekbar","SUCCESS: $progress")
                TipPercentID.text = "$progress%"
                calcTip()



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

        })




//     CalcTipButton.setOnClickListener {
//
//         try {
//
//             if (!TextUtils.isEmpty(amount.toString()) && !TextUtils.isEmpty(tip.toString())) {
//
//                 amount = enteramountID.text.toString().toInt()
//                 tip = enterpercentID.text.toString().toInt()
//
//                 result =
//                     (tip!!.toDouble() * amount!!.toDouble() * percentage.toString().toDouble()).toInt()
//                 tipID.text = "You have a $tip% Tip worth $result."
//                 totalID.text = "You have Received a Total of ${result!! + amount!!}."
//
//             } else if (!TextUtils.isEmpty(amount.toString()) && TextUtils.isEmpty(tip.toString())){
//             Toast.makeText(this, "Please Enter Tip...", Toast.LENGTH_LONG).show()
//             return@setOnClickListener
//         } else if (TextUtils.isEmpty(amount.toString()) && !TextUtils.isEmpty(tip.toString())){
//             Toast.makeText(this, "Please Enter Amount...", Toast.LENGTH_LONG).show()
//
//         }
//
//         } catch (e:Exception) {
//             Toast.makeText(this, "Please Enter Tip or Amount...", Toast.LENGTH_LONG).show()
//         }
//

// else if (enterpercentID.text.toString().length() == 0){
//             Toast.makeText(this, "Please Enter Tip...", Toast.LENGTH_LONG).show()
//             return@setOnClickListener
//         } else if (enteramountID.text.toString().length() == 0){
//             Toast.makeText(this, "Please Enter Amount...", Toast.LENGTH_LONG).show()
//
//         }
//
////         } else if ( !TextUtils.isEmpty(amount.toString()) && TextUtils.isEmpty(tip.toString())) {
//                Toast.makeText(this,"Please Enter Tip...",Toast.LENGTH_LONG).show()
//
//            } else if ( TextUtils.isEmpty(amount.toString()) && !TextUtils.isEmpty(tip.toString())){
//
//             Toast.makeText(this,"Please Enter Amount...",Toast.LENGTH_LONG).show()
//         }


   //  }



    }
    fun calcTip(){
        var amount = enteramountID.text.toString().toDouble()
        var tip_percent = seekBarID.progress

        var tipAmt = amount * tip_percent / 100
        var totalResult = tipAmt + amount

        // update the u.i

        tipID.text = tip_percent.toString()

        totalID.text = totalResult.toString()





    }



}