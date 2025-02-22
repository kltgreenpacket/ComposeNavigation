package com.kyawlinnthant.nav.data

import androidx.datastore.core.Serializer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream

object BandSerializer : Serializer<Band>{
    override val defaultValue: Band
        get() = Band()

    override suspend fun readFrom(input: InputStream): Band {
        return try {
            Json.decodeFromString(
                deserializer = Band.serializer(),
                string = input.readBytes().decodeToString()
            )
        }catch (e : SerializationException){
            e.printStackTrace()
            defaultValue
        }
    }

    override suspend fun writeTo(t: Band, output: OutputStream) {
        withContext(Dispatchers.IO) {
            output.write(
                Json.encodeToString(
                    serializer = Band.serializer(),
                    value = t
                ).encodeToByteArray()
            )
        }
    }
}