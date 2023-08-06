package com.example.feature.add.chat.di.component

interface FeatureAddChatDepsProvider {

    val featureAddChatDeps: FeatureAddChatDeps

    companion object : FeatureAddChatDepsProvider by FeatureAddChatDepsStore
}