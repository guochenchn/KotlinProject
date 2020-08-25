package com.example.kotlinproject

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.security.spec.ECField

class MainActivity : AppCompatActivity(){
     lateinit var etUserName : EditText
     lateinit  var etPassWord : EditText
     lateinit  var btLogin : Button
    lateinit var btDp : Button
    lateinit var etDp : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         etUserName = findViewById<EditText>(R.id.et_username)
       etPassWord =  findViewById<EditText>(R.id.et_password)
        btLogin = findViewById(R.id.bt_login)
       btDp =  findViewById(R.id.bt_dp)
        etDp = findViewById(R.id.et_dp)
        btLogin.setOnClickListener(object : View.OnClickListener {
            override fun onClick(ar1: View?) {
                if (checkParams()){
                    var  intent = Intent(this@MainActivity,HomeActivity::class.java)
                    startActivity(intent)
                    showToast(AppContext.getContext(),"跳转成功")


                }
            }

          })

        btDp.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {

                UtilsTwo.showToast(this@MainActivity,"换算结果"+UtilsTwo.dp2px(etDp.text.toString().toFloat()).toString())
            }
        })


    }

    private  fun login(){
        var  intent = Intent(this,HomeActivity::class.java)
        startActivity(intent)
        showToast(this,"跳转成功")
    }
    fun checkParams() : Boolean{
        val userName = etUserName.text.toString()
        val password = etPassWord.text.toString()
        if (TextUtils.isEmpty(userName)){
            UtilsTwo.showToast(this,"参数错误")
            return false
        }

        if (TextUtils.isEmpty(password)){
            UtilsTwo.showToast(this,"参数错误")

            return false
        }
        return true
    }
}