package ru.itmo.mobile2k21.third.presentation.di


import ru.itmo.mobile2k21.BuildConfig
import ru.itmo.mobile2k21.third.data.api.CatsApi
import ru.itmo.mobile2k21.third.data.mappers.CatsApiResponseMapper
import ru.itmo.mobile2k21.third.data.mappers.CatsEntityMapper
import ru.itmo.mobile2k21.third.data.repositories.*
import ru.itmo.mobile2k21.third.domain.repositories.ICatsRepository

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

    fun provideCatsRepository(): ICatsRepository {
        // useful because this method can be accessed by multiple threads
        synchronized(this) {
            return catsRepository ?: createCatsRepository()
        }
    }

    private fun createCatsRepository(): ICatsRepository {
        val newRepo =
            CatsRepository(
                createCatsLocalDataSource(),
                createCatsRemoteDataSource()
            )
        catsRepository = newRepo
        return newRepo
    }

    private fun createCatsLocalDataSource(): ICatsLocalDataSource {
        return CatsLocalDataSource(
            catsEntityMapper
        )
    }

    private fun createCatsRemoteDataSource(): ICatsRemoteDataSource {
        return CatsRemoteDataSource(
            catsApi,
            catsApiResponseMapper
        )
    }
}