package com.example.core.app.base

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class BaseFragment(
    @LayoutRes
    layout: Int
): Fragment(layout) {

    open fun initUi() = Unit
    open fun initDependencies() = Unit
    open fun clear() = Unit
    open suspend fun observeState() = Unit

    override fun onAttach(context: Context) {
        initDependencies()
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initUi()
        lifecycleScope.launch(Dispatchers.Main) {
            observeState()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        clear()
    }

}