package com.example.feature.chat.dialog.di.component.deps

import kotlin.properties.Delegates.notNull

object FeatureChatDialogDepsStore: FeatureChatDialogDepsProvider {

    override var featureChatDialogDeps: FeatureChatDialogDeps by notNull()

}