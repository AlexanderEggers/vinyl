package com.acando.vinyl

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppExecutor {

    private var diskIO: Executor = null!!
    private var mainThread: Executor = null!!

    private fun AppExecutors(diskIO: Executor, mainThread: Executor) {
        this.diskIO = diskIO
        this.mainThread = mainThread
    }

    @Inject
    fun AppExecutors() {
        AppExecutors(Executors.newSingleThreadExecutor(), MainThreadExecutor())
    }

    fun diskIO(): Executor {
        return diskIO
    }

    fun mainThread(): Executor {
        return mainThread
    }

    private class MainThreadExecutor : Executor {
        private val mainThreadHandler = Handler(Looper.getMainLooper())

        override fun execute(command: Runnable) {
            mainThreadHandler.post(command)
        }
    }
}