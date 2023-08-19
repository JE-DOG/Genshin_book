package com.example.feature.chats.list.di.component

import kotlin.properties.Delegates.notNull

object FeatureChatsListDepsStore: FeatureChatsListDepsProvider {

    override var deps: FeatureChatsListDeps by notNull()

}