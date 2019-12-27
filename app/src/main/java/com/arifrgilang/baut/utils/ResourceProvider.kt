/*
 * *
 *  * Created by Arif R. Gilang on 12/27/19 7:15 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/27/19 7:15 AM
 *
 */

package com.arifrgilang.baut.utils

import android.content.Context

class ResourceProvider(mContext: Context) {
    private val mContext: Context
    fun getString(resId: Int): String {
        return mContext.getString(resId)
    }

    fun getString(resId: Int, value: String?): String {
        return mContext.getString(resId, value)
    }

    init {
        this.mContext = mContext
    }
}