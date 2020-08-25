package com.example.kotlinproject

import android.app.Application

class AppContext : Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = this
    }

    companion object UtilsThree{
        private lateinit var appContext : AppContext

        fun getContext() : AppContext{
            return appContext
        }

    }
}