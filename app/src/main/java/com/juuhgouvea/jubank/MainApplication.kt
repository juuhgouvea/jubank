package com.juuhgouvea.jubank

import android.app.Application
import android.content.Context


class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }

    companion object {
        var appContext: Context? = null
            private set
    }
}