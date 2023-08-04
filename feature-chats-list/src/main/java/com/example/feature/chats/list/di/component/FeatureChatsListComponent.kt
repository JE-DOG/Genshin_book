package com.example.feature.chats.list.di.component

import com.example.feature.chats.list.ChatsListFragment
import com.example.feature.chats.list.di.modules.DataChatsListModule
import com.example.feature.chats.list.di.modules.DomainChatsListModule
import dagger.Component

@FeatureChatsListScope
@Component(
    modules = [
        DomainChatsListModule::class,
        DataChatsListModule::class
    ],
    dependencies = [
        FeatureChatsListDeps::class
    ]
)
interface FeatureChatsListComponent {

    fun inject(chatsListFragment: ChatsListFragment)

    @Component.Factory
    interface Factory {

        fun create(
            featureChatsListDeps: FeatureChatsListDeps
        ): FeatureChatsListComponent

    }

}
