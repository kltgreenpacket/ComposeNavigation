package com.kyawlinnthant.nav.data

import kotlinx.serialization.Serializable

@Serializable
data class Player(
    val name: String,
    val role: String,
    val dob: String,
    val bio: String,
)

fun players(): List<Player> {
    val serj = Player(
        name = "Serj Tankian",
        role = "Lead Vocals, Keyboards",
        dob = "August 21, 1967, in Beirut, Lebanon",
        bio = "Serj Tankian is an Armenian-American singer, songwriter, and multi-instrumentalist. His family moved to Los Angeles when he was young. He co-founded System of a Down with Daron Malakian in 1994. Known for his wide vocal range and powerful, distinctive voice, Tankian is also a political activist and has released solo albums."
    )
    val daron = Player(
        name = "Daron Malakian",
        role = "Guitar, Vocals",
        dob = "July 18, 1975, in Hollywood, California, USA",
        bio = "Daron Malakian is an Armenian-American musician, best known as the guitarist and a primary songwriter for System of a Down. He has a distinctive playing style that incorporates a variety of influences, including Armenian folk music. Malakian is also the frontman of the band Scars on Broadway."
    )
    val shavo = Player(
        name = "Shavo Odadjian",
        role = "Bass, Backing Vocals",
        dob = "April 22, 1974, in Yerevan, Armenian SSR, Soviet Union (now Armenia)",
        bio = "Shavo Odadjian is an Armenian-American musician known for his work as the bassist and backing vocalist for System of a Down. His family moved to Los Angeles when he was a child. Odadjian’s energetic stage presence and bass lines are a significant part of the band’s sound."
    )
    val dolmayan = Player(
        name = "John Dolmayan",
        role = "Drums",
        dob = "July 15, 1973, in Beirut, Lebanon",
        bio = "John Dolmayan is an Armenian-American drummer, known for his dynamic and powerful drumming style. His family moved to Los Angeles during his early years. Dolmayan joined System of a Down in 1997, replacing their original drummer."
    )
    return listOf(
        serj,
        daron,
        shavo,
        dolmayan
    )
}
