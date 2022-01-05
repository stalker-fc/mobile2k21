package ru.itmo.mobile2k21.third.data.mappers

import ru.itmo.mobile2k21.third.data.api.CatsApiResponse
import ru.itmo.mobile2k21.third.domain.entities.Cat

class CatsApiResponseMapper(
    private val catsApiUrl: String
) {
    fun toCat(response: CatsApiResponse): Cat {
        return Cat(
            id = response.catId,
            imageUrl = getImageUrl(response.catId)
        )
    }

    private fun getImageUrl(catId: Int): String {
        return "${catsApiUrl}/cat/${catId}.jpg"
    }
}