package com.example.feature.profile.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.core.app.base.vm.BaseViewModel
import com.example.feature.add.chat.model.Profile
import com.example.feature.profile.domain.use_cases.GetProfileUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class ProfileViewModel(
    private val getProfileUseCase: GetProfileUseCase
): BaseViewModel() {

    class Factory @Inject constructor(
        private val getProfileUseCase: GetProfileUseCase
    ): ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ProfileViewModel(
                getProfileUseCase = getProfileUseCase
            ) as T
        }

    }

    private val _state = MutableStateFlow(ProfileViewState())
    val state = _state

    init {
        getProfile()
    }

    fun getProfile() = launchIoCoroutine(
        error = {
            _state.update {
                it.copy(
                    isError = true
                )
            }
        }
    ) {

        _state.update {
            it.copy(
                isLoading = true
            )
        }

        val profile = getProfileUseCase.execute()
            .map {
                Profile.fromDomain(it)
            }
            .single()

        _state.update {
            it.copy(
                isLoading = false,
                profile = profile
            )
        }

    }

}