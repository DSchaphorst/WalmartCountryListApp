package com.interview.countryapp.data.api

import com.interview.countryapp.domain.model.CountryItems
import retrofit2.http.GET

interface APIService {

    @GET("peymano-wmt/32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/countries.json")
    suspend fun getCountryList(): CountryItems
}