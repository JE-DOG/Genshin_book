package com.example.feature.authorization.screen.sign_in.vm

data class SignInViewState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val isProfileDataIncorrect: Boolean = false,
    val isSignIn: Boolean = false
)