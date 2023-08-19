package com.example.feature.chats.list.di.component

import androidx.lifecycle.ViewModel

class FeatureChatsListComponentViewModel: ViewModel() {

    val component = DaggerFeatureChatsListComponent.factory().create(FeatureChatsListDepsStore.deps)

}