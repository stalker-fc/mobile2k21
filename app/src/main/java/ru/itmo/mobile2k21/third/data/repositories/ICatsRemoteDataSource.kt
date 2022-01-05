package ru.itmo.mobile2k21.third.data.repositories

import ru.itmo.mobile2k21.third.domain.common.Result
import ru.itmo.mobile2k21.third.domain.entities.Cat

interface ICatsRemoteDataSource {
    suspend fun getRandomCat() : Result<Cat>
}