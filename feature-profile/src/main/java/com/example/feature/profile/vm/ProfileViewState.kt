package com.example.feature.profile.vm

import com.example.feature.add.chat.model.Profile

data class ProfileViewState(
    val isLoading: Boolean = false,
    val profile: Profile? = null,
    val isError: Boolean = false
)