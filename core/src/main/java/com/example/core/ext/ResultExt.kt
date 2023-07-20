package com.example.core.ext

import android.util.Log
import retrofit2.Response

fun<T: Any> Response<T>.log(logName: String){

    Log.d(logName,"--------------------------------")
    if (this.isSuccessful)
        Log.d(logName,this.body().toString())
    else
        this.errorBody()?.let { Log.d(logName,it.string()) }
    Log.d(logName,"--------------------------------")

}