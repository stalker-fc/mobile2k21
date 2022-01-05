package ru.itmo.mobile2k21.third.data.api

import android.util.Log
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException


class CatsApi(private val catsApiUrl: String): ICatsApi {
    private val client = OkHttpClient()

    override suspend fun getRandomCat(): Response {
        val url = "${catsApiUrl}/random_cat"
        Log.i("ThirdTask", url)
        val request = Request.Builder()
            .url(url)
            .build()

        return client.newCall(request).execute()
    }
}