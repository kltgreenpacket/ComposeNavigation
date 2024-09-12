package com.kyawlinnthant.nav.data

import kotlinx.serialization.Serializable

@Serializable
data class Band(
    val name: String = "System Of A Down",
    val players: List<Player> = players()
)
