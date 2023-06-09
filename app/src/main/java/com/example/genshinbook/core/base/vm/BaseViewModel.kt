package com.example.genshinbook.core.base.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.genshinbook.BuildConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class BaseViewModel: ViewModel() {

    private fun launchCoroutine(
        error: () -> Unit = {},
        finally: () -> Unit = {},
        block: suspend CoroutineScope.() -> Unit
    ){
        viewModelScope.launch {

            try {
                block()
            }catch (e: Exception){
                if (!BuildConfig.DEBUG){
                    Log.e("Error",e.toString())
                }
                error()
            }finally {
                finally()
            }

        }
    }

    protected fun launchIoCoroutine(
        error: () -> Unit = {},
        finally: () -> Unit = {},
        block: suspend CoroutineScope.() -> Unit
    ){
        launchCoroutine(
            error, finally
        ){
            withContext(Dispatchers.IO,block)
        }
    }

    protected fun launchDefaultCoroutine(
        error: () -> Unit = {},
        finally: () -> Unit = {},
        block: suspend CoroutineScope.() -> Unit
    ){
        launchCoroutine(
            error, finally
        ){
            withContext(Dispatchers.Default,block)
        }
    }

}