package com.example.kotlinproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class CustomViewActivity : AppCompatActivity() {
    var list = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom)
        initView()
        initData()
    }

    private fun initData() {
        for (index in 1..20) {
            list.add(index.toString())
        }

        for ((index, e) in list.withIndex()) {
            println("$e==$index")

        }
    }

    fun initView() {

    }
}