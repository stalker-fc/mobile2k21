package ru.itmo.mobile2k21.third.repositories

import ru.itmo.mobile2k21.third.common.Result
import ru.itmo.mobile2k21.third.entities.Cat

class CatsRemoteDataSource: ICatsRemoteDataSource {
    override suspend fun getRandomCat(): Result<Cat> {
        TODO("Not yet implemented")
    }
}