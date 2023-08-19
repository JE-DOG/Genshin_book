package com.example.feature.chats.list.di.component

interface FeatureChatsListDepsProvider {

    val deps: FeatureChatsListDeps

    companion object : FeatureChatsListDepsProvider by FeatureChatsListDepsStore
}
