package com.example.feature.profile.di.vm

import androidx.lifecycle.ViewModel
import com.example.feature.profile.di.DaggerFeatureProfileComponent
import com.example.feature.profile.di.deps.FeatureProfileDepsStore

class FeatureProfileDepsViewModel: ViewModel() {

    val component = DaggerFeatureProfileComponent.factory().create(FeatureProfileDepsStore.deps)

}