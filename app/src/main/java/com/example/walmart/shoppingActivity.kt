package com.example.walmart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.walmart.R
import kotlinx.android.synthetic.main.activity_shopping.*

class shoppingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)
        var intent= getIntent()
       var  emails= intent.getStringExtra("email")
        welcome.setText("welcome $emails")
    }

    fun electronicClick(view: View) {
        Toast.makeText(this, "You have chosen the Electronics category of shopping", Toast.LENGTH_LONG).show()
    }
    fun clothClick(view: View) {
        Toast.makeText(this, "You have chosen the Clothing category of shopping", Toast.LENGTH_LONG).show()
    }
    fun beautyClick(view: View) {
        Toast.makeText(this, "You have chosen the Beauty category of shopping", Toast.LENGTH_LONG).show()
    }
    fun foodClick(view: View) {
        Toast.makeText(this, "You have chosen the Food category of shopping", Toast.LENGTH_LONG).show()
    }
}
