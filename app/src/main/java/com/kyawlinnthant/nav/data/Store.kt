package com.kyawlinnthant.nav.data

import kotlinx.coroutines.flow.Flow

interface Store {
    suspend fun updateAuthorized(authorized: Boolean)
    suspend fun getAuthorized(): Boolean
    suspend fun setBand(band: Band)
    fun getBand(): Flow<Band>
}