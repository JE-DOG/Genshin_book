package com.example.data.chats.list.di

import dagger.Component

@DataChatsListScope
@Component(
    modules = [
        DataChatsListModule::class
    ],
    dependencies = [
        DataChatsListDeps::class
    ]
)
interface DataChatsListComponent {

    @Component.Factory
    interface Factory {

        fun create(
            dataChatsListDeps: DataChatsListDeps
        ): DataChatsListComponent

    }

}