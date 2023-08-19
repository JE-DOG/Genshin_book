package com.example.feature.add.chat.di.component

interface FeatureAddChatDepsProvider {

    val deps: FeatureAddChatDeps

    companion object : FeatureAddChatDepsProvider by FeatureAddChatDepsStore
}