package com.example.core.app.ext

import androidx.lifecycle.MutableLiveData

inline fun<T> MutableLiveData<T>.update(action: (T) -> T) {

    this.value = action(this.value!!)

}

inline fun<T> MutableLiveData<T>.updatePostValue(action: (T) -> T) {

    this.postValue(
        action(this.value!!)
    )

}

