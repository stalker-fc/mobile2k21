package ru.itmo.mobile2k21.third.domain.usecases

import ru.itmo.mobile2k21.third.data.repositories.ICatsRepository

class GetRandomCatUseCase(private val catsRepository: ICatsRepository) {
    suspend operator fun invoke() = catsRepository.getRandomCat()
}