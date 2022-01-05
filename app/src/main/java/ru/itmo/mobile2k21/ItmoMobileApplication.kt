package ru.itmo.mobile2k21

import android.app.Application
import ru.itmo.mobile2k21.third.data.repositories.CatsRepository
import ru.itmo.mobile2k21.third.domain.usecases.GetRandomCatUseCase
import ru.itmo.mobile2k21.third.presentation.di.ServiceLocator
import ru.itmo.mobile2k21.third.presentation.mappers.CatDataMapper

class ItmoMobileApplication  : Application() {
    private val catsRepository: CatsRepository
        get() = ServiceLocator.provideCatsRepository(this)

    val getRandomCatUseCase: GetRandomCatUseCase
        get() = GetRandomCatUseCase(catsRepository)

    val catDataMapper = CatDataMapper()

    override fun onCreate() {
        super.onCreate()
    }
}