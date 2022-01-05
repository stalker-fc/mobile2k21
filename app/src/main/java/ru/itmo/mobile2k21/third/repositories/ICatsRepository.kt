package ru.itmo.mobile2k21.third.repositories

import ru.itmo.mobile2k21.third.common.Result
import ru.itmo.mobile2k21.third.entities.Cat

interface ICatsRepository {
    suspend fun getRandomCat(): Result<Cat>
    suspend fun removeCat(cat: Cat)
    suspend fun getAllCats(): List<Cat>
}