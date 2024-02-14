package com.interview.countryapp.domain.usecase

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.util.concurrent.CancellationException

abstract class BaseUseCase<Type>() where Type : Any {

    abstract suspend fun run(): Type
    operator fun invoke(scope: CoroutineScope, onResult: UseCaseResponse<Type>?) {
        scope.launch {
            try {
                val result = run()
                onResult?.onSuccess(result)
            } catch (e: CancellationException) {
                e.printStackTrace()
                onResult?.onError(e)
            } catch (e: Exception) {
                e.printStackTrace()
                onResult?.onError(e)
            }
        }
    }
}