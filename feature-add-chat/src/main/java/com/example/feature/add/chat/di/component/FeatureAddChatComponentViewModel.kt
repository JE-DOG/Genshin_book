package com.example.feature.add.chat.di.component

import androidx.lifecycle.ViewModel
import com.example.feature.chats.list.di.component.FeatureChatsListDepsStore

class FeatureAddChatComponentViewModel: ViewModel() {

    val component = DaggerFeatureAddChatComponent.factory().create(FeatureAddChatDepsStore.featureAddChatDeps)

}