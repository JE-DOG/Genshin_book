package com.example.feature.add.chat.di.module

import com.example.add.chat.domain.AddChatRepository
import com.example.add.chat.domain.use_case.AddChatUseCase
import com.example.add.chat.domain.use_case.FindUserUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainFeatureAddChatModule {

    @Provides
    fun provideAddChatUseCase(
        addChatRepository: AddChatRepository
    ): AddChatUseCase {
        return AddChatUseCase(addChatRepository)
    }

    @Provides
    fun provideFindUserUseCase(
        addChatRepository: AddChatRepository
    ): FindUserUseCase {
        return FindUserUseCase(addChatRepository)
    }

}