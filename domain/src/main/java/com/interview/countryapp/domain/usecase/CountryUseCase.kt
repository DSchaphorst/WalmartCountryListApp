package com.interview.countryapp.domain.usecase

import com.interview.countryapp.domain.model.CountryItems
import com.interview.countryapp.domain.repository.CountryRepository

class CountryUseCase constructor(private val repository: CountryRepository): BaseUseCase<CountryItems>() {
    override suspend fun run(): CountryItems = repository.getCountryList()
}