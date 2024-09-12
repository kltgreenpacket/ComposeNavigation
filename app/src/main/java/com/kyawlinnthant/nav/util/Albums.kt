package com.kyawlinnthant.nav.util

object Albums {
    val albums = listOf(
        "System of a Down (1998)",
        "Toxicity (2001)",
        "Steal This Album! (2002)",
        "Mezmerize (2005)",
        "Hypnotize (2005)",
        "Wake Up the Souls (2015)",
        "Protect the Land (2020)"
    )

    private const val PASSWORD = "SOAD"

    fun validateAlbum(name: String): Boolean {
        if (name.isEmpty()) return false
        val simplifiedInput = name.trim().filter { it.isLetterOrDigit() }.lowercase()
        val simplifiedAlbums = albums.map { album ->
            album.trim().filter {
                it.isLetterOrDigit()
            }.lowercase()
        }
        return simplifiedAlbums.contains(simplifiedInput)
    }

    fun validatePassword(password : String) : Boolean {
        if(password.isEmpty()) return false
        return password == PASSWORD
    }

}