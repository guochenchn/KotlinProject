package com.example.kotlinproject

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(){
     lateinit var etUserName : EditText
     lateinit  var etPassWord : EditText
     lateinit  var btLogin : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         etUserName = findViewById<EditText>(R.id.et_username)
       etPassWord =  findViewById<EditText>(R.id.et_password)
        btLogin = findViewById(R.id.bt_login)
        btLogin.setOnClickListener(object : View.OnClickListener {
            override fun onClick(ar1: View?) {
                if (checkParams()){
                    var  intent = Intent(this@MainActivity,HomeActivity::class.java)
                    startActivity(intent)

                }
            }

          })


    }

    private  fun login(){
        var  intent = Intent(this,HomeActivity::class.java)
        startActivity(intent)

    }
    fun checkParams() : Boolean{
        val userName = etUserName.text.toString()
        val password = etPassWord.text.toString()
        if (TextUtils.isEmpty(userName)){
            return false
        }

        if (TextUtils.isEmpty(password)){
            return false
        }
        return true
    }
}