package ru.itmo.mobile2k21.third.data.api

import okhttp3.Response

interface ICatsApi {
    suspend fun getRandomCat(): Response
}