package ru.itmo.mobile2k21.third.usecases

import ru.itmo.mobile2k21.third.entities.Cat
import ru.itmo.mobile2k21.third.repositories.ICatsRepository

class RemoveCatUseCase (private val catsRepository: ICatsRepository) {
    suspend operator fun invoke(cat: Cat) = catsRepository.removeCat(cat)
}