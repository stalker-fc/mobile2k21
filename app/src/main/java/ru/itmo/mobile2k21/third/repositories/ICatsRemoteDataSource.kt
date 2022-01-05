package ru.itmo.mobile2k21.third.repositories

import ru.itmo.mobile2k21.third.common.Result
import ru.itmo.mobile2k21.third.entities.Cat

interface ICatsRemoteDataSource {
    suspend fun getRandomCat() : Result<Cat>
}