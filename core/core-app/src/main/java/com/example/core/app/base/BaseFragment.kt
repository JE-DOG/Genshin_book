package com.example.core.app.base

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseFragment(
    @LayoutRes
    layout: Int
): Fragment(layout) {

    open fun initUi() = Unit
    open fun initDependencies() = Unit
    open fun clear() = Unit

    override fun onAttach(context: Context) {
        super.onAttach(context)
        initDependencies()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initUi()
    }

    override fun onDestroy() {
        super.onDestroy()
        clear()
    }

}