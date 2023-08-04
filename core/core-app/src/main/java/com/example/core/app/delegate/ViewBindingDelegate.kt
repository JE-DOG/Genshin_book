package com.example.core.app.delegate

import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

typealias Binder<VB> = (View) -> VB

fun<VB: ViewBinding> Fragment.viewBinding(
    binder: Binder<VB>
): ViewBindingDelegate<VB> = ViewBindingDelegate(binder)


class ViewBindingDelegate<VB: ViewBinding>(
    private val binder: Binder<VB>
):ReadOnlyProperty<Fragment,ViewBinding> {

    @Volatile
    private var viewBinding: VB? = null

    override fun getValue(thisRef: Fragment, property: KProperty<*>): VB{
        return viewBinding ?: let {
            binder(thisRef.requireView()).also {
                viewBinding = it
            }
        }
    }
}