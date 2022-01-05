package ru.itmo.mobile2k21.third.data.repositories

import ru.itmo.mobile2k21.third.domain.common.Result
import ru.itmo.mobile2k21.third.domain.entities.Cat
import ru.itmo.mobile2k21.third.domain.repositories.ICatsRepository

class CatsRepository(
    private val localDataSource: ICatsLocalDataSource,
    private val remoteDataSource: ICatsRemoteDataSource
) : ICatsRepository {
    override suspend fun getRandomCat(): Result<Cat> {
        val catResult = remoteDataSource.getRandomCat()
        if (catResult is Result.Success) {
            localDataSource.add(cat = catResult.data)
        }
        return catResult
    }

    override suspend fun removeCat(cat: Cat) {
        localDataSource.remove(cat)
    }

    override suspend fun getAllCats(): List<Cat> {
       return localDataSource.getAllCats()
    }
}