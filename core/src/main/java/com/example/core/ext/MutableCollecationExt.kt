package com.example.core.ext

fun<T> MutableList<T>.replaceItem(find: T,replace: T): Boolean{

    val index = this.lastIndexOf(find)
    if(index != -1){
        this[index] = replace
        return true
    }
    return false
}
