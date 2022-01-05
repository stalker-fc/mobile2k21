package ru.itmo.mobile2k21.third.data.repositories

import com.google.gson.Gson
import ru.itmo.mobile2k21.third.data.api.CatsApiResponse
import ru.itmo.mobile2k21.third.data.api.ICatsApi
import ru.itmo.mobile2k21.third.data.mappers.CatsApiResponseMapper
import ru.itmo.mobile2k21.third.domain.common.Result
import ru.itmo.mobile2k21.third.domain.entities.Cat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

class CatsRemoteDataSource(
    private val service: ICatsApi,
    private val mapper: CatsApiResponseMapper
): ICatsRemoteDataSource {
    private val gson = Gson()

    override suspend fun getRandomCat(): Result<Cat> =
        withContext(Dispatchers.IO) {
            try {
                val response = service.getRandomCat()
                if (response.isSuccessful) {
                    val catsApiResponse = gson.fromJson(
                        response.body!!.string(),
                        CatsApiResponse::class.java
                    )
                    return@withContext Result.Success(mapper.toCat(catsApiResponse))
                } else {
                    return@withContext Result.Error(Exception(response.message))
                }
            } catch (e: Exception) {
                return@withContext Result.Error(e)
            }
        }
}