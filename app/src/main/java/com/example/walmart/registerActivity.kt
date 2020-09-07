package com.example.walmat

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.walmart.R
import kotlinx.android.synthetic.main.activity_register.*

class registerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

    }

    fun onCreateAccount(view: View) {
      var first1=  firstnameText.text.toString()
      var last1=  lastnameText.text.toString()
       var email1= emailAddressText.text.toString()
       var password1= passwordText.text.toString()

        if (first1.isNullOrEmpty()){
            Toast.makeText(this, "First name can't be Empty", Toast.LENGTH_LONG).show()
        }
        else if (last1.isNullOrEmpty() ){
            Toast.makeText(this, "Last name can't be Empty", Toast.LENGTH_LONG).show()
        }
           else if (email1.isNullOrEmpty()){
            Toast.makeText(this, "Email address can't be Empty", Toast.LENGTH_LONG).show()
        }
        else if(password1.isNullOrEmpty()){
            Toast.makeText(this, "Password can't be Empty", Toast.LENGTH_LONG).show()
        }
        else {
            Toast.makeText(this, "Account created successfully", Toast.LENGTH_LONG).show()
            val data = Intent()
            val user1 = User(first1, last1, email1, password1)
//---set the data to pass back
            data.putExtra("user", user1)
            setResult(Activity.RESULT_OK, data)
//---close the activity---
            finish()
        }

    }
}