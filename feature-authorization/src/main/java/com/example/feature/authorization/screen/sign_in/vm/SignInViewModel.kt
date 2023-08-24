package com.example.feature.authorization.screen.sign_in.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.core.app.ui.xml.base.vm.BaseViewModel
import com.example.feature.authorization.domain.use_cases.SignInUseCase
import io.github.jan.supabase.exceptions.BadRequestRestException
import javax.inject.Inject

class SignInViewModel(
    private val signInUseCase: SignInUseCase
) : BaseViewModel() {

    class Factory @Inject constructor(
        private val signInUseCase: SignInUseCase
    ): ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return SignInViewModel(
                signInUseCase
            ) as T
        }

    }


    private val _state = MutableLiveData(SignInViewState())
    val state = _state

    fun signIn(
        email: String,
        password: String
    ){
        launchIoCoroutine(
            error = {

                if (it is BadRequestRestException){
                    _state.postValue(
                        state.value!!.copy(
                            isLoading = false,
                            isError = true,
                            isProfileDataIncorrect = true
                        )
                    )
                }else {
                    _state.postValue(
                        state.value!!.copy(
                            isLoading = false,
                            isError = true
                        )
                    )
                }

            }
        ) {
            _state.postValue(
                state.value!!.copy(
                    isLoading = true
                )
            )

            signInUseCase.signIn(
                email = email,
                password = password
            )

            _state.postValue(
                state.value!!.copy(
                    isLoading = false,
                    isSignIn = true
                )
            )
        }
    }

}