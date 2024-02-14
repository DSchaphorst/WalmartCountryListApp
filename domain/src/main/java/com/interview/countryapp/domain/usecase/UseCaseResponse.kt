package com.interview.countryapp.domain.usecase

interface UseCaseResponse <Type> {

    fun onSuccess(result: Type)

    fun onError(e: Exception)
}

