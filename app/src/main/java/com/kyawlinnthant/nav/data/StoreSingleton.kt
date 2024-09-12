package com.kyawlinnthant.nav.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

object StoreSingleton {

    private var repo: Store? = null

    private val Context.bandStore by dataStore(
        fileName = "band",
        serializer = BandSerializer
    )

    private fun getProto(context: Context): DataStore<Band> = context.bandStore

    private val Context.authStore by preferencesDataStore(name = "isAuthorized")

    private fun getPref(context: Context): DataStore<Preferences> = context.authStore

    suspend fun initRepo(context: Context) {
        val pref = getPref(context)
        val proto = getProto(context)
        repo = StoreImpl(
            pref = pref,
            proto = proto
        )
        repo?.setBand(Band())
    }

    fun getRepo(): Store {
        return repo
            ?: throw IllegalStateException("Store not initialized. Call initRepo(context) first!")
    }

}
