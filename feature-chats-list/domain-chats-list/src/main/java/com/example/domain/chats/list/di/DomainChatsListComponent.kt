package com.example.domain.chats.list.di

import dagger.Component

@DomainChatsListScope
@Component(
    modules = [
        DomainChatsListModule::class
    ],
    dependencies = [
        DomainChatsListDeps::class
    ]
)
interface DomainChatsListComponent {

    @Component.Factory
    interface Factory{

        fun create(
            domainChatsListDeps: DomainChatsListDeps
        ): DomainChatsListComponent

    }

}