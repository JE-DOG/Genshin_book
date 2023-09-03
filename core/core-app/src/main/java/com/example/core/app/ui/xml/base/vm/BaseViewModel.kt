package com.example.core.app.ui.xml.base.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class BaseViewModel: ViewModel() {

    protected val subscribers = CompositeDisposable()

    override fun onCleared() {
        subscribers.clear()
    }

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