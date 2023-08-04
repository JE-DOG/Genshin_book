package com.example.feature.chats.list.di.component

interface FeatureChatsListDepsProvider {

    val featureChatsListDeps: FeatureChatsListDeps

    companion object : FeatureChatsListDepsProvider by FeatureChatsListDepsStore
}
