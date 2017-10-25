package de.acando.vinyl.util

import android.arch.lifecycle.LiveData
import android.support.annotation.WorkerThread
import android.arch.lifecycle.MediatorLiveData
import android.support.annotation.MainThread
import android.support.annotation.NonNull
import android.support.annotation.Nullable
import de.acando.vinyl.AppExecutor

abstract class NetworkBoundResource<ResultType> constructor(private val appExecutors: AppExecutor) {

    private val result = MediatorLiveData<ResultType>()

    init {
        initResource()
    }

    @MainThread
    private fun initResource() {
        val testSource = loadData()
        result.addSource(testSource, { data ->
            if (shouldFetch(data!!)) {
                result.removeSource(testSource)
                fetchFromNetwork()
            } else {
                result.setValue(data)
            }
        })
    }

    private fun fetchFromNetwork() {
        val apiResponse = createCall()
        result.addSource(apiResponse, { response ->
            result.removeSource(apiResponse)

            appExecutors.diskIO().execute({
                saveCallResult(response!!)
                appExecutors.mainThread().execute({
                    val resultSource = loadData()
                    result.addSource(resultSource, { newData ->
                        result.value = newData
                    })
                }
                )
            })
        })
    }

    fun asLiveData(): LiveData<ResultType> {
        return result
    }

    @WorkerThread
    protected fun saveCallResult(data: ResultType) {
    }

    @MainThread
    protected abstract fun shouldFetch(@Nullable data: ResultType): Boolean

    @MainThread
    protected abstract fun loadData(): LiveData<ResultType>

    @MainThread
    @NonNull
    protected abstract fun createCall(): LiveData<ResultType>
}