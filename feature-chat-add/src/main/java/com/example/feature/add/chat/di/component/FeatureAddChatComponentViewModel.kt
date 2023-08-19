package com.example.feature.add.chat.di.component

import androidx.lifecycle.ViewModel

class FeatureAddChatComponentViewModel: ViewModel() {

    val component = DaggerFeatureAddChatComponent.factory().create(FeatureAddChatDepsStore.deps)

}