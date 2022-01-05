package ru.itmo.mobile2k21.third.presentation.view

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import ru.itmo.mobile2k21.third.domain.common.Result
import ru.itmo.mobile2k21.third.domain.usecases.GetRandomCatUseCase
import ru.itmo.mobile2k21.third.presentation.entities.CatData
import ru.itmo.mobile2k21.third.presentation.mappers.CatDataMapper

class CatViewModel (
    private val getRandomCatUseCase: GetRandomCatUseCase,
    private val mapper: CatDataMapper
): ViewModel() {
    private val _cat = MutableLiveData<CatData>()
    val cat: LiveData<CatData> = _cat

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun loadRandomCat() {
        viewModelScope.launch {
            when (val catResult = getRandomCatUseCase.invoke()) {
                is Result.Success -> {
                    _cat.postValue(mapper.fromCatToCatData(catResult.data))
                }
                is Result.Error -> {
                    _error.postValue(catResult.exception.message)
                }
            }
        }
    }

    class CatViewModelFactory(
        private val getRandomCatUseCase: GetRandomCatUseCase,
        private val mapper: CatDataMapper
    ) :
        ViewModelProvider.NewInstanceFactory() {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CatViewModel(
                getRandomCatUseCase,
                mapper
            ) as T
        }
    }
}