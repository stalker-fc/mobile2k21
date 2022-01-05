package ru.itmo.mobile2k21.third.data.repositories

import ru.itmo.mobile2k21.third.domain.entities.Cat

class CatsLocalDataSource: ICatsLocalDataSource {
    private var newCatIndex: Int = 0
    private val catIdToCat: MutableMap<Int, Cat> = mutableMapOf()
    private val catIdToIndex: MutableMap<Int, Int> = mutableMapOf()

    override suspend fun add(cat: Cat) {
        catIdToCat[cat.id] = cat
        catIdToIndex[cat.id] = newCatIndex
        newCatIndex += 1
    }

    override suspend fun remove(cat: Cat) {
        catIdToCat.remove(cat.id)
        catIdToIndex.remove(cat.id)
    }

    override suspend fun getAllCats(): List<Cat> {
        val orderedCatIds: List<Int> = catIdToIndex
            .toList()
            .sortedBy { (_, value) -> value }
            .map { (key, _) -> key }
        return orderedCatIds.map { catId -> catIdToCat[catId]!! }
    }
}