package com.valeriik.core.feature.state

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.togetherWith
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun <Data, Error> StateComponent(
    modifier: Modifier = Modifier,
    state: AppState<Data, Error>,
    onSuccess: @Composable (Data) -> Unit,
    onError: @Composable (Error) -> Unit = { CircularProgressIndicator(modifier = modifier) },
    onLoading: @Composable () -> Unit = { Text(modifier = modifier, text = "Loading...") }
) {
    when (state) {
        is AppState.Success -> onSuccess(state.data)
        is AppState.Error -> onError(state.error)
        is AppState.Loading -> onLoading()
    }
}

@Composable
fun <Data, Error> AnimatedStateComponent(
    modifier: Modifier = Modifier,
    state: AppState<Data, Error>,
    transitionSpec: AnimatedContentTransitionScope<AppState<Data, Error>>.() -> ContentTransform = {
        fadeIn().togetherWith(fadeOut(animationSpec = tween(90)))
    },
    onSuccess: @Composable (Data) -> Unit,
    onError: @Composable (Error) -> Unit = { CircularProgressIndicator(modifier = modifier) },
    onLoading: @Composable () -> Unit = { Text(modifier = modifier, text = "Loading...") }
) {
    AnimatedContent(state, transitionSpec = transitionSpec) { state ->
        when (state) {
            is AppState.Success -> onSuccess(state.data)
            is AppState.Error -> onError(state.error)
            is AppState.Loading -> onLoading()
        }
    }
}