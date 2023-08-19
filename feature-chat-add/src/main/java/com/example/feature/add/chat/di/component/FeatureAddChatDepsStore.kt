package com.example.feature.add.chat.di.component

import kotlin.properties.Delegates.notNull

object FeatureAddChatDepsStore: FeatureAddChatDepsProvider {

    override var deps: FeatureAddChatDeps by notNull()

}