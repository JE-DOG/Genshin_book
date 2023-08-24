package com.example.feature.characters.di.deps

import kotlin.properties.Delegates.notNull

object FeatureCharactersDepsStore: FeatureCharactersDepsProvider {

    override var deps: FeatureCharactersDeps by notNull()

}