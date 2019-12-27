/*
 * *
 *  * Created by Arif R. Gilang on 12/27/19 7:14 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/27/19 7:14 AM
 *
 */

package com.arifrgilang.baut.base

import android.app.Application
import com.arifrgilang.baut.utils.ResourceProvider

class BaseApplication : Application() {

    private var mResourceProvider: ResourceProvider? = null
    open fun getResourceProvider(): ResourceProvider? {
        if (mResourceProvider == null) mResourceProvider = ResourceProvider(this)
        return mResourceProvider
    }

    override fun onCreate() {
        super.onCreate()
//        Hawk.init(this).build()
    }
}