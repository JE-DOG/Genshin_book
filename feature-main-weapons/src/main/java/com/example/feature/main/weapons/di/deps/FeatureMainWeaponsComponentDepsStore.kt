package com.example.feature.main.weapons.di.deps

import kotlin.properties.Delegates.notNull

object FeatureMainWeaponsComponentDepsStore: FeatureMainWeaponsComponentDepsProvider {

    override var deps: FeatureMainWeaponsComponentDeps by notNull()

}