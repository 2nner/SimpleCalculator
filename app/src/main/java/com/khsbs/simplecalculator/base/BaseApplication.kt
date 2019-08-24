package com.khsbs.simplecalculator.base

import android.app.Application
import android.content.Context
import com.facebook.stetho.Stetho

class BaseApplication : Application() {

    companion object {
        lateinit var appContext: Context
        const val TAG = "SimpleCalculator"
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this
        Stetho.initializeWithDefaults(this)
    }
}