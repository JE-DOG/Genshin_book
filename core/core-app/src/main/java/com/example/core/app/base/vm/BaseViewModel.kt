package com.example.core.app.base.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class BaseViewModel: ViewModel() {

    private fun launchCoroutine(
        error: (e: Exception) -> Unit = {},
        finally: () -> Unit = {},
        block: suspend CoroutineScope.() -> Unit
    ){
        viewModelScope.launch {

            try {
                block()
            }catch (e: Exception){
                error(e)
                Log.e("ErrorTag",e.localizedMessage)
            }finally {
                finally()
            }

        }
    }

    protected fun launchIoCoroutine(
        error: (e: Exception) -> Unit = {},
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
        error: (e: Exception) -> Unit = {},
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