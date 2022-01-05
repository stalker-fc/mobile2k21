package ru.itmo.mobile2k21.third.repositories

import ru.itmo.mobile2k21.third.entities.Cat

interface ICatsRepository {
    suspend fun getRandomCat(): Cat

    suspend fun removeCat(cat: Cat)
}