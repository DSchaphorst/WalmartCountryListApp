package com.interview.countryapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.interview.countryapp.domain.model.CountryItems
import com.interview.countryapp.domain.usecase.CountryUseCase
import com.interview.countryapp.domain.usecase.UseCaseResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel constructor(private val countryUseCase: CountryUseCase) : ViewModel() {

    private val _countryList: MutableStateFlow<UIState> = MutableStateFlow(UIState.Loading())
    val countryList: StateFlow<UIState> get() = _countryList

    fun getCountries() {
        _countryList.value = UIState.Loading(true)
        countryUseCase(viewModelScope, object : UseCaseResponse<CountryItems> {
            override fun onSuccess(result: CountryItems) {
                _countryList.value = UIState.Loading()
                _countryList.value = UIState.Success(result)
            }

            override fun onError(e: Exception) {
                _countryList.value = UIState.Loading()
                _countryList.value = UIState.Error(e.message ?: "")
            }
        })
    }
}