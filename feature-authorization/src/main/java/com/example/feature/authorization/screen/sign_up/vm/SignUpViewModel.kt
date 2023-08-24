package com.example.feature.authorization.screen.sign_up.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.core.app.ui.xml.base.vm.BaseViewModel
import com.example.feature.authorization.domain.use_cases.SignInUseCase
import com.example.feature.authorization.domain.use_cases.SignUpUseCase
import com.example.feature.authorization.screen.sign_in.vm.SignInViewModel
import javax.inject.Inject

class SignUpViewModel(
    private val signUpUseCase: SignUpUseCase
): BaseViewModel() {

    class Factory @Inject constructor(
        private val signUpUseCase: SignUpUseCase
    ): ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return SignUpViewModel(
                signUpUseCase
            ) as T
        }

    }

    private val _state = MutableLiveData(SignUpViewState())
    val state = _state

    fun signUp(
        email: String,
        fullName: String,
        avatarUrl: String,
        password: String
    ){
        launchIoCoroutine(
            error = {
                _state.postValue(
                    state.value!!.copy(
                        isLoading = false,
                        isError = true
                    )
                )
            }
        ) {
            _state.postValue(
                state.value!!.copy(
                    isLoading = true
                )
            )

            signUpUseCase.execute(
                email = email,
                fullname = fullName,
                avatar = avatarUrl,
                password = password
            )

            _state.postValue(
                state.value!!.copy(
                    isLoading = false,
                    isSignUp = true
                )
            )
        }
    }

}