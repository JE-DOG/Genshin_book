package com.example.feature.chats.list.di.component

import androidx.lifecycle.ViewModel
import com.example.feature.chats.list.di.component.DaggerFeatureChatsListComponent
import com.example.feature.chats.list.di.component.FeatureChatsListDepsStore

class FeatureChatsListComponentViewModel: ViewModel() {

    val component = DaggerFeatureChatsListComponent.factory().create(FeatureChatsListDepsStore.featureChatsListDeps)

}