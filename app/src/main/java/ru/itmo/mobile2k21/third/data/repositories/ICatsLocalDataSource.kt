package ru.itmo.mobile2k21.third.data.repositories
import ru.itmo.mobile2k21.third.domain.entities.Cat

interface ICatsLocalDataSource {
    suspend fun add(cat: Cat)
    suspend fun remove(cat: Cat)
    suspend fun getAllCats(): List<Cat>
}