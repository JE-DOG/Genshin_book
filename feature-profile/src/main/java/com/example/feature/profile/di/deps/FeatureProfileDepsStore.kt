package com.example.feature.profile.di.deps

import kotlin.properties.Delegates.notNull


object FeatureProfileDepsStore: FeatureProfileDepsProvider {

    override var deps: FeatureProfileDeps by notNull()

}