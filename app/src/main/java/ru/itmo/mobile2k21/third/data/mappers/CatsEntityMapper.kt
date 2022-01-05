package ru.itmo.mobile2k21.third.data.mappers

import ru.itmo.mobile2k21.third.data.entities.CatEntity
import ru.itmo.mobile2k21.third.domain.entities.Cat

class CatsEntityMapper {
    fun toCat(catEntity: CatEntity): Cat {
        return Cat(
            id = catEntity.id,
            imageUrl = catEntity.imageUrl
        )
    }
    fun toCatEntity(cat: Cat): CatEntity {
        return CatEntity(
            id = cat.id,
            imageUrl = cat.imageUrl
        )
    }
}