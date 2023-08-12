package com.example.feature.chat.dialog.di.component

import androidx.lifecycle.ViewModel
import com.example.feature.chat.dialog.di.component.deps.FeatureChatDialogDepsStore

class FeatureChatDialogViewModel: ViewModel() {

    val component = DaggerFeatureChatDialogComponent.factory().create(FeatureChatDialogDepsStore.featureChatDialogDeps)

}