package com.example.feature.chat.dialog.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.core.app.base.vm.BaseViewModel
import com.example.core.ext.replaceItem
import com.example.faeture.chat.dialog.domain.use_cases.*
import com.example.feature.add.chat.model.Profile
import com.example.feature.chat.dialog.data.network.model.MessageJson
import com.example.feature.chat.dialog.model.Message
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import io.github.jan.supabase.realtime.PostgresAction
import io.github.jan.supabase.realtime.decodeOldRecord
import io.github.jan.supabase.realtime.decodeRecord
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope

class ChatDialogViewModel(
    private val getChatMessagesUseCase: GetChatMessagesUseCase,
    private val sendMessageUseCase: SendMessageUseCase,
    private val broadcastChatMessagesUseCase: BroadcastChatMessagesUseCase,
    private val getProfileByIdUseCase: GetProfileByChatIdUseCase,
    private val userId: String,
    private val chatId: String
): BaseViewModel() {

    class Factory @AssistedInject constructor(
        private val getChatMessagesUseCase: GetChatMessagesUseCase,
        private val sendMessageUseCase: SendMessageUseCase,
        private val broadcastChatMessagesUseCase: BroadcastChatMessagesUseCase,
        private val getProfileByIdUseCase: GetProfileByChatIdUseCase,
        private val userId: String,
        @Assisted(ASSISTED_INJECT_CHAT_ID_KEY)
        private val chatId: String
    ): ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            require(modelClass == ChatDialogViewModel::class.java)
            return ChatDialogViewModel(
                getChatMessagesUseCase = getChatMessagesUseCase,
                sendMessageUseCase = sendMessageUseCase,
                broadcastChatMessagesUseCase = broadcastChatMessagesUseCase,
                getProfileByIdUseCase = getProfileByIdUseCase,
                userId = userId,
                chatId = chatId
            ) as T
        }

        @AssistedFactory
        interface DaggerFactory {

            fun create(
                @Assisted(ASSISTED_INJECT_CHAT_ID_KEY)
                chatId: String
            ): Factory

        }
    }

    private val _state = MutableStateFlow(ChatDialogViewState())
    val state = _state

    @Volatile
    var isBroadcastChat = false

    init {
        getChatMessages()
    }

    fun getChatMessages() = launchIoCoroutine(
        error = {
            errorAction()
        }
    ) {

        _state.update {
            it.copy(
                isLoading = true
            )
        }

        val profile = async {
            getProfileByIdUseCase.execute(chatId)
                .map {
                    Profile.fromDomain(it)
                }
                .single()
        }

        val chatMessages = async {
            getChatMessagesUseCase.execute(
                chatId = chatId
            )
                .single()
                .map { messageDomain ->
                    Message.fromDomain(messageDomain)
                }
        }

        _state.update {
            it.copy(
                isLoading = false,
                isError = false,
                messages = chatMessages.await().toMutableList(),
                profile = profile.await()
            )
        }

        Log.d("UpdateTag","From view model - simple get -> " + chatMessages.await().toString())


        if (!isBroadcastChat){

            val coroutineExceptionHandler = CoroutineExceptionHandler { _, _ ->
                isBroadcastChat = false
            }

            supervisorScope {

                launch(
                    coroutineExceptionHandler
                    +
                    Dispatchers.IO
                ) {

                    isBroadcastChat = true

                    val broadcastFlow = broadcastChatMessagesUseCase.execute(chatId = chatId)

                    broadcastFlow.collect { realtimeAction ->

                        val messages = state.value.messages

                        when (realtimeAction) {

                            is PostgresAction.Update -> {
                                val messageJson = realtimeAction.decodeRecord<MessageJson>()

                                val replaceChat = messages.find {
                                    it.id == messageJson.id
                                }

                                replaceChat?.let { chat ->
                                    messages.replaceItem(
                                        chat,
                                        Message.fromJson(messageJson)
                                    )
                                }

                            }

                            is PostgresAction.Insert -> {
                                val messageJson = realtimeAction.decodeRecord<MessageJson>()

                                messages.add(Message.fromJson(messageJson))
                            }

                            is PostgresAction.Delete -> {
                                val messageJson = realtimeAction.decodeOldRecord<MessageJson>()

                                messages.removeIf { it.id == messageJson.id }
                            }

                            else -> {}

                        }


                        if (realtimeAction !is PostgresAction.Select) {
                            Log.d("UpdateTag","From view model - realtime -> " + _state.value.messages.toString())
                            _state.update {

                                it.copy(
                                    messages = messages,
                                    update = !it.update
                                )

                            }
                        }

                    }

                }


            }

        }

    }

    fun sendMessage(
        messageText: String
    ) = launchIoCoroutine(
        error = {
            errorAction()
        }
    ) {
        val message = Message(
            chatId = chatId,
            message = messageText,
            userId = userId
        )

        sendMessageUseCase.execute(message.toDomain())

    }

    fun setErrorState(isError: Boolean) {
        _state.update {
            it.copy(isError = isError)
        }
    }
    private fun errorAction(){
        _state.update {
            it.copy(
                isError = true,
                isLoading = false
            )
        }
    }
    companion object {

        const val ASSISTED_INJECT_CHAT_ID_KEY = "ChatId"
    }
}