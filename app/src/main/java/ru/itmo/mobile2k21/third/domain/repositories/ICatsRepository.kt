package ru.itmo.mobile2k21.third.domain.repositories

import ru.itmo.mobile2k21.third.domain.common.Result
import ru.itmo.mobile2k21.third.domain.entities.Cat

interface ICatsRepository {
    suspend fun getRandomCat(): Result<Cat>
    suspend fun removeCat(cat: Cat)
    suspend fun getAllCats(): List<Cat>
}