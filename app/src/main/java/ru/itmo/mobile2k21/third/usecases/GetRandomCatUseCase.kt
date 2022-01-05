package ru.itmo.mobile2k21.third.usecases

import ru.itmo.mobile2k21.third.repositories.ICatsRepository

class GetRandomCatUseCase(private val catsRepository: ICatsRepository) {
    suspend operator fun invoke() = catsRepository.getRandomCat()
}