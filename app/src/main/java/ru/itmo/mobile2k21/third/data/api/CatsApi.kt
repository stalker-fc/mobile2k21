package ru.itmo.mobile2k21.third.data.api

import com.google.gson.Gson
import okhttp3.*
import java.io.IOException


class CatsApi(private val catsApiUrl: String): ICatsApi {
    private val client = OkHttpClient()

    override suspend fun getRandomCat(): Response {
        val request = Request.Builder()
            .url("${catsApiUrl}/random")
            .build()

        return client.newCall(request).execute()
    }
}