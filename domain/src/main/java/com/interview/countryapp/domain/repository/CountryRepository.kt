package com.interview.countryapp.domain.repository

import com.interview.countryapp.domain.model.CountryItems

interface CountryRepository {
    suspend fun getCountryList(): CountryItems
}