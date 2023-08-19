package com.example.feature.authorization.di.deps

import kotlin.properties.Delegates.notNull

object FeatureAuthorizationDepsStore: FeatureAuthorizationComponentDepsProvider {

    override var deps: FeatureAuthorizationDeps by notNull()

}