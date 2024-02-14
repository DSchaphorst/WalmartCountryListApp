package com.interview.countryapp.di

import com.interview.countryapp.data.api.APIService
import com.interview.countryapp.data.repository.CountryRepositoryImpl
import com.interview.countryapp.domain.repository.CountryRepository
import com.interview.countryapp.domain.usecase.CountryUseCase
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val TIME_OUT = 30L
private const val BASE_URL = "https://gist.githubusercontent.com/"

val NetworkModule = module {

    single { createService(get()) }

    single { createRetrofit(get(), BASE_URL) }

    single { createOkHttpClient() }

    single { GsonConverterFactory.create() }

}

fun createOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
    return OkHttpClient.Builder()
        .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
        .readTimeout(TIME_OUT, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor).build()
}

fun createRetrofit(okHttpClient: OkHttpClient, url: String): Retrofit {
    return Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun createService(retrofit: Retrofit): APIService {
    return retrofit.create(APIService::class.java)
}

fun createCountryRepository(apiService: APIService): CountryRepository {
    return CountryRepositoryImpl(apiService)
}

fun createCountryListUseCase(postsRepository: CountryRepository): CountryUseCase {
    return CountryUseCase(postsRepository)
}