/*
 * *
 *  * Created by Arif R. Gilang on 12/27/19 7:18 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/27/19 7:18 AM
 *
 */

package com.arifrgilang.baut.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.arifrgilang.baut.data.remote.DataManager
import com.arifrgilang.baut.utils.AppShared
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel(application: Application): AndroidViewModel(application),
    CoroutineScope {
    private val job = Job()

    protected val dataManager: DataManager = AppShared.dataManager()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}