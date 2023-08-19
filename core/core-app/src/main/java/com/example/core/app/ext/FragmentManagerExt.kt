package com.example.core.app.ext

import androidx.fragment.app.FragmentManager

val FragmentManager.currentFragmentInBackStack
    get() = this.fragments.first()