package ru.itmo.mobile2k21.third.presentation.mappers

import ru.itmo.mobile2k21.third.domain.entities.Cat
import ru.itmo.mobile2k21.third.presentation.entities.CatData

class CatDataMapper {
    fun fromCatToCatData(cat: Cat): CatData {
        return CatData(
            id = cat.id,
            imageUrl = cat.imageUrl
        )
    }
}