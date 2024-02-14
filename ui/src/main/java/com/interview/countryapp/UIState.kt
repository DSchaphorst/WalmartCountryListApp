package com.interview.countryapp

sealed class UIState {
    class Loading(val isLoading: Boolean = false) : UIState()
    class Success(val response: Any) : UIState()
    class Error(val error: String) : UIState()
}