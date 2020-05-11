/*
 * *
 *  * Created by Arif R. Gilang on 12/27/19 7:33 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/27/19 7:33 AM
 *
 */

package com.arifrgilang.baut.utils

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

class CustomViewPager : ViewPager {

    private var isPagingEnabled = true

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return this.isPagingEnabled && super.onTouchEvent(event)
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        return this.isPagingEnabled && super.onInterceptTouchEvent(event)
    }

    fun setPagingEnabled(b: Boolean) {
        this.isPagingEnabled = b
    }
}