package com.example.walmat

import java.io.Serializable

class User :Serializable{

    lateinit var firstname:String
    lateinit var lastname:String
    lateinit var  username:String
    lateinit var password :String
    constructor(firstname:String="first",lastname:String="last",username:String="user",password :String="123"){
        this.firstname=firstname
        this.lastname=lastname
        this.username=username
        this.password=password
    }
}