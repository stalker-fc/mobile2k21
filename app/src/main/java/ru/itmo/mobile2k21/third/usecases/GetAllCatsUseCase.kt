package ru.itmo.mobile2k21.third.usecases

import ru.itmo.mobile2k21.third.repositories.ICatsRepository

class GetAllCatsUseCase(private val catsRepository: ICatsRepository) {
    suspend operator fun invoke() = catsRepository.getAllCats()
}
