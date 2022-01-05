package ru.itmo.mobile2k21.third.repositories
import ru.itmo.mobile2k21.third.entities.Cat

interface ICatsLocalDataSource {
    suspend fun add(cat: Cat)
    suspend fun remove(cat: Cat)
    suspend fun getAllCats(): List<Cat>
}