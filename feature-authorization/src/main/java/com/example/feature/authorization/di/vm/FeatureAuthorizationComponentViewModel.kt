package com.example.feature.authorization.di.vm

import androidx.lifecycle.ViewModel
import com.example.feature.authorization.di.DaggerFeatureAuthorizationComponent
import com.example.feature.authorization.di.deps.FeatureAuthorizationDepsStore

class FeatureAuthorizationComponentViewModel: ViewModel() {

    val component = DaggerFeatureAuthorizationComponent.factory().create(FeatureAuthorizationDepsStore.deps)

}