package com.example.feature.chat.dialog.di.component

import com.example.feature.chat.dialog.ChatDialogFragment
import com.example.feature.chat.dialog.di.component.deps.FeatureChatDialogDeps
import com.example.feature.chat.dialog.di.modules.DataModule
import com.example.feature.chat.dialog.di.modules.DomainModule
import dagger.Component

@FeatureChatDialogScope
@Component(
    modules = [
        DomainModule::class,
        DataModule::class
    ],
    dependencies = [
        FeatureChatDialogDeps::class
    ]
)
interface FeatureChatDialogComponent {

    fun inject(chatDialogFragment: ChatDialogFragment)

    @Component.Factory
    interface Factory {
        fun create(
            featureChatDialogDeps: FeatureChatDialogDeps
        ): FeatureChatDialogComponent

    }

}