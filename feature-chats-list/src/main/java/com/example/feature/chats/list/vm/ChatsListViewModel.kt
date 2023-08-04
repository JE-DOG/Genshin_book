package com.example.feature.chats.list.vm

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.core.app.base.vm.BaseViewModel
import com.example.core.ext.replaceItem
import com.example.data.chats.list.network.model.ChatJson
import com.example.domain.chats.list.use_cases.BroadcastUserChatsUseCase
import com.example.domain.chats.list.use_cases.GetUserChatUseCase
import com.example.domain.chats.list.use_cases.GetUserChatsUseCase
import com.example.feature.chats.list.model.Chat
import io.github.jan.supabase.realtime.PostgresAction
import io.github.jan.supabase.realtime.decodeOldRecord
import io.github.jan.supabase.realtime.decodeRecord
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class ChatsListViewModel @Inject constructor(
    private val broadcastUserChatsUseCase: BroadcastUserChatsUseCase,
    private val getUserChatsUseCase: GetUserChatsUseCase,
    private val getUserChatUseCase: GetUserChatUseCase,
): BaseViewModel() {

    private val _state = MutableStateFlow(ChatsListViewState())
    val state = _state

    @Volatile
    private var chatIsBroadcast = false

    init {
        getChats()
    }

    fun getChats() {

        launchIoCoroutine(
            error = {
                _state.value = state.value.copy(
                    isError = true,
                    isLoading = false
                )
            }
        ) {

            _state.value = state.value.copy(
                isLoading = true
            )

            getUserChatsUseCase.execute().collect {
                _state.value = state.value.copy(
                    chats = it.map {
                        Chat.fromDomain(it)
                    }.toMutableList(),
                    isError = false,
                    isLoading = false
                )
            }

            if (!chatIsBroadcast) {

                chatIsBroadcast = true

                launch {

                    broadcastUserChatsUseCase.execute().collect { action ->

                        val chats = state.value.chats

                        when (action) {

                            is PostgresAction.Update -> {
                                val chatId = action.decodeRecord<ChatJson>().id
                                val chat = getUserChatUseCase.execute(chatId).single()

                                val replaceChat = state.value.chats.find {
                                    it.id == chat.id
                                }

                                replaceChat?.let { replaceChat ->
                                    chats.replaceItem(
                                        replaceChat,
                                        Chat.fromDomain(chat)
                                    )
                                }

                            }

                            is PostgresAction.Insert -> {
                                val chatJson = action.decodeRecord<ChatJson>()
                                val chat = getUserChatUseCase.execute(chatJson).single()

                                chats.add(Chat.fromDomain(chat))
                            }

                            is PostgresAction.Delete -> {
                                val chat = action.decodeOldRecord<ChatJson>()

                                chats.removeIf { it.id == chat.id }
                            }

                            else -> {}

                        }

                        _state.update {
                            it.copy(
                                chats = chats,
                                update = !it.update
                            )
                        }

                        Log.d("RealtimeTag", _state.value.chats.toString())

                    }

                }

            }
        }

    }

    fun setState(setState: ChatsListViewState){
        _state.value = setState
    }

}