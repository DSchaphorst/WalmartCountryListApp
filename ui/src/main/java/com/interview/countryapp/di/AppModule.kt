package com.interview.countryapp.di

import com.interview.countryapp.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AppModule = module {

    viewModel { MainViewModel(get()) }

    single { createCountryRepository((get())) }

    single { createCountryListUseCase((get())) }
}