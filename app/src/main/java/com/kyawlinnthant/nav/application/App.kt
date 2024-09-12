package com.kyawlinnthant.nav.application

import android.app.Application
import com.kyawlinnthant.nav.data.StoreSingleton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class App : Application() {
    private val appScope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    override fun onCreate() {
        super.onCreate()
        appScope.launch {
            StoreSingleton.initRepo(this@App)
        }
    }
}