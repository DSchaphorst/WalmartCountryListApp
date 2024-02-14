package com.interview.countryapp.data.repository

import com.interview.countryapp.data.api.APIService
import com.interview.countryapp.domain.model.CountryItems
import com.interview.countryapp.domain.repository.CountryRepository

class CountryRepositoryImpl(private val apiService: APIService): CountryRepository {
    override suspend fun getCountryList(): CountryItems = apiService.getCountryList()
}