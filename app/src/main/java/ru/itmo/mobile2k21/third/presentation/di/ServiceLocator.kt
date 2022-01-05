package ru.itmo.mobile2k21.third.presentation.di


import android.content.Context
import ru.itmo.mobile2k21.BuildConfig
import ru.itmo.mobile2k21.third.data.api.CatsApi
import ru.itmo.mobile2k21.third.data.mappers.CatsApiResponseMapper
import ru.itmo.mobile2k21.third.data.mappers.CatsEntityMapper
import ru.itmo.mobile2k21.third.data.repositories.*

object ServiceLocator {
    private val catsEntityMapper by lazy {
        CatsEntityMapper()
    }

    private val catsApiResponseMapper by lazy {
        CatsApiResponseMapper(BuildConfig.API_URL)
    }

    private val catsApi by lazy {
        CatsApi(BuildConfig.API_URL)
    }

    @Volatile
    var catsRepository: CatsRepository? = null

    fun provideCatsRepository(context: Context): CatsRepository {
        // useful because this method can be accessed by multiple threads
        synchronized(this) {
            return catsRepository ?: createCatsRepository(context)
        }
    }

    private fun createCatsRepository(context: Context): CatsRepository {
        val newRepo =
            CatsRepository(
                createCatsLocalDataSource(context),
                createCatsRemoteDataSource(context)
            )
        catsRepository = newRepo
        return newRepo
    }

    private fun createCatsLocalDataSource(context: Context): ICatsLocalDataSource {
        return CatsLocalDataSource(
            catsEntityMapper
        )
    }

    private fun createCatsRemoteDataSource(context: Context): ICatsRemoteDataSource {
        return CatsRemoteDataSource(
            catsApi,
            catsApiResponseMapper
        )
    }
}