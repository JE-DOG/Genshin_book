package com.example.core.app.ext

import android.annotation.SuppressLint
import io.reactivex.Single
import io.reactivex.disposables.Disposable

@SuppressLint("CheckResult")
inline fun<T> Single<T>.subscribe(
    crossinline onError: (Throwable) -> Unit = {},
    crossinline onSuccess: (T) -> Unit = {}
): Disposable {
    return this.subscribe(
        {
            onSuccess(it)
        },
        {
            onError(it)
        }
    )

}
// TODO: Learn what is crossinline