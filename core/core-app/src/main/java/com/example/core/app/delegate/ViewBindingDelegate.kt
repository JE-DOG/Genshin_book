package com.example.core.app.delegate

import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
import androidx.lifecycle.Lifecycle
import androidx.viewbinding.ViewBinding
import com.example.core.ext.isNull
import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

typealias Binder<VB> = (View) -> VB

fun<VB: ViewBinding> Fragment.viewBinding(
    binder: Binder<VB>,
): ViewBindingDelegate<VB> = ViewBindingDelegate(binder)


class ViewBindingDelegate<VB: ViewBinding>(
    private val binder: Binder<VB>
):ReadOnlyProperty<Fragment,ViewBinding> {

    @Volatile
    private var viewBinding: VB? = null
    @Volatile
    private var view: View? = null

    override fun getValue(thisRef: Fragment, property: KProperty<*>): VB{
        if (view != thisRef.requireView()){
            view = thisRef.requireView()
            return binder(view!!).also {
                viewBinding = it
            }
        }
        return viewBinding!!

    }

}