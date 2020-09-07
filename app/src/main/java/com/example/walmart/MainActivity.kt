package com.example.walmart

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.walmat.User
import com.example.walmat.registerActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // private lateinit var email1: TextView
    //private lateinit var x:String
    var arr=ArrayList<User>(arrayListOf(User("Blein","Yirdaw","bee@gmail.com","123456"),User("Tadios","Haile","tadi@gmail.com","789012"),User("Tariku","Gelan","tare@gmail.com","345678"),
            User("Tesfaye","Abie","tes@gmail.com","910123") , User("Fasil","Habtegiorgis","faya@gmail.com","456789")
    ))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }

    fun signIn(view: View) {
        var emailT=emailText.text.toString()
        var passWordT=passwordText.text.toString()

        for(a in arr){


            if(emailT == a.username && passWordT == a.password){

                var intent = Intent(this, shoppingActivity::class.java)
                intent.putExtra("email", emailT)
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "invalid Email or Password", Toast.LENGTH_LONG).show()
            }

        }

    }

    fun newAccount(view: View) {
        var intent1= Intent(this, registerActivity::class.java)
        startActivityForResult(intent1,1)


    }
    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {

                val returnedResult = data!!.getSerializableExtra("user") as User

                arr.add(returnedResult)

            }
        }
    }

    fun forgotPassword(view: View) {

        var input = emailText.text.toString()


        if(input.isNullOrEmpty()){
            Toast.makeText(this, "Enter your Email address", Toast.LENGTH_LONG).show()
        }
        else{

            var userPassword:String?=null
            //looping through the arrayList
            for(a in arr){
                if (input.equals(a.username)){ userPassword=a.password } }


            //if userPassword is still null means EmailAddress is invalid
            if( userPassword==null){
                Toast.makeText(this, "invalid Email Address ", Toast.LENGTH_LONG).show()
            }
            else{

                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_EMAIL,input)
                intent.putExtra(Intent.EXTRA_SUBJECT, "Your Password")
                intent.putExtra(Intent.EXTRA_TEXT,"your password is: $userPassword ")
                startActivity(Intent.createChooser(intent, "Send Email"))
            }}
    }
}