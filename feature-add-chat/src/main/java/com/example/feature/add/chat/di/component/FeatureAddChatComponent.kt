package com.example.feature.add.chat.di.component

import com.example.feature.add.chat.FragmentAddChat
import com.example.feature.add.chat.di.module.DataFeatureAddChatModule
import com.example.feature.add.chat.di.module.DomainFeatureAddChatModule
import dagger.Component

@FeatureAddChatScope
@Component(
    modules = [
        DomainFeatureAddChatModule::class,
        DataFeatureAddChatModule::class
    ],
    dependencies = [
        FeatureAddChatDeps::class
    ]
)
interface FeatureAddChatComponent {

    fun inject(fragmentAddChat: FragmentAddChat)

}