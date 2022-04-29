package com.example.tipapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var result: Int? = null
    var tip:Int? = null
    var amount:Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var percentage: Double = 0.01

     CalcTipButton.setOnClickListener {

         try {

             if (!TextUtils.isEmpty(amount.toString()) && !TextUtils.isEmpty(tip.toString())) {

                 amount = enteramountID.text.toString().toInt()
                 tip = enterpercentID.text.toString().toInt()

                 result =
                     (tip!!.toDouble() * amount!!.toDouble() * percentage.toString().toDouble()).toInt()
                 tipID.text = "You have a $tip% Tip worth $result."
                 totalID.text = "You have Received a Total of ${result!! + amount!!}."

             } else if (!TextUtils.isEmpty(amount.toString()) && TextUtils.isEmpty(tip.toString())){
             Toast.makeText(this, "Please Enter Tip...", Toast.LENGTH_LONG).show()
             return@setOnClickListener
         } else if (TextUtils.isEmpty(amount.toString()) && !TextUtils.isEmpty(tip.toString())){
             Toast.makeText(this, "Please Enter Amount...", Toast.LENGTH_LONG).show()

         }

         } catch (e:Exception) {
             Toast.makeText(this, "Please Enter Tip or Amount...", Toast.LENGTH_LONG).show()
         }


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


     }

    }
}