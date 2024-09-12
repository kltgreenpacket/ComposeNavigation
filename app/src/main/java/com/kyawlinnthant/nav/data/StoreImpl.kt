package com.kyawlinnthant.nav.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map

class StoreImpl(
    private val pref: DataStore<Preferences>,
    private val proto: DataStore<Band>
) : Store {

    companion object {
        val AUTH_KEY = booleanPreferencesKey("is-authorized")
    }

    override suspend fun updateAuthorized(authorized: Boolean) {
        pref.edit {
            it[AUTH_KEY] = authorized
        }
    }

    override suspend fun getAuthorized(): Boolean {
        return pref.data.map {
            it[AUTH_KEY]
        }.firstOrNull() ?: false
    }

    override suspend fun setBand(band: Band) {
        val soad = Band()
        proto.updateData {
            it.copy(
                name = soad.name,
                players = soad.players
            )
        }
    }

    override fun getBand(): Flow<Band> {
        return proto.data
    }
}