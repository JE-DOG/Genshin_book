package com.example.feature.add.chat.vm

import com.example.add.chat.domain.use_case.AddChatUseCase
import com.example.add.chat.domain.use_case.FindUserUseCase
import com.example.core.app.base.vm.BaseViewModel
import com.example.data.chats.list.network.model.ChatJson
import com.example.feature.add.chat.data.network.model.ProfileJson
import com.example.feature.add.chat.model.Profile
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class AddChatViewModel @Inject constructor(
    private val addChatUseCase: AddChatUseCase,
    private val findUserUseCase: FindUserUseCase
): BaseViewModel() {

    private val _state = MutableStateFlow(AddChatViewState())
    val state = _state

    fun getUsersByNick(userNick: String) {

        launchIoCoroutine(
            error =  {

                _state.update { state ->

                    state.copy(
                        isLoading = false,
                        isError = true,
                        chatId = null
                    )

                }

            }
        ) {

            _state.update {

                it.copy(
                    isLoading = true
                )

            }


            val profiles = findUserUseCase.execute(userNick).single().map { profileJson ->
                Profile.fromJson(profileJson as ProfileJson)
            }

            _state.update {

                it.copy(
                    profiles.toMutableList(),
                    isLoading = false
                )

            }

        }

    }

    fun addChatAndGetChatId(userId: String) {

        launchIoCoroutine(
            error = {

                _state.update { state ->

                    state.copy(
                        isLoading = false,
                        isError = true,
                        chatId = null
                    )

                }

            }
        ) {

            _state.update { state ->
                state.copy(
                    isLoading = true
                )
            }

            val chatId = (addChatUseCase.execute(userId) as ChatJson).id

            _state.update { state ->

                state.copy(
                    chatId = chatId
                )

            }

        }

    }

    fun setErrorState(errorState: Boolean){
        _state.update {
            it.copy(
                isError = errorState
            )
        }
    }

}