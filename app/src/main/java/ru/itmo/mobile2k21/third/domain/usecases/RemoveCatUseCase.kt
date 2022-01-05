package ru.itmo.mobile2k21.third.domain.usecases

import ru.itmo.mobile2k21.third.domain.entities.Cat
import ru.itmo.mobile2k21.third.data.repositories.ICatsRepository

class RemoveCatUseCase (private val catsRepository: ICatsRepository) {
    suspend operator fun invoke(cat: Cat) = catsRepository.removeCat(cat)
}