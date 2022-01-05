package ru.itmo.mobile2k21.third.repositories

import ru.itmo.mobile2k21.third.common.Result
import ru.itmo.mobile2k21.third.entities.Cat

class CatsRepository(
    private val localDataSource: ICatsLocalDataSource,
    private val remoteDataSource: ICatsRemoteDataSource
) : ICatsRepository {
    override suspend fun getRandomCat(): Result<Cat> {
        return remoteDataSource.getRandomCat()
    }

    override suspend fun removeCat(cat: Cat) {
        localDataSource.remove(cat)
    }

    override suspend fun getAllCats(): List<Cat> {
       return localDataSource.getAllCats()
    }
}