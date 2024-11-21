package com.valeriik.core.feature.state

sealed class AppState<Data, Error> {
    class Error<Data, Error>(val error: Error) : AppState<Data, Error>()
    class Success<Data, Error>(val data: Data) : AppState<Data, Error>()
    class Loading<Data, Error> : AppState<Data, Error>()
}